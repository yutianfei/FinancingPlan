package com.wsy.plan.function.model;

import com.wsy.plan.common.FormatUtils;

import org.litepal.crud.DataSupport;

/**
 * 功能账户现金流分配数据数据库模型
 */
public class FunctionAssignDBModel extends DataSupport implements Cloneable {

    /**
     * 标志：区分依百分比和依金额（百分比：1；金额：2）
     */
    int fa_flag;
    /**
     * 月收入
     */
    String fa_month_income;
    /**
     * 预扣所得税
     */
    String fa_taxes;
    /**
     * 每月税后收入
     */
    String fa_after_taxes;
    /**
     * 每月税后收入百分比
     */
    String fa_after_taxes_percent;
    /**
     * 投资理财名称
     */
    String fa_finance_name;
    /**
     * 投资理财账户
     */
    String fa_finance;
    /**
     * 投资理财账户百分比
     */
    String fa_finance_percent;
    /**
     * 自我成长账户名称
     */
    String fa_grow_name;
    /**
     * 自我成长账户
     */
    String fa_grow;
    /**
     * 自我成长账户百分比
     */
    String fa_grow_percent;
    /**
     * 尽情娱乐账户名称
     */
    String fa_play_name;
    /**
     * 尽情娱乐账户
     */
    String fa_play;
    /**
     * 尽情娱乐账户百分比
     */
    String fa_play_percent;
    /**
     * 长期计划账户名称
     */
    String fa_long_plan_name;
    /**
     * 长期计划账户
     */
    String fa_long_plan;
    /**
     * 长期计划账户百分比
     */
    String fa_long_plan_percent;
    /**
     * 预备账户1名称
     */
    String fa_prepare_1_name;
    /**
     * 预备账户1
     */
    String fa_prepare_1;
    /**
     * 预备账户1百分比
     */
    String fa_prepare_1_percent;
    /**
     * 预备账户2名称
     */
    String fa_prepare_2_name;
    /**
     * 预备账户2
     */
    String fa_prepare_2;
    /**
     * 预备账户2百分比
     */
    String fa_prepare_2_percent;
    /**
     * 预备账户3名称
     */
    String fa_prepare_3_name;
    /**
     * 预备账户3
     */
    String fa_prepare_3;
    /**
     * 预备账户3百分比
     */
    String fa_prepare_3_percent;
    /**
     * 生活必需支出账户名称
     */
    String fa_necessary_name;
    /**
     * 生活必需支出
     */
    String fa_necessary;
    /**
     * 生活必需支出百分比
     */
    String fa_necessary_percent;
    /**
     * 剩余可支配金额
     */
    String fa_left;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FunctionAssignDBModel dbModel = (FunctionAssignDBModel) o;

        if (fa_flag != dbModel.fa_flag) return false;
        if (fa_month_income != null ? !fa_month_income.equals(dbModel.fa_month_income) : dbModel.fa_month_income != null)
            return false;
        if (fa_taxes != null ? !fa_taxes.equals(dbModel.fa_taxes) : dbModel.fa_taxes != null)
            return false;
        if (fa_after_taxes != null ? !fa_after_taxes.equals(dbModel.fa_after_taxes) : dbModel.fa_after_taxes != null)
            return false;
        if (fa_after_taxes_percent != null ? !fa_after_taxes_percent.equals(dbModel.fa_after_taxes_percent) : dbModel.fa_after_taxes_percent != null)
            return false;
        if (fa_finance_name != null ? !fa_finance_name.equals(dbModel.fa_finance_name) : dbModel.fa_finance_name != null)
            return false;
        if (fa_finance != null ? !fa_finance.equals(dbModel.fa_finance) : dbModel.fa_finance != null)
            return false;
        if (fa_finance_percent != null ? !fa_finance_percent.equals(dbModel.fa_finance_percent) : dbModel.fa_finance_percent != null)
            return false;
        if (fa_grow_name != null ? !fa_grow_name.equals(dbModel.fa_grow_name) : dbModel.fa_grow_name != null)
            return false;
        if (fa_grow != null ? !fa_grow.equals(dbModel.fa_grow) : dbModel.fa_grow != null)
            return false;
        if (fa_grow_percent != null ? !fa_grow_percent.equals(dbModel.fa_grow_percent) : dbModel.fa_grow_percent != null)
            return false;
        if (fa_play_name != null ? !fa_play_name.equals(dbModel.fa_play_name) : dbModel.fa_play_name != null)
            return false;
        if (fa_play != null ? !fa_play.equals(dbModel.fa_play) : dbModel.fa_play != null)
            return false;
        if (fa_play_percent != null ? !fa_play_percent.equals(dbModel.fa_play_percent) : dbModel.fa_play_percent != null)
            return false;
        if (fa_long_plan_name != null ? !fa_long_plan_name.equals(dbModel.fa_long_plan_name) : dbModel.fa_long_plan_name != null)
            return false;
        if (fa_long_plan != null ? !fa_long_plan.equals(dbModel.fa_long_plan) : dbModel.fa_long_plan != null)
            return false;
        if (fa_long_plan_percent != null ? !fa_long_plan_percent.equals(dbModel.fa_long_plan_percent) : dbModel.fa_long_plan_percent != null)
            return false;
        if (fa_prepare_1_name != null ? !fa_prepare_1_name.equals(dbModel.fa_prepare_1_name) : dbModel.fa_prepare_1_name != null)
            return false;
        if (fa_prepare_1 != null ? !fa_prepare_1.equals(dbModel.fa_prepare_1) : dbModel.fa_prepare_1 != null)
            return false;
        if (fa_prepare_1_percent != null ? !fa_prepare_1_percent.equals(dbModel.fa_prepare_1_percent) : dbModel.fa_prepare_1_percent != null)
            return false;
        if (fa_prepare_2_name != null ? !fa_prepare_2_name.equals(dbModel.fa_prepare_2_name) : dbModel.fa_prepare_2_name != null)
            return false;
        if (fa_prepare_2 != null ? !fa_prepare_2.equals(dbModel.fa_prepare_2) : dbModel.fa_prepare_2 != null)
            return false;
        if (fa_prepare_2_percent != null ? !fa_prepare_2_percent.equals(dbModel.fa_prepare_2_percent) : dbModel.fa_prepare_2_percent != null)
            return false;
        if (fa_prepare_3_name != null ? !fa_prepare_3_name.equals(dbModel.fa_prepare_3_name) : dbModel.fa_prepare_3_name != null)
            return false;
        if (fa_prepare_3 != null ? !fa_prepare_3.equals(dbModel.fa_prepare_3) : dbModel.fa_prepare_3 != null)
            return false;
        if (fa_prepare_3_percent != null ? !fa_prepare_3_percent.equals(dbModel.fa_prepare_3_percent) : dbModel.fa_prepare_3_percent != null)
            return false;
        if (fa_necessary_name != null ? !fa_necessary_name.equals(dbModel.fa_necessary_name) : dbModel.fa_necessary_name != null)
            return false;
        if (fa_necessary != null ? !fa_necessary.equals(dbModel.fa_necessary) : dbModel.fa_necessary != null)
            return false;
        if (fa_necessary_percent != null ? !fa_necessary_percent.equals(dbModel.fa_necessary_percent) : dbModel.fa_necessary_percent != null)
            return false;
        return fa_left != null ? fa_left.equals(dbModel.fa_left) : dbModel.fa_left == null;

    }

    @Override
    public int hashCode() {
        int result = fa_flag;
        result = 31 * result + (fa_month_income != null ? fa_month_income.hashCode() : 0);
        result = 31 * result + (fa_taxes != null ? fa_taxes.hashCode() : 0);
        result = 31 * result + (fa_after_taxes != null ? fa_after_taxes.hashCode() : 0);
        result = 31 * result + (fa_after_taxes_percent != null ? fa_after_taxes_percent.hashCode() : 0);
        result = 31 * result + (fa_finance_name != null ? fa_finance_name.hashCode() : 0);
        result = 31 * result + (fa_finance != null ? fa_finance.hashCode() : 0);
        result = 31 * result + (fa_finance_percent != null ? fa_finance_percent.hashCode() : 0);
        result = 31 * result + (fa_grow_name != null ? fa_grow_name.hashCode() : 0);
        result = 31 * result + (fa_grow != null ? fa_grow.hashCode() : 0);
        result = 31 * result + (fa_grow_percent != null ? fa_grow_percent.hashCode() : 0);
        result = 31 * result + (fa_play_name != null ? fa_play_name.hashCode() : 0);
        result = 31 * result + (fa_play != null ? fa_play.hashCode() : 0);
        result = 31 * result + (fa_play_percent != null ? fa_play_percent.hashCode() : 0);
        result = 31 * result + (fa_long_plan_name != null ? fa_long_plan_name.hashCode() : 0);
        result = 31 * result + (fa_long_plan != null ? fa_long_plan.hashCode() : 0);
        result = 31 * result + (fa_long_plan_percent != null ? fa_long_plan_percent.hashCode() : 0);
        result = 31 * result + (fa_prepare_1_name != null ? fa_prepare_1_name.hashCode() : 0);
        result = 31 * result + (fa_prepare_1 != null ? fa_prepare_1.hashCode() : 0);
        result = 31 * result + (fa_prepare_1_percent != null ? fa_prepare_1_percent.hashCode() : 0);
        result = 31 * result + (fa_prepare_2_name != null ? fa_prepare_2_name.hashCode() : 0);
        result = 31 * result + (fa_prepare_2 != null ? fa_prepare_2.hashCode() : 0);
        result = 31 * result + (fa_prepare_2_percent != null ? fa_prepare_2_percent.hashCode() : 0);
        result = 31 * result + (fa_prepare_3_name != null ? fa_prepare_3_name.hashCode() : 0);
        result = 31 * result + (fa_prepare_3 != null ? fa_prepare_3.hashCode() : 0);
        result = 31 * result + (fa_prepare_3_percent != null ? fa_prepare_3_percent.hashCode() : 0);
        result = 31 * result + (fa_necessary_name != null ? fa_necessary_name.hashCode() : 0);
        result = 31 * result + (fa_necessary != null ? fa_necessary.hashCode() : 0);
        result = 31 * result + (fa_necessary_percent != null ? fa_necessary_percent.hashCode() : 0);
        result = 31 * result + (fa_left != null ? fa_left.hashCode() : 0);
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
        dbModel.fa_flag = flag;
        dbModel.fa_month_income = "30000";
        dbModel.fa_taxes = "500";
        dbModel.fa_after_taxes = "29500";
        dbModel.fa_after_taxes_percent = "100%";
        dbModel.fa_finance_name = "投资理财账户";
        dbModel.fa_finance = "2950";
        dbModel.fa_finance_percent = "10%";
        dbModel.fa_grow_name = "自我成长账户";
        dbModel.fa_grow = "2950";
        dbModel.fa_grow_percent = "10%";
        dbModel.fa_play_name = "尽情享乐账户";
        dbModel.fa_play = "2950";
        dbModel.fa_play_percent = "10%";
        dbModel.fa_long_plan_name = "长期计划账户";
        dbModel.fa_long_plan = "5900";
        dbModel.fa_long_plan_percent = "20%";
        dbModel.fa_prepare_1_name = "预备账户1";
        dbModel.fa_prepare_1 = "0";
        dbModel.fa_prepare_1_percent = "0%";
        dbModel.fa_prepare_2_name = "预备账户2";
        dbModel.fa_prepare_2 = "0";
        dbModel.fa_prepare_2_percent = "0%";
        dbModel.fa_prepare_3_name = "预备账户3";
        dbModel.fa_prepare_3 = "0";
        dbModel.fa_prepare_3_percent = "0%";
        dbModel.fa_necessary_name = "生活必需支出";
        dbModel.fa_necessary = "14750";
        dbModel.fa_necessary_percent = "50%";
        dbModel.fa_left = "0";
        return dbModel;
    }

    /**
     * 填充数据库数据
     */
    public void setData(FunctionAssignModel model) {
        fa_month_income = FormatUtils.formatSign(model.fa_month_income.get());
        fa_taxes = FormatUtils.formatSign(model.fa_taxes.get());
        fa_after_taxes = FormatUtils.formatSign(model.fa_after_taxes.get());
        fa_after_taxes_percent = FormatUtils.formatPercent(model.fa_after_taxes_percent.get());
        fa_finance_name = FormatUtils.formatLabel(model.fa_finance_name.get());
        fa_finance = FormatUtils.formatSign(model.fa_finance.get());
        fa_finance_percent = FormatUtils.formatPercent(model.fa_finance_percent.get());
        fa_grow_name = FormatUtils.formatLabel(model.fa_grow_name.get());
        fa_grow = FormatUtils.formatSign(model.fa_grow.get());
        fa_grow_percent = FormatUtils.formatPercent(model.fa_grow_percent.get());
        fa_play_name = FormatUtils.formatLabel(model.fa_play_name.get());
        fa_play = FormatUtils.formatSign(model.fa_play.get());
        fa_play_percent = FormatUtils.formatPercent(model.fa_play_percent.get());
        fa_long_plan_name = FormatUtils.formatLabel(model.fa_long_plan_name.get());
        fa_long_plan = FormatUtils.formatSign(model.fa_long_plan.get());
        fa_long_plan_percent = FormatUtils.formatPercent(model.fa_long_plan_percent.get());
        fa_prepare_1_name = FormatUtils.formatLabel(model.fa_prepare_1_name.get());
        fa_prepare_1 = FormatUtils.formatSign(model.fa_prepare_1.get());
        fa_prepare_1_percent = FormatUtils.formatPercent(model.fa_prepare_1_percent.get());
        fa_prepare_2_name = FormatUtils.formatLabel(model.fa_prepare_2_name.get());
        fa_prepare_2 = FormatUtils.formatSign(model.fa_prepare_2.get());
        fa_prepare_2_percent = FormatUtils.formatPercent(model.fa_prepare_2_percent.get());
        fa_prepare_3_name = FormatUtils.formatLabel(model.fa_prepare_3_name.get());
        fa_prepare_3 = FormatUtils.formatSign(model.fa_prepare_3.get());
        fa_prepare_3_percent = FormatUtils.formatPercent(model.fa_prepare_3_percent.get());
        fa_necessary_name = FormatUtils.formatLabel(model.fa_necessary_name.get());
        fa_necessary = FormatUtils.formatSign(model.fa_necessary.get());
        fa_necessary_percent = FormatUtils.formatPercent(model.fa_necessary_percent.get());
        fa_left = FormatUtils.formatSign(model.fa_left.get());
    }
}
