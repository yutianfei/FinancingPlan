package com.wsy.plan.main.presenter;

import com.wsy.plan.main.model.AccountDBModel;
import com.wsy.plan.main.model.AccountModel;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * 从本地数据库操作数据
 */
public class LocalPresenter implements IAccountModelPresenter {

    @Override
    public List<AccountModel> getModels() {
        List<AccountModel> modelList = new ArrayList<>();
        List<AccountDBModel> dbModelList = DataSupport.order("account_date").find(AccountDBModel.class);
        if (dbModelList != null && dbModelList.size() > 0) {
            for (AccountDBModel dbModel : dbModelList) {
                modelList.add(AccountModel.setData(dbModel));
            }
        }
        return modelList;
    }

    @Override
    public boolean updateModel(AccountModel model) {
        return AccountDBModel.setData(model).save();
    }
}
