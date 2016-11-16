package com.wsy.plan.function.model;

import org.litepal.crud.DataSupport;

/**
 * 功能账户现金流分配数据数据库模型
 */
public class FunctionAssignDBModel extends DataSupport implements Cloneable {

    /**
     * 标志：区分依百分比和依金额（百分比：1；金额：2）
     */
    int flag;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FunctionAssignDBModel dbModel = (FunctionAssignDBModel) o;

        if (flag != dbModel.flag) return false;
        if (month_income != null ? !month_income.equals(dbModel.month_income) : dbModel.month_income != null)
            return false;
        if (taxes != null ? !taxes.equals(dbModel.taxes) : dbModel.taxes != null) return false;
        if (after_taxes != null ? !after_taxes.equals(dbModel.after_taxes) : dbModel.after_taxes != null)
            return false;
        if (after_taxes_percent != null ? !after_taxes_percent.equals(dbModel.after_taxes_percent) : dbModel.after_taxes_percent != null)
            return false;
        if (finance != null ? !finance.equals(dbModel.finance) : dbModel.finance != null)
            return false;
        if (finance_percent != null ? !finance_percent.equals(dbModel.finance_percent) : dbModel.finance_percent != null)
            return false;
        if (grow != null ? !grow.equals(dbModel.grow) : dbModel.grow != null) return false;
        if (grow_percent != null ? !grow_percent.equals(dbModel.grow_percent) : dbModel.grow_percent != null)
            return false;
        if (play != null ? !play.equals(dbModel.play) : dbModel.play != null) return false;
        if (play_percent != null ? !play_percent.equals(dbModel.play_percent) : dbModel.play_percent != null)
            return false;
        if (long_plan != null ? !long_plan.equals(dbModel.long_plan) : dbModel.long_plan != null)
            return false;
        if (long_plan_percent != null ? !long_plan_percent.equals(dbModel.long_plan_percent) : dbModel.long_plan_percent != null)
            return false;
        if (prepare_1 != null ? !prepare_1.equals(dbModel.prepare_1) : dbModel.prepare_1 != null)
            return false;
        if (prepare_1_percent != null ? !prepare_1_percent.equals(dbModel.prepare_1_percent) : dbModel.prepare_1_percent != null)
            return false;
        if (prepare_2 != null ? !prepare_2.equals(dbModel.prepare_2) : dbModel.prepare_2 != null)
            return false;
        if (prepare_2_percent != null ? !prepare_2_percent.equals(dbModel.prepare_2_percent) : dbModel.prepare_2_percent != null)
            return false;
        if (prepare_3 != null ? !prepare_3.equals(dbModel.prepare_3) : dbModel.prepare_3 != null)
            return false;
        if (prepare_3_percent != null ? !prepare_3_percent.equals(dbModel.prepare_3_percent) : dbModel.prepare_3_percent != null)
            return false;
        if (necessary != null ? !necessary.equals(dbModel.necessary) : dbModel.necessary != null)
            return false;
        if (necessary_percent != null ? !necessary_percent.equals(dbModel.necessary_percent) : dbModel.necessary_percent != null)
            return false;
        return left != null ? left.equals(dbModel.left) : dbModel.left == null;

    }

    @Override
    public int hashCode() {
        int result = flag;
        result = 31 * result + (month_income != null ? month_income.hashCode() : 0);
        result = 31 * result + (taxes != null ? taxes.hashCode() : 0);
        result = 31 * result + (after_taxes != null ? after_taxes.hashCode() : 0);
        result = 31 * result + (after_taxes_percent != null ? after_taxes_percent.hashCode() : 0);
        result = 31 * result + (finance != null ? finance.hashCode() : 0);
        result = 31 * result + (finance_percent != null ? finance_percent.hashCode() : 0);
        result = 31 * result + (grow != null ? grow.hashCode() : 0);
        result = 31 * result + (grow_percent != null ? grow_percent.hashCode() : 0);
        result = 31 * result + (play != null ? play.hashCode() : 0);
        result = 31 * result + (play_percent != null ? play_percent.hashCode() : 0);
        result = 31 * result + (long_plan != null ? long_plan.hashCode() : 0);
        result = 31 * result + (long_plan_percent != null ? long_plan_percent.hashCode() : 0);
        result = 31 * result + (prepare_1 != null ? prepare_1.hashCode() : 0);
        result = 31 * result + (prepare_1_percent != null ? prepare_1_percent.hashCode() : 0);
        result = 31 * result + (prepare_2 != null ? prepare_2.hashCode() : 0);
        result = 31 * result + (prepare_2_percent != null ? prepare_2_percent.hashCode() : 0);
        result = 31 * result + (prepare_3 != null ? prepare_3.hashCode() : 0);
        result = 31 * result + (prepare_3_percent != null ? prepare_3_percent.hashCode() : 0);
        result = 31 * result + (necessary != null ? necessary.hashCode() : 0);
        result = 31 * result + (necessary_percent != null ? necessary_percent.hashCode() : 0);
        result = 31 * result + (left != null ? left.hashCode() : 0);
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        FunctionAssignDBModel o = null;
        try {
            // Object中的clone()识别出你要复制的是哪一个对象
            o = (FunctionAssignDBModel) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return o;
    }

    /**
     * 设置初始数据
     */
    public static FunctionAssignDBModel initDBModel(int flag) {
        FunctionAssignDBModel dbModel = new FunctionAssignDBModel();
        dbModel.flag = flag;
        dbModel.month_income = "30000";
        dbModel.taxes = "500";
        dbModel.after_taxes = "29500";
        dbModel.after_taxes_percent = "100%";
        dbModel.finance = "2950";
        dbModel.finance_percent = "10%";
        dbModel.grow = "2950";
        dbModel.grow_percent = "10%";
        dbModel.play = "2950";
        dbModel.play_percent = "10%";
        dbModel.long_plan = "5900";
        dbModel.long_plan_percent = "20%";
        dbModel.prepare_1 = "0";
        dbModel.prepare_1_percent = "0%";
        dbModel.prepare_2 = "0";
        dbModel.prepare_2_percent = "0%";
        dbModel.prepare_3 = "0";
        dbModel.prepare_3_percent = "0%";
        dbModel.necessary = "14750";
        dbModel.necessary_percent = "50%";
        dbModel.left = "0";
        return dbModel;
    }
}
