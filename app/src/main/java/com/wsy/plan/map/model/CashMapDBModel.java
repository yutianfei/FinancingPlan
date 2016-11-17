package com.wsy.plan.map.model;

import org.litepal.crud.DataSupport;

/**
 * 现金流分配地图数据模型
 */
public class CashMapDBModel extends DataSupport implements Cloneable {
    private int map_id;
    /**
     * 备用金少于几个月
     */
    String map_backup_less;
    /**
     * 备用金备足几个月
     */
    String map_backup_more;
    /**
     * 存储备用金比例
     */
    String map_backup_percent;
    /**
     * 生活费比例
     */
    String map_expenses_percent;
    /**
     * 自定义分配1比例
     */
    String map_custom_1_percent;
    /**
     * 自定义分配2比例
     */
    String map_custom_2_percent;
    /**
     * 自定义分配3比例
     */
    String map_custom_3_percent;
    /**
     * 自定义分配4比例
     */
    String map_custom_4_percent;
    /**
     * 自定义分配5比例
     */
    String map_custom_5_percent;
    /**
     * 自定义分配1名称
     */
    String map_custom_1_name;
    /**
     * 自定义分配2名称
     */
    String map_custom_2_name;
    /**
     * 自定义分配3名称
     */
    String map_custom_3_name;
    /**
     * 自定义分配4名称
     */
    String map_custom_4_name;
    /**
     * 自定义分配5名称
     */
    String map_custom_5_name;

    @Override
    public Object clone() throws CloneNotSupportedException {
        CashMapDBModel o = null;
        try {
            // Object中的clone()识别出你要复制的是哪一个对象
            o = (CashMapDBModel) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return o;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CashMapDBModel that = (CashMapDBModel) o;

        if (map_backup_less != null ? !map_backup_less.equals(that.map_backup_less) : that.map_backup_less != null)
            return false;
        if (map_backup_more != null ? !map_backup_more.equals(that.map_backup_more) : that.map_backup_more != null)
            return false;
        if (map_backup_percent != null ? !map_backup_percent.equals(that.map_backup_percent) : that.map_backup_percent != null)
            return false;
        if (map_expenses_percent != null ? !map_expenses_percent.equals(that.map_expenses_percent) : that.map_expenses_percent != null)
            return false;
        if (map_custom_1_percent != null ? !map_custom_1_percent.equals(that.map_custom_1_percent) : that.map_custom_1_percent != null)
            return false;
        if (map_custom_2_percent != null ? !map_custom_2_percent.equals(that.map_custom_2_percent) : that.map_custom_2_percent != null)
            return false;
        if (map_custom_3_percent != null ? !map_custom_3_percent.equals(that.map_custom_3_percent) : that.map_custom_3_percent != null)
            return false;
        if (map_custom_4_percent != null ? !map_custom_4_percent.equals(that.map_custom_4_percent) : that.map_custom_4_percent != null)
            return false;
        if (map_custom_5_percent != null ? !map_custom_5_percent.equals(that.map_custom_5_percent) : that.map_custom_5_percent != null)
            return false;
        if (map_custom_1_name != null ? !map_custom_1_name.equals(that.map_custom_1_name) : that.map_custom_1_name != null)
            return false;
        if (map_custom_2_name != null ? !map_custom_2_name.equals(that.map_custom_2_name) : that.map_custom_2_name != null)
            return false;
        if (map_custom_3_name != null ? !map_custom_3_name.equals(that.map_custom_3_name) : that.map_custom_3_name != null)
            return false;
        if (map_custom_4_name != null ? !map_custom_4_name.equals(that.map_custom_4_name) : that.map_custom_4_name != null)
            return false;
        return map_custom_5_name != null ? map_custom_5_name.equals(that.map_custom_5_name) : that.map_custom_5_name == null;

    }

    @Override
    public int hashCode() {
        int result = map_backup_less != null ? map_backup_less.hashCode() : 0;
        result = 31 * result + (map_backup_more != null ? map_backup_more.hashCode() : 0);
        result = 31 * result + (map_backup_percent != null ? map_backup_percent.hashCode() : 0);
        result = 31 * result + (map_expenses_percent != null ? map_expenses_percent.hashCode() : 0);
        result = 31 * result + (map_custom_1_percent != null ? map_custom_1_percent.hashCode() : 0);
        result = 31 * result + (map_custom_2_percent != null ? map_custom_2_percent.hashCode() : 0);
        result = 31 * result + (map_custom_3_percent != null ? map_custom_3_percent.hashCode() : 0);
        result = 31 * result + (map_custom_4_percent != null ? map_custom_4_percent.hashCode() : 0);
        result = 31 * result + (map_custom_5_percent != null ? map_custom_5_percent.hashCode() : 0);
        result = 31 * result + (map_custom_1_name != null ? map_custom_1_name.hashCode() : 0);
        result = 31 * result + (map_custom_2_name != null ? map_custom_2_name.hashCode() : 0);
        result = 31 * result + (map_custom_3_name != null ? map_custom_3_name.hashCode() : 0);
        result = 31 * result + (map_custom_4_name != null ? map_custom_4_name.hashCode() : 0);
        result = 31 * result + (map_custom_5_name != null ? map_custom_5_name.hashCode() : 0);
        return result;
    }

    /**
     * 设置初始数据
     */
    public static CashMapDBModel initDBModel() {
        CashMapDBModel dbModel = new CashMapDBModel();
        dbModel.map_id = 1;
        return dbModel;
    }

    /**
     * 填充数据库数据
     */
    public void setData(CashMapModel model) {
        map_backup_less = model.map_backup_less.get();
        map_backup_more = model.map_backup_more.get();
        map_backup_percent = model.map_backup_percent.get();
        map_expenses_percent = model.map_expenses_percent.get();
        map_custom_1_percent = model.map_custom_1_percent.get();
        map_custom_2_percent = model.map_custom_2_percent.get();
        map_custom_3_percent = model.map_custom_3_percent.get();
        map_custom_4_percent = model.map_custom_4_percent.get();
        map_custom_5_percent = model.map_custom_5_percent.get();
        map_custom_1_name = model.map_custom_1_name.get();
        map_custom_2_name = model.map_custom_2_name.get();
        map_custom_3_name = model.map_custom_3_name.get();
        map_custom_4_name = model.map_custom_4_name.get();
        map_custom_5_name = model.map_custom_5_name.get();
    }
}
