package com.wsy.plan.challenge.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * 每周存钱数据模型
 */
public class ChallengeModel extends BaseObservable {
    /**
     * 序号
     */
    public ObservableField<Integer> challenge_id = new ObservableField<>();
    /**
     * 标志：是否完成（未完成：0；已完成：1）
     */
    public ObservableField<Integer> challenge_flag = new ObservableField<>();
    /**
     * 存入金额
     */
    public ObservableField<String> challenge_store = new ObservableField<>();
    /**
     * 累计金额
     */
    public ObservableField<String> challenge_total = new ObservableField<>();
}
