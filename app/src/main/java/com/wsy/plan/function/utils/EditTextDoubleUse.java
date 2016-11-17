package com.wsy.plan.function.utils;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wsy.plan.R;
import com.wsy.plan.common.BigDecimalUtils;
import com.wsy.plan.common.MyEditorActionListener;
import com.wsy.plan.function.model.FunctionAssignDBModel;
import com.wsy.plan.function.model.FunctionAssignModel;
import com.wsy.plan.function.presenter.IFunctionModelPresenter;
import com.wsy.plan.function.presenter.LocalPresenter;

public class EditTextDoubleUse {

    private View rootView;
    private FunctionAssignModel model;
    private int flag;
    private IFunctionModelPresenter presenter = new LocalPresenter();
    private FunctionAssignDBModel dbModel;
    private FunctionAssignDBModel dbModelOriginal; // 用于比较数据是否发生变化

    private EditText editMonthIncome;
    private EditText editTaxes;
    private EditText editFinance;
    private EditText editGrow;
    private EditText editPlay;
    private EditText editLongPlan;
    private EditText editPrepare1;
    private EditText editPrepare2;
    private EditText editPrepare3;
    private EditText editNecessary;
    private EditText editLeft;

    private MyEditorActionListener myEditorActionListener = new MyEditorActionListener() {
        @Override
        public void doSomething(TextView textView) {
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

    public void initEditText() {
        editMonthIncome = (EditText) rootView.findViewById(R.id.fa_month_income_input);
        editTaxes = (EditText) rootView.findViewById(R.id.fa_taxes_input);
        editFinance = (EditText) rootView.findViewById(R.id.fa_finance_input);
        editGrow = (EditText) rootView.findViewById(R.id.fa_grow_input);
        editPlay = (EditText) rootView.findViewById(R.id.fa_play_input);
        editLongPlan = (EditText) rootView.findViewById(R.id.fa_long_plan_input);
        editPrepare1 = (EditText) rootView.findViewById(R.id.fa_prepare_1_input);
        editPrepare2 = (EditText) rootView.findViewById(R.id.fa_prepare_2_input);
        editPrepare3 = (EditText) rootView.findViewById(R.id.fa_prepare_3_input);
        editNecessary = (EditText) rootView.findViewById(R.id.fa_necessary_input);
        editLeft = (EditText) rootView.findViewById(R.id.fa_left_fixed);

        editMonthIncome.setOnEditorActionListener(myEditorActionListener);
        editTaxes.setOnEditorActionListener(myEditorActionListener);
        editFinance.setOnEditorActionListener(myEditorActionListener);
        editGrow.setOnEditorActionListener(myEditorActionListener);
        editPlay.setOnEditorActionListener(myEditorActionListener);
        editLongPlan.setOnEditorActionListener(myEditorActionListener);
        editPrepare1.setOnEditorActionListener(myEditorActionListener);
        editPrepare2.setOnEditorActionListener(myEditorActionListener);
        editPrepare3.setOnEditorActionListener(myEditorActionListener);
        editNecessary.setOnEditorActionListener(myEditorActionListener);

        // 获取数据
        dbModel = presenter.getDBModel(flag);
        // 给作为比较的数据赋值
        try {
            dbModelOriginal = (FunctionAssignDBModel) dbModel.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        // 显示数据
        updateModel();
    }

    /**
     * 重新计算并显示
     */
    private void compute() {
        // 月收入
        dbModel.month_income = editMonthIncome.getText().toString();
        // 预扣税
        dbModel.taxes = editTaxes.getText().toString();
        // 税后收入
        dbModel.after_taxes = BigDecimalUtils.sub(dbModel.month_income, dbModel.taxes);
        // 其他数据
        switch (flag) {
            case FunctionAssignModel.FLAG_PERCENT:
                setPercentData();
                break;
            case FunctionAssignModel.FLAG_CASH:
                setCashData();
                break;
        }
        // 剩余可支配金额
        String[] values = {dbModel.finance, dbModel.grow, dbModel.play, dbModel.long_plan,
                dbModel.prepare_1, dbModel.prepare_2, dbModel.prepare_3, dbModel.necessary};
        dbModel.left = BigDecimalUtils.sub(dbModel.after_taxes, BigDecimalUtils.add(values));
        // 如果有变化，则更新并保存新数据
        if (!dbModelOriginal.equals(dbModel)) {
            // 保存修改的数据
            presenter.updateDBModel(dbModel);
            // 重新给作为比较的数据赋值
            try {
                dbModelOriginal = (FunctionAssignDBModel) dbModel.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            // 更新数据显示
            updateModel();
        }
    }

    /**
     * 更新数据显示
     */
    private void updateModel() {
        // 设置数据
        model.setData(dbModel);
        // 设置字体颜色
        editLeft.setTextColor(dbModel.left.contains("-") ? Color.RED : Color.parseColor("#333333"));
    }

    private void setCashData() {
        dbModel.finance = editFinance.getText().toString();
        dbModel.finance_percent = BigDecimalUtils.divide(dbModel.finance, dbModel.after_taxes);
        dbModel.grow = editGrow.getText().toString();
        dbModel.grow_percent = BigDecimalUtils.divide(dbModel.grow, dbModel.after_taxes);
        dbModel.play = editPlay.getText().toString();
        dbModel.play_percent = BigDecimalUtils.divide(dbModel.play, dbModel.after_taxes);
        dbModel.long_plan = editLongPlan.getText().toString();
        dbModel.long_plan_percent = BigDecimalUtils.divide(dbModel.long_plan, dbModel.after_taxes);
        dbModel.prepare_1 = editPrepare1.getText().toString();
        dbModel.prepare_1_percent = BigDecimalUtils.divide(dbModel.prepare_1, dbModel.after_taxes);
        dbModel.prepare_2 = editPrepare2.getText().toString();
        dbModel.prepare_2_percent = BigDecimalUtils.divide(dbModel.prepare_2, dbModel.after_taxes);
        dbModel.prepare_3 = editPrepare3.getText().toString();
        dbModel.prepare_3_percent = BigDecimalUtils.divide(dbModel.prepare_3, dbModel.after_taxes);
        dbModel.necessary = editNecessary.getText().toString();
        dbModel.necessary_percent = BigDecimalUtils.divide(dbModel.necessary, dbModel.after_taxes);
    }

    private void setPercentData() {
        dbModel.finance_percent = formatString(editFinance.getText().toString());
        dbModel.finance = BigDecimalUtils.multiply(dbModel.finance_percent, dbModel.after_taxes);
        dbModel.grow_percent = formatString(editGrow.getText().toString());
        dbModel.grow = BigDecimalUtils.multiply(dbModel.grow_percent, dbModel.after_taxes);
        dbModel.play_percent = formatString(editPlay.getText().toString());
        dbModel.play = BigDecimalUtils.multiply(dbModel.play_percent, dbModel.after_taxes);
        dbModel.long_plan_percent = formatString(editLongPlan.getText().toString());
        dbModel.long_plan = BigDecimalUtils.multiply(dbModel.long_plan_percent, dbModel.after_taxes);
        dbModel.prepare_1_percent = formatString(editPrepare1.getText().toString());
        dbModel.prepare_1 = BigDecimalUtils.multiply(dbModel.prepare_1_percent, dbModel.after_taxes);
        dbModel.prepare_2_percent = formatString(editPrepare2.getText().toString());
        dbModel.prepare_2 = BigDecimalUtils.multiply(dbModel.prepare_2_percent, dbModel.after_taxes);
        dbModel.prepare_3_percent = formatString(editPrepare3.getText().toString());
        dbModel.prepare_3 = BigDecimalUtils.multiply(dbModel.prepare_3_percent, dbModel.after_taxes);
        dbModel.necessary_percent = formatString(editNecessary.getText().toString());
        dbModel.necessary = BigDecimalUtils.multiply(dbModel.necessary_percent, dbModel.after_taxes);
    }

    private String formatString(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.contains("%")) {
                return str + "%";
            }
            return str;
        }
        return "0%";
    }
}
