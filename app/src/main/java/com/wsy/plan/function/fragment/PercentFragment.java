package com.wsy.plan.function.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wsy.plan.R;

public class PercentFragment extends Fragment {

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
        View rootView = inflater.inflate(R.layout.fragment_fa_assign, container, false);

        return rootView;
    }
}
