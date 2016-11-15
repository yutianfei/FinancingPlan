package com.wsy.plan.function.presenter;

import com.wsy.plan.function.model.FunctionAssignDBModel;

import org.litepal.crud.DataSupport;

/**
 * 从本地数据库操作数据
 */
public class LocalPresenter implements IFunctionModelPresenter {

    @Override
    public FunctionAssignDBModel getDBModel(int flag) {
        FunctionAssignDBModel dbModel = DataSupport.find(FunctionAssignDBModel.class, flag);
        if (dbModel == null) {
            dbModel = FunctionAssignDBModel.initDBModel(flag);
            dbModel.save();
        }
        return dbModel;
    }

    @Override
    public void updateDBModel(FunctionAssignDBModel dbModel) {
        dbModel.save();
    }
}
