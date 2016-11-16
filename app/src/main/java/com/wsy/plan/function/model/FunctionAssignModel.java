package com.wsy.plan.function.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * 功能账户现金流分配数据模型
 */
public class FunctionAssignModel extends BaseObservable {

    /**
     * 依百分比
     */
    public static final int FLAG_PERCENT = 1;
    /**
     * 依金额
     */
    public static final int FLAG_CASH = 2;

    /**
     * 标志：区分依百分比和依金额（百分比：1；金额：2）
     */
    public int flag;
    /**
     * 月收入
     */
    public ObservableField<String> month_income = new ObservableField<>();
    /**
     * 预扣所得税
     */
    public ObservableField<String> taxes = new ObservableField<>();
    /**
     * 每月税后收入
     */
    public ObservableField<String> after_taxes = new ObservableField<>();
    /**
     * 每月税后收入百分比
     */
    public ObservableField<String> after_taxes_percent = new ObservableField<>();
    /**
     * 投资理财账户
     */
    public ObservableField<String> finance = new ObservableField<>();
    /**
     * 投资理财账户百分比
     */
    public ObservableField<String> finance_percent = new ObservableField<>();
    /**
     * 自我成长账户
     */
    public ObservableField<String> grow = new ObservableField<>();
    /**
     * 自我成长账户百分比
     */
    public ObservableField<String> grow_percent = new ObservableField<>();
    /**
     * 尽情娱乐账户
     */
    public ObservableField<String> play = new ObservableField<>();
    /**
     * 尽情娱乐账户百分比
     */
    public ObservableField<String> play_percent = new ObservableField<>();
    /**
     * 长期计划账户
     */
    public ObservableField<String> long_plan = new ObservableField<>();
    /**
     * 长期计划账户百分比
     */
    public ObservableField<String> long_plan_percent = new ObservableField<>();
    /**
     * 预备账户1
     */
    public ObservableField<String> prepare_1 = new ObservableField<>();
    /**
     * 预备账户1百分比
     */
    public ObservableField<String> prepare_1_percent = new ObservableField<>();
    /**
     * 预备账户2
     */
    public ObservableField<String> prepare_2 = new ObservableField<>();
    /**
     * 预备账户2百分比
     */
    public ObservableField<String> prepare_2_percent = new ObservableField<>();
    /**
     * 预备账户3
     */
    public ObservableField<String> prepare_3 = new ObservableField<>();
    /**
     * 预备账户3百分比
     */
    public ObservableField<String> prepare_3_percent = new ObservableField<>();
    /**
     * 生活必需支出
     */
    public ObservableField<String> necessary = new ObservableField<>();
    /**
     * 生活必需支出百分比
     */
    public ObservableField<String> necessary_percent = new ObservableField<>();
    /**
     * 剩余可支配金额
     */
    public ObservableField<String> left = new ObservableField<>();

    /**
     * 设置数据库数据填充
     */
    public void setData(FunctionAssignDBModel dbModel) {
        flag = dbModel.flag;
        month_income.set(dbModel.month_income);
        taxes.set(dbModel.taxes);
        after_taxes.set(dbModel.after_taxes);
        after_taxes_percent.set(dbModel.after_taxes_percent);
        finance.set(dbModel.finance);
        finance_percent.set(dbModel.finance_percent);
        grow.set(dbModel.grow);
        grow_percent.set(dbModel.grow_percent);
        play.set(dbModel.play);
        play_percent.set(dbModel.play_percent);
        long_plan.set(dbModel.long_plan);
        long_plan_percent.set(dbModel.long_plan_percent);
        prepare_1.set(dbModel.prepare_1);
        prepare_1_percent.set(dbModel.prepare_1_percent);
        prepare_2.set(dbModel.prepare_2);
        prepare_2_percent.set(dbModel.prepare_2_percent);
        prepare_3.set(dbModel.prepare_3);
        prepare_3_percent.set(dbModel.prepare_3_percent);
        necessary.set(dbModel.necessary);
        necessary_percent.set(dbModel.necessary_percent);
        left.set(dbModel.left);
    }
}
