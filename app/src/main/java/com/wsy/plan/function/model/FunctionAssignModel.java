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
    public static final int FA_FLAG_PERCENT = 1;
    /**
     * 依金额
     */
    public static final int FA_FLAG_CASH = 2;

    /**
     * 标志：区分依百分比和依金额（百分比：1；金额：2）
     */
    private int fa_flag;
    /**
     * 月收入
     */
    public ObservableField<String> fa_month_income = new ObservableField<>();
    /**
     * 预扣所得税
     */
    public ObservableField<String> fa_taxes = new ObservableField<>();
    /**
     * 每月税后收入
     */
    public ObservableField<String> fa_after_taxes = new ObservableField<>();
    /**
     * 每月税后收入百分比
     */
    public ObservableField<String> fa_after_taxes_percent = new ObservableField<>();
    /**
     * 投资理财账户
     */
    public ObservableField<String> fa_finance = new ObservableField<>();
    /**
     * 投资理财账户百分比
     */
    public ObservableField<String> fa_finance_percent = new ObservableField<>();
    /**
     * 自我成长账户
     */
    public ObservableField<String> fa_grow = new ObservableField<>();
    /**
     * 自我成长账户百分比
     */
    public ObservableField<String> fa_grow_percent = new ObservableField<>();
    /**
     * 尽情娱乐账户
     */
    public ObservableField<String> fa_play = new ObservableField<>();
    /**
     * 尽情娱乐账户百分比
     */
    public ObservableField<String> fa_play_percent = new ObservableField<>();
    /**
     * 长期计划账户
     */
    public ObservableField<String> fa_long_plan = new ObservableField<>();
    /**
     * 长期计划账户百分比
     */
    public ObservableField<String> fa_long_plan_percent = new ObservableField<>();
    /**
     * 预备账户1
     */
    public ObservableField<String> fa_prepare_1 = new ObservableField<>();
    /**
     * 预备账户1百分比
     */
    public ObservableField<String> fa_prepare_1_percent = new ObservableField<>();
    /**
     * 预备账户2
     */
    public ObservableField<String> fa_prepare_2 = new ObservableField<>();
    /**
     * 预备账户2百分比
     */
    public ObservableField<String> fa_prepare_2_percent = new ObservableField<>();
    /**
     * 预备账户3
     */
    public ObservableField<String> fa_prepare_3 = new ObservableField<>();
    /**
     * 预备账户3百分比
     */
    public ObservableField<String> fa_prepare_3_percent = new ObservableField<>();
    /**
     * 生活必需支出
     */
    public ObservableField<String> fa_necessary = new ObservableField<>();
    /**
     * 生活必需支出百分比
     */
    public ObservableField<String> fa_necessary_percent = new ObservableField<>();
    /**
     * 剩余可支配金额
     */
    public ObservableField<String> fa_left = new ObservableField<>();

    /**
     * 设置数据库数据填充
     */
    public void setData(FunctionAssignDBModel dbModel) {
        fa_flag = dbModel.fa_flag;
        fa_month_income.set(dbModel.fa_month_income);
        fa_taxes.set(dbModel.fa_taxes);
        fa_after_taxes.set(dbModel.fa_after_taxes);
        fa_after_taxes_percent.set(dbModel.fa_after_taxes_percent);
        fa_finance.set(dbModel.fa_finance);
        fa_finance_percent.set(dbModel.fa_finance_percent);
        fa_grow.set(dbModel.fa_grow);
        fa_grow_percent.set(dbModel.fa_grow_percent);
        fa_play.set(dbModel.fa_play);
        fa_play_percent.set(dbModel.fa_play_percent);
        fa_long_plan.set(dbModel.fa_long_plan);
        fa_long_plan_percent.set(dbModel.fa_long_plan_percent);
        fa_prepare_1.set(dbModel.fa_prepare_1);
        fa_prepare_1_percent.set(dbModel.fa_prepare_1_percent);
        fa_prepare_2.set(dbModel.fa_prepare_2);
        fa_prepare_2_percent.set(dbModel.fa_prepare_2_percent);
        fa_prepare_3.set(dbModel.fa_prepare_3);
        fa_prepare_3_percent.set(dbModel.fa_prepare_3_percent);
        fa_necessary.set(dbModel.fa_necessary);
        fa_necessary_percent.set(dbModel.fa_necessary_percent);
        fa_left.set(dbModel.fa_left);
    }
}
