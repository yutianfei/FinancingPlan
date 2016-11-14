package com.wsy.plan.function.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wsy.plan.R;
import com.wsy.plan.databinding.FragmentFaPercentBinding;
import com.wsy.plan.function.model.FunctionAssignModel;
import com.wsy.plan.function.utils.EditTextDoubleUse;

/**
 * 依百分比分配
 */
public class PercentFragment extends Fragment {

    FunctionAssignModel model = new FunctionAssignModel();

    public PercentFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PercentFragment newInstance() {
        return new PercentFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fa_percent, container, false);

        FragmentFaPercentBinding binding = DataBindingUtil.bind(rootView);
        binding.setModel(model);

        EditTextDoubleUse.getInstance(rootView, model, FunctionAssignModel.FLAG_PERCENT).initEditText();

        return rootView;
    }
}
