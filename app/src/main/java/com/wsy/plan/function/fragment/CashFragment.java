package com.wsy.plan.function.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wsy.plan.R;
import com.wsy.plan.databinding.FragmentFaCashBinding;
import com.wsy.plan.function.model.FunctionAssignModel;
import com.wsy.plan.function.utils.EditTextDoubleUse;

/**
 * 依金额分配
 */
public class CashFragment extends Fragment {

    FunctionAssignModel model = new FunctionAssignModel();
    private EditTextDoubleUse doubleUse;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static CashFragment newInstance() {
        return new CashFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fa_cash, container, false);

        FragmentFaCashBinding binding = DataBindingUtil.bind(rootView);
        binding.setModel(model);

        doubleUse = EditTextDoubleUse.getInstance(rootView, model, FunctionAssignModel.FA_FLAG_CASH);
        doubleUse.initData();

        return rootView;
    }

    public int update() {
        return doubleUse.update();
    }
}
