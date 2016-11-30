package com.wsy.plan.main.presenter;

import com.wsy.plan.main.model.AccountModel;

import java.util.List;

public interface IAccountModelPresenter {
    List<AccountModel> getModels(String date);
    boolean saveModel(AccountModel model);
    boolean deleteModel(long id);
}
