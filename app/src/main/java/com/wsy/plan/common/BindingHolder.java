package com.wsy.plan.common;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BindingHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;

    public BindingHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    public ViewDataBinding getBinding() {
        return binding;
    }
}
