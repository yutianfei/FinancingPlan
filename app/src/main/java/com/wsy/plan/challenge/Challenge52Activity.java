package com.wsy.plan.challenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wsy.plan.R;
import com.wsy.plan.challenge.adapter.ChallengeListAdapter;
import com.wsy.plan.challenge.model.ChallengeDBModel;
import com.wsy.plan.challenge.model.ChallengeModel;
import com.wsy.plan.challenge.presenter.IChallengeModelPresenter;
import com.wsy.plan.challenge.presenter.LocalPresenter;
import com.wsy.plan.common.MyEditorActionListener;

import java.util.ArrayList;
import java.util.List;

public class Challenge52Activity extends AppCompatActivity {

    private IChallengeModelPresenter presenter;
    private List<ChallengeDBModel> dbList;
    private List<ChallengeModel> list = new ArrayList<>();
    private ChallengeListAdapter adapter;

    private EditText editPerWeek;

    private String perWeekOriginal; // 初始每周存的钱，用作以后的比较

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge52);

        initToolbar();
        initEditView();
        initRecyclerView();

        // 读取数据
        presenter = new LocalPresenter();
        dbList = presenter.getModels();
        // 给作为比较的数据赋值
        perWeekOriginal = dbList.get(0).store;
        editPerWeek.setText(perWeekOriginal);
        // 设置显示数据
        updateShowList();
    }

    private void initRecyclerView() {
        RecyclerView challengeTable = (RecyclerView) findViewById(R.id.challenge_table);
        challengeTable.setHasFixedSize(true);
        challengeTable.setLayoutManager(new GridLayoutManager(this, 4));
        adapter = new ChallengeListAdapter(list);
        challengeTable.setAdapter(adapter);
    }

    private void initEditView() {
        editPerWeek = (EditText) findViewById(R.id.edit_per_week);
        editPerWeek.setOnEditorActionListener(new MyEditorActionListener() {
            @Override
            public void doSomething() {
                compute();
            }
        });
    }

    private void initToolbar() {
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
     * 重新计算并显示
     */
    private void compute() {
        // TODO
    }

    private void updateShowList() {
        list.clear();
        for (ChallengeDBModel dbModel : dbList) {
            ChallengeModel model = new ChallengeModel();
            model.flag.set(dbModel.flag);
            model.id.set(dbModel.id);
            model.store.set(dbModel.store);
            model.total.set(dbModel.total);
            list.add(model);
        }
        adapter.notifyDataSetChanged();
    }

    /**
     * 处理点击事件
     */
    public void onClickWeekItem(ChallengeModel item) {
        int id = item.id.get();
        int flag = item.flag.get();
        // 重新设置标志
        if (flag == 0) {
            flag = 1;
        } else if (flag == 1) {
            flag = 0;
        }
        // 更新数据库：完成情况
        ChallengeDBModel dbModel = dbList.get(id - 1);
        dbModel.flag = flag;
        presenter.updateDBModel(dbModel);
        // 更新显示
        ChallengeModel model = list.get(id - 1);
        model.flag.set(flag);
    }
}