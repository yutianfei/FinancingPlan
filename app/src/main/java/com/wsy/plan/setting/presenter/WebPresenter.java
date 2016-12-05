package com.wsy.plan.setting.presenter;

import com.wsy.plan.setting.model.TypeModel;

import java.util.List;

public class WebPresenter implements ITypeModelPresenter {
    @Override
    public List<TypeModel> getSpecialModels(int firstId, int secondId) {
        return null;
    }

    @Override
    public boolean saveModel(TypeModel model) {
        return false;
    }

    @Override
    public boolean deleteModel(long id) {
        return false;
    }
}
