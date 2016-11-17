package com.wsy.plan.map.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * 现金流分配地图数据模型
 */
public class CashMapModel extends BaseObservable {
    /**
     * 备用金少于几个月
     */
    public ObservableField<String> backup_less = new ObservableField<>();
    /**
     * 备用金备足几个月
     */
    public ObservableField<String> backup_more = new ObservableField<>();
    /**
     * 存储备用金比例
     */
    public ObservableField<String> backup_percent = new ObservableField<>();
    /**
     * 生活费比例
     */
    public ObservableField<String> expenses_percent = new ObservableField<>();
    /**
     * 自定义分配1比例
     */
    public ObservableField<String> custom_1_percent = new ObservableField<>();
    /**
     * 自定义分配2比例
     */
    public ObservableField<String> custom_2_percent = new ObservableField<>();
    /**
     * 自定义分配3比例
     */
    public ObservableField<String> custom_3_percent = new ObservableField<>();
    /**
     * 自定义分配4比例
     */
    public ObservableField<String> custom_4_percent = new ObservableField<>();
    /**
     * 自定义分配5比例
     */
    public ObservableField<String> custom_5_percent = new ObservableField<>();
    /**
     * 自定义分配1名称
     */
    public ObservableField<String> custom_1_name = new ObservableField<>();
    /**
     * 自定义分配2名称
     */
    public ObservableField<String> custom_2_name = new ObservableField<>();
    /**
     * 自定义分配3名称
     */
    public ObservableField<String> custom_3_name = new ObservableField<>();
    /**
     * 自定义分配4名称
     */
    public ObservableField<String> custom_4_name = new ObservableField<>();
    /**
     * 自定义分配5名称
     */
    public ObservableField<String> custom_5_name = new ObservableField<>();

    /**
     * 设置数据库数据填充
     */
    public void setData(CashMapDBModel dbModel) {
        backup_less.set(dbModel.backup_less);
        backup_more.set(dbModel.backup_more);
        backup_percent.set(dbModel.backup_percent);
        expenses_percent.set(dbModel.expenses_percent);
        custom_1_percent.set(dbModel.custom_1_percent);
        custom_2_percent.set(dbModel.custom_2_percent);
        custom_3_percent.set(dbModel.custom_3_percent);
        custom_4_percent.set(dbModel.custom_4_percent);
        custom_5_percent.set(dbModel.custom_5_percent);
        custom_1_name.set(dbModel.custom_1_name);
        custom_2_name.set(dbModel.custom_2_name);
        custom_3_name.set(dbModel.custom_3_name);
        custom_4_name.set(dbModel.custom_4_name);
        custom_5_name.set(dbModel.custom_5_name);
    }

}
