package com.wsy.plan.challenge.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * 每周存钱数据模型
 */
public class ChallengeModel extends BaseObservable {
    /**
     * 标志：是否完成（未完成：0；已完成：1）
     */
    public ObservableField<Integer> flag = new ObservableField<>();
    /**
     * 序号
     */
    public ObservableField<Integer> id = new ObservableField<>();
    /**
     * 存入金额
     */
    public ObservableField<String> store = new ObservableField<>();
    /**
     * 累计金额
     */
    public ObservableField<String> total = new ObservableField<>();
}
