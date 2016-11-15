package com.wsy.plan.challenge.presenter;

import com.wsy.plan.challenge.model.ChallengeDBModel;

import java.util.List;

public interface IChallengeModelPresenter {
    List<ChallengeDBModel> getModels();
    void updateDBModel(ChallengeDBModel dbModel);
}
