package com.wsy.plan.map.presenter;

import com.wsy.plan.map.model.CashMapDBModel;

import org.litepal.crud.DataSupport;

/**
 * 从本地数据库操作数据
 */
public class LocalPresenter implements ICashMapModelPresenter {

    @Override
    public CashMapDBModel getDBModel(int id) {
        CashMapDBModel dbModel = DataSupport.find(CashMapDBModel.class, id);
        if (dbModel == null) {
            dbModel = CashMapDBModel.initDBModel();
            dbModel.save();
        }
        return dbModel;
    }

    @Override
    public void updateDBModel(CashMapDBModel dbModel) {
        dbModel.save();
    }
}
