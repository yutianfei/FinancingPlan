package com.wsy.plan.map.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.wsy.plan.common.BigDecimalUtils;

/**
 * 现金流分配地图数据模型
 */
public class CashMapModel extends BaseObservable {

    public static final int MAP_PERCENT_NOT_CHANGE = -1;
    public static final int MAP_PERCENT_PERFECT = 0;
    public static final int MAP_PERCENT_LESS = 1;
    public static final int MAP_PERCENT_MORE = 2;

    /**
     * 备用金少于几个月
     */
    public ObservableField<String> map_backup_less = new ObservableField<>();
    /**
     * 备用金备足几个月
     */
    public ObservableField<String> map_backup_more = new ObservableField<>();
    /**
     * 存储备用金比例
     */
    public ObservableField<String> map_backup_percent = new ObservableField<>();
    /**
     * 生活费比例
     */
    public ObservableField<String> map_expenses_percent = new ObservableField<>();
    /**
     * 自定义分配1比例
     */
    public ObservableField<String> map_custom_1_percent = new ObservableField<>();
    /**
     * 自定义分配2比例
     */
    public ObservableField<String> map_custom_2_percent = new ObservableField<>();
    /**
     * 自定义分配3比例
     */
    public ObservableField<String> map_custom_3_percent = new ObservableField<>();
    /**
     * 自定义分配4比例
     */
    public ObservableField<String> map_custom_4_percent = new ObservableField<>();
    /**
     * 自定义分配5比例
     */
    public ObservableField<String> map_custom_5_percent = new ObservableField<>();
    /**
     * 自定义分配1名称
     */
    public ObservableField<String> map_custom_1_name = new ObservableField<>();
    /**
     * 自定义分配2名称
     */
    public ObservableField<String> map_custom_2_name = new ObservableField<>();
    /**
     * 自定义分配3名称
     */
    public ObservableField<String> map_custom_3_name = new ObservableField<>();
    /**
     * 自定义分配4名称
     */
    public ObservableField<String> map_custom_4_name = new ObservableField<>();
    /**
     * 自定义分配5名称
     */
    public ObservableField<String> map_custom_5_name = new ObservableField<>();

    /**
     * 设置数据库数据填充
     */
    public void setData(CashMapDBModel dbModel) {
        map_backup_less.set(dbModel.map_backup_less);
        map_backup_more.set(dbModel.map_backup_more);
        map_backup_percent.set(dbModel.map_backup_percent);
        map_expenses_percent.set(dbModel.map_expenses_percent);
        map_custom_1_percent.set(dbModel.map_custom_1_percent);
        map_custom_2_percent.set(dbModel.map_custom_2_percent);
        map_custom_3_percent.set(dbModel.map_custom_3_percent);
        map_custom_4_percent.set(dbModel.map_custom_4_percent);
        map_custom_5_percent.set(dbModel.map_custom_5_percent);
        map_custom_1_name.set(dbModel.map_custom_1_name);
        map_custom_2_name.set(dbModel.map_custom_2_name);
        map_custom_3_name.set(dbModel.map_custom_3_name);
        map_custom_4_name.set(dbModel.map_custom_4_name);
        map_custom_5_name.set(dbModel.map_custom_5_name);
    }

    /**
     * 获取所有分配的百分比之和
     */
    public int result() {
        String[] values = {map_backup_percent.get(), map_expenses_percent.get(), map_custom_1_percent.get(),
                map_custom_2_percent.get(), map_custom_3_percent.get(), map_custom_4_percent.get(),
                map_custom_5_percent.get()};
        return Integer.parseInt(BigDecimalUtils.add(values));
    }
}
