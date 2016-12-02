package com.wsy.plan.setting.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wsy.plan.BR;
import com.wsy.plan.R;
import com.wsy.plan.common.BindingHolder;
import com.wsy.plan.setting.model.TypeModel;

import java.util.List;

public class SettingFixedAdapter extends RecyclerView.Adapter<BindingHolder> {

    private List<TypeModel> list;

    public SettingFixedAdapter(List<TypeModel> list) {
        this.list = list;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fixed_setting, parent, false);
        return new BindingHolder(view);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        final TypeModel model = list.get(position);
        holder.getBinding().setVariable(BR.model, model);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
