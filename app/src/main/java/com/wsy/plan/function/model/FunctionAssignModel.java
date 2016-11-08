package com.wsy.plan.function.model;

/**
 * 功能账户现金流分配数据模型
 */

public class FunctionAssignModel {

    /**
     * 依百分比
     */
    public static final String FLAG_PERCENT = "1";

    /**
     * 依金额
     */
    public static final String FLAG_CASH = "2";

    /**
     * 标志：区分依百分比和依金额（百分比：1；金额：2）
     */
    public int flag;
    /**
     * 月收入
     */
    public String month_income;
    /**
     * 预扣所得税
     */
    public String taxes;
    /**
     * 每月税后收入
     */
    public String after_taxes;
    /**
     * 每月税后收入百分比
     */
    public String after_taxes_percent;
    /**
     * 投资理财账户
     */
    public String finance;
    /**
     * 投资理财账户百分比
     */
    public String finance_percent;
    /**
     * 自我成长账户
     */
    public String grow;
    /**
     * 自我成长账户百分比
     */
    public String grow_percent;
    /**
     * 尽情娱乐账户
     */
    public String play;
    /**
     * 尽情娱乐账户百分比
     */
    public String play_percent;
    /**
     * 长期计划账户
     */
    public String long_plan;
    /**
     * 长期计划账户百分比
     */
    public String long_plan_percent;
    /**
     * 预备账户1
     */
    public String prepare_1;
    /**
     * 预备账户1百分比
     */
    public String prepare_1_percent;
    /**
     * 预备账户2
     */
    public String prepare_2;
    /**
     * 预备账户2百分比
     */
    public String prepare_2_percent;
    /**
     * 预备账户3
     */
    public String prepare_3;
    /**
     * 预备账户3百分比
     */
    public String prepare_3_percent;
    /**
     * 生活必需支出
     */
    public String necessary;
    /**
     * 生活必需支出百分比
     */
    public String necessary_percent;
    /**
     * 剩余可支配金额
     */
    public String left;

}
