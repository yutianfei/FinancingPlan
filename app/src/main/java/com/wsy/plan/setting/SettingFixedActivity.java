package com.wsy.plan.setting;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.wsy.plan.BaseActivity;
import com.wsy.plan.R;
import com.wsy.plan.common.FormatUtils;
import com.wsy.plan.setting.adapter.SettingFixedAdapter;
import com.wsy.plan.setting.model.TypeModel;
import com.wsy.plan.setting.presenter.ITypeModelPresenter;
import com.wsy.plan.setting.presenter.LocalPresenter;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class SettingFixedActivity extends BaseActivity {

    private ITypeModelPresenter presenter;
    private List<TypeModel> mList = new LinkedList<>();
    private SettingFixedAdapter adapter;

    private TextView tvMoneyTotal;
    private TextView tvNumber;

    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_fixed);

        initToolbar();
        initRecyclerView();
        tvMoneyTotal = (TextView) findViewById(R.id.tv_fixed_total);
        tvNumber = (TextView) findViewById(R.id.tv_fixed_number);
        toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);

        presenter = new LocalPresenter(this);
        initList();
    }

    private void initRecyclerView() {
        adapter = new SettingFixedAdapter(mList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fixed_list);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                return makeMovementFlags(0, ItemTouchHelper.START);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                deleteModel(position);
            }
        });
        initListRecyclerView(recyclerView, adapter, itemTouchHelper);
    }

    private void initList() {
        List<TypeModel> list = presenter.getSpecialModels(R.string.regular, R.array.regular);
        if (list != null && list.size() > 0) {
            mList.clear();
            mList.addAll(list);
        }
        adapter.notifyDataSetChanged();
        tvNumber.setText(getString(R.string.setting_fixed_number, mList.size()));
        refreshTotal();
    }

    /**
     * 计算总额
     */
    private void refreshTotal() {
        BigDecimal total = new BigDecimal("0");
        for (TypeModel model : mList) {
            total = total.add(new BigDecimal(TextUtils.isEmpty(model.getType_money()) ? "0" :
                    FormatUtils.formatMoney(model.getType_money())));
        }
        tvMoneyTotal.setText(getString(R.string.setting_fixed_money_total, total.toString()));
    }

    /**
     * 删除记录
     */
    private void deleteModel(int position) {
        if (presenter.deleteModel(mList.get(position).getId())) {
            adapter.notifyItemRemoved(position);
            mList.remove(position);
            tvNumber.setText(getString(R.string.setting_fixed_number, mList.size()));
            toast.setText(R.string.main_delete_successfully);
        } else {
            toast.setText(R.string.main_delete_failed);
        }
        toast.show();
    }

    /**
     * 添加记录
     */
    private void addModel() {
        TypeModel model = new TypeModel();
        model.setType_first(getString(R.string.regular));
        if (presenter.saveModel(model)) {
            mList.add(0, model);
            adapter.notifyDataSetChanged();
            tvNumber.setText(getString(R.string.setting_fixed_number, mList.size()));
        }
    }

    /**
     * 保存记录
     */
    private void saveModels() {
        boolean result = true;
        for (TypeModel model : mList) {
            if (!presenter.saveModel(model)) {
                result = false;
                break;
            }
        }
        if (result) {
            refreshTotal();
            toast.setText(R.string.main_save_successfully);
        } else {
            toast.setText(R.string.main_save_failed);
        }
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {
            addModel();
            return true;

        } else if (id == R.id.action_save) {
            saveModels();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}