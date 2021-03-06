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
    public List<AccountModel> getModels(String date) {
        List<AccountModel> modelList = new ArrayList<>();
        List<AccountDBModel> dbModelList = DataSupport.where("account_date = ?", date).find(AccountDBModel.class);
        if (dbModelList != null && dbModelList.size() > 0) {
            for (AccountDBModel dbModel : dbModelList) {
                modelList.add(AccountModel.setData(dbModel));
            }
        }
        return modelList;
    }

    @Override
    public long saveModel(AccountModel model) {
        AccountDBModel dbModel = AccountDBModel.setData(model);
        dbModel.save();
        return dbModel.getId();
    }

    @Override
    public boolean deleteModel(long id) {
        return DataSupport.delete(AccountDBModel.class, id) > -1;
    }

    @Override
    public boolean updateModel(long id, AccountModel model) {
        return AccountDBModel.setData(model).update(id) > 0;
    }

    @Override
    public String getMonthOut(String type, String month) {
        float out = DataSupport.where("account_date like ?", month + "%")
                .sum(AccountDBModel.class, "account_money", Float.class) -
                DataSupport.where("account_first = ? AND account_date like ?", type, month + "%")
                        .sum(AccountDBModel.class, "account_money", Float.class);
        return out + "";
    }

    @Override
    public String getMonthIncome(String type, String month) {
        return DataSupport.where("account_first = ? AND account_date like ?", type, month + "%")
                .sum(AccountDBModel.class, "account_money", Float.class) + "";
    }
}
