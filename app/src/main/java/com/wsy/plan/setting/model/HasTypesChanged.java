package com.wsy.plan.setting.model;

import org.litepal.crud.DataSupport;

public class HasTypesChanged extends DataSupport {

    /**
     * 是否修改过：0-未修改，1-已修改
     */
    private int hasChanged;

    public int getHasChanged() {
        return hasChanged;
    }

    public void setHasChanged(int hasChanged) {
        this.hasChanged = hasChanged;
    }
}
