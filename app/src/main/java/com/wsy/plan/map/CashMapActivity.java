package com.wsy.plan.map;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.wsy.plan.BaseActivity;
import com.wsy.plan.R;
import com.wsy.plan.common.SectionsPagerAdapter;
import com.wsy.plan.map.fragment.CashMapFragment;
import com.wsy.plan.map.fragment.InstructionFragment;
import com.wsy.plan.map.model.CashMapModel;

import java.util.LinkedList;
import java.util.List;

public class CashMapActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_map);

        initToolbar();

        String[] titles = getResources().getStringArray(R.array.map_tab_title);
        final List<Fragment> fragments = new LinkedList<>();
        fragments.add(InstructionFragment.newInstance());
        fragments.add(CashMapFragment.newInstance());

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), titles, fragments);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(1);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = ((CashMapFragment) fragments.get(1)).update();
                final Snackbar snackbar = Snackbar.make(view, "", Snackbar.LENGTH_LONG);
                snackbar.setAction("完成", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });
                switch (result) {
                    case CashMapModel.MAP_PERCENT_PERFECT:
                        snackbar.setText("保存成功！").show();
                        break;
                    case CashMapModel.MAP_PERCENT_LESS:
                        snackbar.setText("未保存，还没有完成100%分配哦！").show();
                        break;
                    case CashMapModel.MAP_PERCENT_MORE:
                        snackbar.setText("未保存，分配比例超过了100% ！").show();
                        break;
                    default:
                        break;
                }
            }
        });
        if (mViewPager.getCurrentItem() == 1) {
            fab.setVisibility(View.VISIBLE);
        } else {
            fab.setVisibility(View.INVISIBLE);
        }
    }
}
