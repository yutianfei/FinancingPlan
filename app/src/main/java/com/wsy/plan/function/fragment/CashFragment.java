package com.wsy.plan.function.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wsy.plan.R;

public class CashFragment extends Fragment {

    public CashFragment() {
    }

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
        View rootView = inflater.inflate(R.layout.fragment_fa_assign, container, false);

        return rootView;
    }
}
