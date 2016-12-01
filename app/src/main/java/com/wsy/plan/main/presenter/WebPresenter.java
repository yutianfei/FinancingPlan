package com.wsy.plan.main.presenter;

import com.wsy.plan.main.model.AccountModel;

import java.util.List;

/**
 * 从服务器操作数据
 */
public class WebPresenter implements IAccountModelPresenter {

    @Override
    public List<AccountModel> getModels(String date) {
        return null;
    }

    @Override
    public long saveModel(AccountModel model) {
        return 0;
    }

    @Override
    public boolean deleteModel(long id) {
        return false;
    }

    @Override
    public boolean updateModel(long id, AccountModel model) {
        return false;
    }

    @Override
    public String getMonthOut(String type, String month) {
        return null;
    }

    @Override
    public String getMonthIncome(String type, String month) {
        return null;
    }
}
