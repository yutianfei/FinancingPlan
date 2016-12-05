package com.wsy.plan.setting.model;

import android.databinding.Bindable;
import android.support.annotation.NonNull;

import com.wsy.plan.BR;
import com.wsy.plan.common.MyBaseObservable;

/**
 * 支出数据模型
 */

public class TypeModel extends MyBaseObservable implements Comparable {
    private long id;
    private String type_first;
    private String type_second;
    private String type_money;
    private String type_date;

    public long getId() {
        return id;
    }

    @Bindable
    public String getType_first() {
        return type_first;
    }

    public void setType_first(String type_first) {
        this.type_first = type_first;
        notifyPropertyChanged(BR.type_first);
    }

    @Bindable
    public String getType_second() {
        return type_second;
    }

    public void setType_second(String type_second) {
        this.type_second = type_second;
        notifyPropertyChanged(BR.type_second);
    }

    @Bindable
    public String getType_date() {
        return type_date;
    }

    public void setType_date(String type_date) {
        this.type_date = type_date;
        notifyPropertyChanged(BR.type_date);
    }

    @Bindable
    public String getType_money() {
        return type_money;
    }

    public void setType_money(String type_money) {
        this.type_money = type_money;
        notifyPropertyChanged(BR.type_money);
    }

    @Override
    public int compareTo(@NonNull Object o) {
        TypeModel model2 = (TypeModel) o;
        int money1 = Integer.parseInt(this.getType_money());
        int money2 = Integer.parseInt(model2.getType_money());
        return money2 - money1;
    }
}
