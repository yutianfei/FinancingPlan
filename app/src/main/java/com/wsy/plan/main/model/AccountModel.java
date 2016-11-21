package com.wsy.plan.main.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * 记账数据模型
 */

public class AccountModel extends BaseObservable {
    public ObservableField<Integer> account_id = new ObservableField<>();
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
}
