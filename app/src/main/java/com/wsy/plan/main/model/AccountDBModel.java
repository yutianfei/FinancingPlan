package com.wsy.plan.main.model;

import com.wsy.plan.common.FormatUtils;

import org.litepal.crud.DataSupport;

/**
 * 记账数据模型
 */

public class AccountDBModel extends DataSupport {
    long id;
    /**
     * 收入还是支出
     * 0:支出
     * 1:收入
     */
    int account_flag;
    /**
     * 日期
     */
    String account_date;
    /**
     * 方式
     */
    String account_method;
    /**
     * 主选
     */
    String account_first;
    /**
     * 副选
     */
    String account_second;
    /**
     * 金额
     */
    String account_money;
    /**
     * 备注
     */
    String account_comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAccount_flag() {
        return account_flag;
    }

    public void setAccount_flag(int account_flag) {
        this.account_flag = account_flag;
    }

    public String getAccount_date() {
        return account_date;
    }

    public void setAccount_date(String account_date) {
        this.account_date = account_date;
    }

    public String getAccount_method() {
        return account_method;
    }

    public void setAccount_method(String account_method) {
        this.account_method = account_method;
    }

    public String getAccount_first() {
        return account_first;
    }

    public void setAccount_first(String account_first) {
        this.account_first = account_first;
    }

    public String getAccount_second() {
        return account_second;
    }

    public void setAccount_second(String account_second) {
        this.account_second = account_second;
    }

    public String getAccount_money() {
        return account_money;
    }

    public void setAccount_money(String account_money) {
        this.account_money = account_money;
    }

    public String getAccount_comment() {
        return account_comment;
    }

    public void setAccount_comment(String account_comment) {
        this.account_comment = account_comment;
    }

    /**
     * 填充数据库数据
     */
    public static AccountDBModel setData(AccountModel model) {
        AccountDBModel dbModel = new AccountDBModel();
        dbModel.account_flag = model.account_flag.get();
        dbModel.account_date = model.account_date.get();
        dbModel.account_method = model.account_method.get();
        dbModel.account_first = model.account_first.get();
        dbModel.account_second = model.account_second.get();
        dbModel.account_money = FormatUtils.formatMoney(model.account_money.get());
        dbModel.account_comment = model.account_comment.get();
        return dbModel;
    }
}
