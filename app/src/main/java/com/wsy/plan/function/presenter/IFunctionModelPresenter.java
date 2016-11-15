package com.wsy.plan.function.presenter;

import com.wsy.plan.function.model.FunctionAssignDBModel;

public interface IFunctionModelPresenter {
    FunctionAssignDBModel getDBModel(int flag);
    void updateDBModel(FunctionAssignDBModel dbModel);
}
