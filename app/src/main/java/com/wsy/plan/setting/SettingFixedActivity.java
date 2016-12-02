package com.wsy.plan.setting;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.wsy.plan.BaseActivity;
import com.wsy.plan.R;
import com.wsy.plan.setting.adapter.SettingFixedAdapter;
import com.wsy.plan.setting.model.TypeModel;

import java.util.ArrayList;
import java.util.List;

public class SettingFixedActivity extends BaseActivity {

    private List<TypeModel> mList = new ArrayList<>();
    private SettingFixedAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_fixed);

        initToolbar();

        adapter = new SettingFixedAdapter(mList);
        initListRecycleView(R.id.fixed_list, adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Snackbar snackbar = Snackbar.make(view, "", Snackbar.LENGTH_LONG);
                snackbar.setAction(R.string.snackbar_action_complete, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });
                snackbar.setText(R.string.snackbar_save_ok).show();
            }
        });

        initList();
    }

    private void initList() {
        TypeModel model = new TypeModel();
        model.setType_date("1");
        model.setType_first("固定支出");
        model.setType_second("房租");
        mList.add(model);
        TypeModel model2 = new TypeModel();
        model2.setType_date("5");
        model2.setType_first("固定支出");
        model2.setType_second("车贷");
        mList.add(model2);
        adapter.notifyDataSetChanged();
    }
}