package com.wsy.plan.main.presenter;

import com.wsy.plan.main.model.AccountModel;

import java.util.List;

/**
 * 从服务器操作数据
 */
public class WebPresenter implements IAccountModelPresenter {

    @Override
    public List<AccountModel> getModels() {
        return null;
    }

    @Override
    public boolean updateModel(AccountModel model) {
        return false;
    }
}
