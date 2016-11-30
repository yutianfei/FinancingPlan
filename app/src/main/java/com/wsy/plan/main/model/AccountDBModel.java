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
