package com.wsy.plan.challenge.model;

import org.litepal.crud.DataSupport;

/**
 * 每周存钱数据数据库模型
 */
public class ChallengeDBModel extends DataSupport {
    /**
     * 序号
     */
    public int challenge_id;
    /**
     * 标志：是否完成（未完成：0；已完成：1）
     */
    public int challenge_flag;
    /**
     * 存入金额
     */
    public String challenge_store;
    /**
     * 累计金额
     */
    public String challenge_total;
}
