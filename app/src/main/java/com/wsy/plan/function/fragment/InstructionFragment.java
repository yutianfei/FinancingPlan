package com.wsy.plan.function.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fa_instruction, container, false);

        TextView tvFAIContent3 = (TextView) rootView.findViewById(R.id.fa_instruction_content_3);
        tvFAIContent3.setText(Html.fromHtml(getString(R.string.fa_instruction_content_3)));

        return rootView;
    }
}
