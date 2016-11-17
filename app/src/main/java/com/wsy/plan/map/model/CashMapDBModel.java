package com.wsy.plan.map.model;

import org.litepal.crud.DataSupport;

/**
 * 现金流分配地图数据模型
 */
public class CashMapDBModel extends DataSupport implements Cloneable {
    public int id;
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
    public String expenses_percent;
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

        if (backup_less != null ? !backup_less.equals(that.backup_less) : that.backup_less != null)
            return false;
        if (backup_more != null ? !backup_more.equals(that.backup_more) : that.backup_more != null)
            return false;
        if (backup_percent != null ? !backup_percent.equals(that.backup_percent) : that.backup_percent != null)
            return false;
        if (expenses_percent != null ? !expenses_percent.equals(that.expenses_percent) : that.expenses_percent != null)
            return false;
        if (custom_1_percent != null ? !custom_1_percent.equals(that.custom_1_percent) : that.custom_1_percent != null)
            return false;
        if (custom_2_percent != null ? !custom_2_percent.equals(that.custom_2_percent) : that.custom_2_percent != null)
            return false;
        if (custom_3_percent != null ? !custom_3_percent.equals(that.custom_3_percent) : that.custom_3_percent != null)
            return false;
        if (custom_4_percent != null ? !custom_4_percent.equals(that.custom_4_percent) : that.custom_4_percent != null)
            return false;
        if (custom_5_percent != null ? !custom_5_percent.equals(that.custom_5_percent) : that.custom_5_percent != null)
            return false;
        if (custom_1_name != null ? !custom_1_name.equals(that.custom_1_name) : that.custom_1_name != null)
            return false;
        if (custom_2_name != null ? !custom_2_name.equals(that.custom_2_name) : that.custom_2_name != null)
            return false;
        if (custom_3_name != null ? !custom_3_name.equals(that.custom_3_name) : that.custom_3_name != null)
            return false;
        if (custom_4_name != null ? !custom_4_name.equals(that.custom_4_name) : that.custom_4_name != null)
            return false;
        return custom_5_name != null ? custom_5_name.equals(that.custom_5_name) : that.custom_5_name == null;

    }

    @Override
    public int hashCode() {
        int result = backup_less != null ? backup_less.hashCode() : 0;
        result = 31 * result + (backup_more != null ? backup_more.hashCode() : 0);
        result = 31 * result + (backup_percent != null ? backup_percent.hashCode() : 0);
        result = 31 * result + (expenses_percent != null ? expenses_percent.hashCode() : 0);
        result = 31 * result + (custom_1_percent != null ? custom_1_percent.hashCode() : 0);
        result = 31 * result + (custom_2_percent != null ? custom_2_percent.hashCode() : 0);
        result = 31 * result + (custom_3_percent != null ? custom_3_percent.hashCode() : 0);
        result = 31 * result + (custom_4_percent != null ? custom_4_percent.hashCode() : 0);
        result = 31 * result + (custom_5_percent != null ? custom_5_percent.hashCode() : 0);
        result = 31 * result + (custom_1_name != null ? custom_1_name.hashCode() : 0);
        result = 31 * result + (custom_2_name != null ? custom_2_name.hashCode() : 0);
        result = 31 * result + (custom_3_name != null ? custom_3_name.hashCode() : 0);
        result = 31 * result + (custom_4_name != null ? custom_4_name.hashCode() : 0);
        result = 31 * result + (custom_5_name != null ? custom_5_name.hashCode() : 0);
        return result;
    }

    /**
     * 设置初始数据
     */
    public static CashMapDBModel initDBModel() {
        CashMapDBModel dbModel = new CashMapDBModel();
        dbModel.id = 1;
        return dbModel;
    }

    /**
     * 填充数据库数据
     */
    public void setData(CashMapModel model) {
        backup_less = model.backup_less.get();
        backup_more = model.backup_more.get();
        backup_percent = model.backup_percent.get();
        expenses_percent = model.expenses_percent.get();
        custom_1_percent = model.custom_1_percent.get();
        custom_2_percent = model.custom_2_percent.get();
        custom_3_percent = model.custom_3_percent.get();
        custom_4_percent = model.custom_4_percent.get();
        custom_5_percent = model.custom_5_percent.get();
        custom_1_name = model.custom_1_name.get();
        custom_2_name = model.custom_2_name.get();
        custom_3_name = model.custom_3_name.get();
        custom_4_name = model.custom_4_name.get();
        custom_5_name = model.custom_5_name.get();
    }
}
