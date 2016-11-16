package com.wsy.plan.map.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wsy.plan.R;
import com.wsy.plan.databinding.FragmentMapCashBinding;
import com.wsy.plan.map.model.CashMapModel;

public class CashMapFragment extends Fragment {

    private CashMapModel model = new CashMapModel();

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static CashMapFragment newInstance() {
        return new CashMapFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map_cash, container, false);
        FragmentMapCashBinding binding = DataBindingUtil.bind(rootView);
        binding.setModel(model);
        return rootView;
    }
}
