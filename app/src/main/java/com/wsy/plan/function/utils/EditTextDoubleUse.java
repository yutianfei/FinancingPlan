package com.wsy.plan.function.utils;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.wsy.plan.R;
import com.wsy.plan.function.model.FunctionAssignModel;
import com.wsy.plan.function.presenter.IFunctionModelPresenter;
import com.wsy.plan.function.presenter.LocalPresenter;

public class EditTextDoubleUse implements TextView.OnEditorActionListener {

    private View rootView;
    private FunctionAssignModel model;
    private int flag;
    private IFunctionModelPresenter presenter;

    public static EditTextDoubleUse getInstance(View rootView, FunctionAssignModel model, int flag) {
        return new EditTextDoubleUse(rootView, model, flag);
    }

    private EditTextDoubleUse(View rootView, FunctionAssignModel model, int flag) {
        this.rootView = rootView;
        this.model = model;
        this.flag = flag;
        presenter = new LocalPresenter();
    }

    public void initEditText() {
        EditText editMonthIncome = (EditText) rootView.findViewById(R.id.fa_month_income_input);
        EditText editTaxes = (EditText) rootView.findViewById(R.id.fa_taxes_input);
        EditText editAfterTaxes = (EditText) rootView.findViewById(R.id.fa_after_taxes_input);
        EditText editAfterTaxesPercent = (EditText) rootView.findViewById(R.id.fa_after_taxes_fixed);
        EditText editFinance = (EditText) rootView.findViewById(R.id.fa_finance_input);
        EditText editFinancePercent = (EditText) rootView.findViewById(R.id.fa_finance_fixed);
        EditText editGrow = (EditText) rootView.findViewById(R.id.fa_grow_input);
        EditText editGrowPercent = (EditText) rootView.findViewById(R.id.fa_grow_fixed);
        EditText editPlay = (EditText) rootView.findViewById(R.id.fa_play_input);
        EditText editPlayPercent = (EditText) rootView.findViewById(R.id.fa_play_fixed);
        EditText editLongPlan = (EditText) rootView.findViewById(R.id.fa_long_plan_input);
        EditText editLongPlanPercent = (EditText) rootView.findViewById(R.id.fa_long_plan_fixed);
        EditText editPrepare1 = (EditText) rootView.findViewById(R.id.fa_prepare_1_input);
        EditText editPrepare1Percent = (EditText) rootView.findViewById(R.id.fa_prepare_1_fixed);
        EditText editPrepare2 = (EditText) rootView.findViewById(R.id.fa_prepare_2_input);
        EditText editPrepare2Percent = (EditText) rootView.findViewById(R.id.fa_prepare_2_fixed);
        EditText editPrepare3 = (EditText) rootView.findViewById(R.id.fa_prepare_3_input);
        EditText editPrepare3Percent = (EditText) rootView.findViewById(R.id.fa_prepare_3_fixed);
        EditText editNecessary = (EditText) rootView.findViewById(R.id.fa_necessary_input);
        EditText editNecessaryPercent = (EditText) rootView.findViewById(R.id.fa_necessary_fixed);
        EditText editLeft = (EditText) rootView.findViewById(R.id.fa_left_input);

        editMonthIncome.setOnEditorActionListener(this);
        editTaxes.setOnEditorActionListener(this);
        editAfterTaxes.setOnEditorActionListener(this);
        editAfterTaxesPercent.setOnEditorActionListener(this);
        editFinance.setOnEditorActionListener(this);
        editFinancePercent.setOnEditorActionListener(this);
        editGrow.setOnEditorActionListener(this);
        editGrowPercent.setOnEditorActionListener(this);
        editPlay.setOnEditorActionListener(this);
        editPlayPercent.setOnEditorActionListener(this);
        editLongPlan.setOnEditorActionListener(this);
        editLongPlanPercent.setOnEditorActionListener(this);
        editPrepare1.setOnEditorActionListener(this);
        editPrepare1Percent.setOnEditorActionListener(this);
        editPrepare2.setOnEditorActionListener(this);
        editPrepare2Percent.setOnEditorActionListener(this);
        editPrepare3.setOnEditorActionListener(this);
        editPrepare3Percent.setOnEditorActionListener(this);
        editNecessary.setOnEditorActionListener(this);
        editNecessaryPercent.setOnEditorActionListener(this);
        editLeft.setOnEditorActionListener(this);

        model.setData(presenter.getDBModel(flag));
    }

    @Override
    public boolean onEditorAction(TextView v, int i, KeyEvent keyEvent) {
        if (i == EditorInfo.IME_ACTION_DONE) {
            compute();
            /* 隐藏软键盘 */
            InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            if (imm.isActive()) {
                imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
            }
            return true;
        }
        return false;
    }

    /**
     * 重新计算并显示
     */
    private void compute() {
        model.month_income.set("5000");
        model.after_taxes.set("3000");
    }
}
