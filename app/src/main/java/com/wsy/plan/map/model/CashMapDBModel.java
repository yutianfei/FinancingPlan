package com.wsy.plan.map.model;

import org.litepal.crud.DataSupport;

/**
 * 现金流分配地图数据模型
 */
public class CashMapDBModel extends DataSupport {
    /**
     * 备用金少于几个月
     */
    public String backup_less;
    /**
     * 备用金备足几个月
     */
    public String backup_more;
    /**
     * 存储备用金比例
     */
    public String backup_percent;
    /**
     * 生活费比例
     */
    public String necessary_percent;
    /**
     * 自定义分配1比例
     */
    public String custom_1_percent;
    /**
     * 自定义分配2比例
     */
    public String custom_2_percent;
    /**
     * 自定义分配3比例
     */
    public String custom_3_percent;
    /**
     * 自定义分配4比例
     */
    public String custom_4_percent;
    /**
     * 自定义分配5比例
     */
    public String custom_5_percent;
    /**
     * 自定义分配1名称
     */
    public String custom_1_name;
    /**
     * 自定义分配2名称
     */
    public String custom_2_name;
    /**
     * 自定义分配3名称
     */
    public String custom_3_name;
    /**
     * 自定义分配4名称
     */
    public String custom_4_name;
    /**
     * 自定义分配5名称
     */
    public String custom_5_name;
}
