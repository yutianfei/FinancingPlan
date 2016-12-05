package com.wsy.plan.setting.presenter;

import com.wsy.plan.setting.model.TypeModel;

import java.util.List;

public interface ITypeModelPresenter {
    List<TypeModel> getSpecialModels(int firstId, int secondId);

    boolean saveModel(TypeModel model);

    boolean deleteModel(long id);
}
