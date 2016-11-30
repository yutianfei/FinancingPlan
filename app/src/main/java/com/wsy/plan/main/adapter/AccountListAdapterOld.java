package com.wsy.plan.main.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wsy.plan.BR;
import com.wsy.plan.R;
import com.wsy.plan.main.model.AccountModel;

import java.util.List;

public class AccountListAdapterOld extends RecyclerView.Adapter<AccountListAdapterOld.BindingHolder> {

    private Context context;
    private List<AccountModel> list;
    private SparseArray<String> dateMap = new SparseArray<>();
    private SparseArray<String> dividerMap = new SparseArray<>();
    private String date = "";

    public AccountListAdapterOld(List<AccountModel> list) {
        this.list = list;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_account_list, parent, false);
        return new BindingHolder(view);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        final AccountModel model = list.get(position);
        holder.getBinding().setVariable(BR.model, model);
        holder.getBinding().setVariable(BR.handlers, context);
        holder.getBinding().executePendingBindings();

        // 日期显示与隐藏
        boolean showDate;
        if (dateMap.indexOfKey(position) > -1) {
            showDate = !"GONE".equals(dateMap.get(position));
        } else {
            if (date.equals(model.account_date.get())) {
                dateMap.put(position, "GONE");
                showDate = false;
            } else {
                dateMap.put(position, "VISIBLE");
                showDate = true;
            }
            date = model.account_date.get();
        }
        holder.tvDate.setVisibility(showDate ? View.VISIBLE : View.INVISIBLE);

        // 分割线显示与隐藏
        boolean showDivider = true;
        if (dividerMap.indexOfKey(position) > -1) {
            showDivider = !"GONE".equals(dividerMap.get(position));
        } else {
            if ((position + 1) < getItemCount()) {
                String nextDate = list.get(position + 1).account_date.get();
                if (date.equals(nextDate)) {
                    dividerMap.put(position, "GONE");
                    showDivider = false;
                } else {
                    dividerMap.put(position, "VISIBLE");
                    showDivider = true;
                }
            }
        }
        holder.dividerLeft.setVisibility(showDivider ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * 清除保存的位置信息
     */
    public void clearMapData() {
        dateMap.clear();
        dividerMap.clear();
    }

    static class BindingHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;
        private View dividerLeft;
        private TextView tvDate;

        BindingHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            dividerLeft = itemView.findViewById(R.id.divider_left);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
        }

        ViewDataBinding getBinding() {
            return binding;
        }
    }
}
