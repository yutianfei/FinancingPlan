package com.wsy.plan.challenge.presenter;

import com.wsy.plan.challenge.model.ChallengeDBModel;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * 从本地数据库操作数据
 */
public class LocalPresenter implements IChallengeModelPresenter {

    private static final int originalPerWeek = 10;

    @Override
    public List<ChallengeDBModel> getModels() {
        List<ChallengeDBModel> list = DataSupport.findAll(ChallengeDBModel.class);
        if (list == null || list.size() == 0) {
            list = new ArrayList<>();
            for (int i = 1; i <= 52; i++) {
                ChallengeDBModel model = new ChallengeDBModel();
                model.flag = 0;
                model.id = i;
                model.store = String.valueOf(originalPerWeek * i);
                model.total = String.valueOf(((originalPerWeek + originalPerWeek * i) * i) / 2);
                model.save();
                list.add(model);
            }
        }
        return list;
    }

    @Override
    public void updateDBModel(ChallengeDBModel dbModel) {
        dbModel.save();
    }
}
