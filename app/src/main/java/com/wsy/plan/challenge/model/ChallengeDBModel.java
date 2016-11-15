package com.wsy.plan.challenge.model;

import org.litepal.crud.DataSupport;

/**
 * 每周存钱数据数据库模型
 */
public class ChallengeDBModel extends DataSupport {
    /**
     * 标志：是否完成（未完成：0；已完成：1）
     */
    public int flag;
    /**
     * 序号
     */
    public int id;
    /**
     * 存入金额
     */
    public String store;
    /**
     * 累计金额
     */
    public String total;
}
