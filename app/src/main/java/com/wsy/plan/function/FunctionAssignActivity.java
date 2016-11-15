package com.wsy.plan.function;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.wsy.plan.BaseActivity;
import com.wsy.plan.R;
import com.wsy.plan.common.SectionsPagerAdapter;
import com.wsy.plan.function.fragment.CashFragment;
import com.wsy.plan.function.fragment.InstructionFragment;
import com.wsy.plan.function.fragment.PercentFragment;

import java.util.LinkedList;
import java.util.List;

public class FunctionAssignActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_assign);

        initToolbar();

        List<Fragment> fragments = new LinkedList<>();
        fragments.add(InstructionFragment.newInstance());
        fragments.add(PercentFragment.newInstance());
        fragments.add(CashFragment.newInstance());

        String[] titles = getResources().getStringArray(R.array.fa_tab_title);

        /*
         * The {@link android.support.v4.view.PagerAdapter} that will provide
         * fragments for each of the sections. We use a
         * {@link FragmentPagerAdapter} derivative, which will keep every
         * loaded fragment in memory. If this becomes too memory intensive, it
         * may be best to switch to a
         * {@link android.support.v4.app.FragmentStatePagerAdapter}.
         */
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), titles, fragments);

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(1);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

}
