package com.wsy.plan.map;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.wsy.plan.BaseActivity;
import com.wsy.plan.R;
import com.wsy.plan.common.SectionsPagerAdapter;
import com.wsy.plan.map.fragment.CashMapFragment;
import com.wsy.plan.map.fragment.InstructionFragment;

import java.util.LinkedList;
import java.util.List;

public class CashMapActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_map);

        initToolbar();

        String[] titles = getResources().getStringArray(R.array.map_tab_title);
        List<Fragment> fragments = new LinkedList<>();
        fragments.add(InstructionFragment.newInstance());
        fragments.add(CashMapFragment.newInstance());

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), titles, fragments);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(1);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }
}
