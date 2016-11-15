package com.wsy.plan.map.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wsy.plan.R;

public class InstructionFragment extends Fragment {

    public InstructionFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static InstructionFragment newInstance() {
        return new InstructionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map_instruction, container, false);
    }
}
