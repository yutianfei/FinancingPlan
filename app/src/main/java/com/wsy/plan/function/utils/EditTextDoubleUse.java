package com.wsy.plan.function.utils;

import android.graphics.Color;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import com.wsy.plan.R;
import com.wsy.plan.common.BigDecimalUtils;
import com.wsy.plan.common.Constants;
import com.wsy.plan.common.MyTextChangedListener;
import com.wsy.plan.function.model.FunctionAssignDBModel;
import com.wsy.plan.function.model.FunctionAssignModel;
import com.wsy.plan.function.presenter.IFunctionModelPresenter;
import com.wsy.plan.function.presenter.LocalPresenter;

public class EditTextDoubleUse {

    private int flag;
    private FunctionAssignModel model;
    private IFunctionModelPresenter presenter = new LocalPresenter();
    private FunctionAssignDBModel dbModel;
    private FunctionAssignDBModel dbModelOriginal; // 用于比较数据是否发生变化

    private View rootView;
    private EditText editLeft;

    private MyTextChangedListener listener = new MyTextChangedListener() {
        @Override
        public void doSomething(Editable editable) {
            compute();
        }
    };

    public static EditTextDoubleUse getInstance(View rootView, FunctionAssignModel model, int flag) {
        return new EditTextDoubleUse(rootView, model, flag);
    }

    private EditTextDoubleUse(View rootView, FunctionAssignModel model, int flag) {
        this.rootView = rootView;
        this.model = model;
        this.flag = flag;
    }

    public void initData() {
        editLeft = (EditText) rootView.findViewById(R.id.fa_left_fixed);
        ((EditText) rootView.findViewById(R.id.fa_month_income_input)).addTextChangedListener(listener);
        ((EditText) rootView.findViewById(R.id.fa_taxes_input)).addTextChangedListener(listener);
        ((EditText) rootView.findViewById(R.id.fa_finance_input)).addTextChangedListener(listener);
        ((EditText) rootView.findViewById(R.id.fa_grow_input)).addTextChangedListener(listener);
        ((EditText) rootView.findViewById(R.id.fa_play_input)).addTextChangedListener(listener);
        ((EditText) rootView.findViewById(R.id.fa_long_plan_input)).addTextChangedListener(listener);
        ((EditText) rootView.findViewById(R.id.fa_prepare_1_input)).addTextChangedListener(listener);
        ((EditText) rootView.findViewById(R.id.fa_prepare_2_input)).addTextChangedListener(listener);
        ((EditText) rootView.findViewById(R.id.fa_prepare_3_input)).addTextChangedListener(listener);
        ((EditText) rootView.findViewById(R.id.fa_necessary_input)).addTextChangedListener(listener);

        // 获取数据
        dbModel = presenter.getDBModel(flag);
        // 给作为比较的数据赋值
        try {
            dbModelOriginal = (FunctionAssignDBModel) dbModel.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        // 设置显示数据
        model.setData(dbModel);
    }

    /**
     * 重新计算并显示
     */
    private void compute() {
        // 月收入
        String month_income = model.fa_month_income.get();
        // 预扣税
        String taxes = model.fa_taxes.get();
        // 税后收入
        String after_taxes = BigDecimalUtils.sub(month_income, taxes);
        model.fa_after_taxes.set(after_taxes);
        // 其他数据
        switch (flag) {
            case FunctionAssignModel.FA_FLAG_PERCENT:
                setPercentData();
                break;
            case FunctionAssignModel.FA_FLAG_CASH:
                setCashData();
                break;
        }
        // 剩余可支配金额
        String[] values = {model.fa_finance.get(), model.fa_grow.get(), model.fa_play.get(), model.fa_long_plan.get(),
                model.fa_prepare_1.get(), model.fa_prepare_2.get(), model.fa_prepare_3.get(), model.fa_necessary.get()};
        model.fa_left.set(BigDecimalUtils.sub(after_taxes, BigDecimalUtils.add(values)));
        // 设置字体颜色
        editLeft.setTextColor(model.fa_left.get().contains("-") ? Color.RED : Color.parseColor("#333333"));
    }

    private void setCashData() {
        model.fa_finance_percent.set(BigDecimalUtils.divide(model.fa_finance.get(), model.fa_after_taxes.get()));
        model.fa_grow_percent.set(BigDecimalUtils.divide(model.fa_grow.get(), model.fa_after_taxes.get()));
        model.fa_play_percent.set(BigDecimalUtils.divide(model.fa_play.get(), model.fa_after_taxes.get()));
        model.fa_long_plan_percent.set(BigDecimalUtils.divide(model.fa_long_plan.get(), model.fa_after_taxes.get()));
        model.fa_prepare_1_percent.set(BigDecimalUtils.divide(model.fa_prepare_1.get(), model.fa_after_taxes.get()));
        model.fa_prepare_2_percent.set(BigDecimalUtils.divide(model.fa_prepare_2.get(), model.fa_after_taxes.get()));
        model.fa_prepare_3_percent.set(BigDecimalUtils.divide(model.fa_prepare_3.get(), model.fa_after_taxes.get()));
        model.fa_necessary_percent.set(BigDecimalUtils.divide(model.fa_necessary.get(), model.fa_after_taxes.get()));
    }

    private void setPercentData() {
        model.fa_finance.set(BigDecimalUtils.multiplyPercent(model.fa_finance_percent.get(), model.fa_after_taxes.get()));
        model.fa_grow.set(BigDecimalUtils.multiplyPercent(model.fa_grow_percent.get(), model.fa_after_taxes.get()));
        model.fa_play.set(BigDecimalUtils.multiplyPercent(model.fa_play_percent.get(), model.fa_after_taxes.get()));
        model.fa_long_plan.set(BigDecimalUtils.multiplyPercent(model.fa_long_plan_percent.get(), model.fa_after_taxes.get()));
        model.fa_prepare_1.set(BigDecimalUtils.multiplyPercent(model.fa_prepare_1_percent.get(), model.fa_after_taxes.get()));
        model.fa_prepare_2.set(BigDecimalUtils.multiplyPercent(model.fa_prepare_2_percent.get(), model.fa_after_taxes.get()));
        model.fa_prepare_3.set(BigDecimalUtils.multiplyPercent(model.fa_prepare_3_percent.get(), model.fa_after_taxes.get()));
        model.fa_necessary.set(BigDecimalUtils.multiplyPercent(model.fa_necessary_percent.get(), model.fa_after_taxes.get()));
    }

    public int update() {
        if (model.fa_left.get().contains("-")) {
            return Constants.RESULT_MORE;

        } else if (!"0".equals(model.fa_left.get())) {
            return Constants.RESULT_LESS;

        } else { // 完全分配
            // 进行赋值
            dbModel.setData(model);
            // 如果有变化，则更新并保存新数据
            if (!dbModelOriginal.equals(dbModel)) {
                // 保存修改的数据
                presenter.updateDBModel(dbModel);
                model.setData(dbModel);
                // 重新给作为比较的数据赋值
                try {
                    dbModelOriginal = (FunctionAssignDBModel) dbModel.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
                return Constants.RESULT_PERFECT;
            }
            return Constants.RESULT_NOT_CHANGED;
        }
    }
}
