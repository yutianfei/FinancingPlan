package com.wsy.plan.main.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import java.io.Serializable;

/**
 * 记账数据模型
 */

public class AccountModel extends BaseObservable implements Serializable {
    public ObservableField<Long> id = new ObservableField<>();
    /**
     * 收入还是支出
     * 0:支出
     * 1:收入
     */
    public ObservableField<Integer> account_flag = new ObservableField<>();
    /**
     * 日期
     */
    public ObservableField<String> account_date = new ObservableField<>();
    /**
     * 方式
     */
    public ObservableField<String> account_method = new ObservableField<>();
    /**
     * 主选
     */
    public ObservableField<String> account_first = new ObservableField<>();
    /**
     * 副选
     */
    public ObservableField<String> account_second = new ObservableField<>();
    /**
     * 金额
     */
    public ObservableField<String> account_money = new ObservableField<>();
    /**
     * 备注
     */
    public ObservableField<String> account_comment = new ObservableField<>();

    public static AccountModel setData(AccountDBModel dbModel) {
        AccountModel model = new AccountModel();
        model.id.set(dbModel.id);
        model.account_flag.set(dbModel.account_flag);
        model.account_date.set(dbModel.account_date);
        model.account_method.set(dbModel.account_method);
        model.account_first.set(dbModel.account_first);
        model.account_second.set(dbModel.account_second);
        model.account_money.set(dbModel.account_money + "");
        model.account_comment.set(dbModel.account_comment);
        return model;
    }
}
