package com.wsy.plan.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wsy.plan.BR;
import com.wsy.plan.R;
import com.wsy.plan.common.BindingHolder;
import com.wsy.plan.main.model.AccountModel;

import java.util.List;

public class AccountListAdapter extends RecyclerView.Adapter<BindingHolder> {

    private List<AccountModel> list;

    public AccountListAdapter(List<AccountModel> list) {
        this.list = list;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_account_list, parent, false);
        return new BindingHolder(view);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        final AccountModel model = list.get(position);
        holder.getBinding().setVariable(BR.model, model);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
