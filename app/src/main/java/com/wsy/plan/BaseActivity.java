package com.wsy.plan;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.wsy.plan.common.DividerItemDecoration;
import com.wsy.plan.main.adapter.AccountListAdapter;
import com.wsy.plan.rxbus.RxBus;

public class BaseActivity extends AppCompatActivity {

    protected void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    /**
     * 设置垂直列表形式的RecycleView
     */
    protected void initListRecycleView(int id, RecyclerView.Adapter adapter) {
        RecyclerView recyclerView = (RecyclerView) findViewById(id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    @Override
    public void onBackPressed() {
        RxBus.getInstance().post("onBackPressed");
        super.onBackPressed();
    }
}
