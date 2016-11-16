package com.wsy.plan.map.presenter;

import com.wsy.plan.map.model.CashMapDBModel;

public interface ICashMapModelPresenter {
    CashMapDBModel getDBModel(int id);
    void updateDBModel(CashMapDBModel dbModel);
}
