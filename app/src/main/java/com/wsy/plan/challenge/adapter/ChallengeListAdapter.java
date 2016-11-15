package com.wsy.plan.challenge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wsy.plan.BR;
import com.wsy.plan.R;
import com.wsy.plan.challenge.model.ChallengeModel;
import com.wsy.plan.common.BindingHolder;

import java.util.List;

public class ChallengeListAdapter extends RecyclerView.Adapter<BindingHolder> {

    private Context context;
    private List<ChallengeModel> list;

    public ChallengeListAdapter(List<ChallengeModel> list) {
        this.list = list;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_challenge_52, parent, false);
        return new BindingHolder(view);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        final ChallengeModel item = list.get(position);
        holder.getBinding().setVariable(BR.item, item);
        holder.getBinding().setVariable(BR.handlers, context);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
