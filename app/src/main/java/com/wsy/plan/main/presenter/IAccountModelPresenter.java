package com.wsy.plan.main.presenter;

import com.wsy.plan.main.model.AccountModel;

import java.util.List;

public interface IAccountModelPresenter {
    List<AccountModel> getModels(String date);
    long saveModel(AccountModel model);
    boolean deleteModel(long id);
    boolean updateModel(long id, AccountModel model);
}
