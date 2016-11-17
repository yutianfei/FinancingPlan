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
import com.wsy.plan.common.Constants;
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
        final List<Fragment> fragments = new LinkedList<>();
        fragments.add(InstructionFragment.newInstance());
        fragments.add(CashMapFragment.newInstance());

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), titles, fragments);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(1);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = ((CashMapFragment) fragments.get(1)).update();
                final Snackbar snackbar = Snackbar.make(view, "", Snackbar.LENGTH_LONG);
                snackbar.setAction(R.string.snackbar_action_complete, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });
                switch (result) {
                    case Constants.RESULT_PERFECT:
                        snackbar.setText(R.string.snackbar_save_ok).show();
                        break;
                    case Constants.RESULT_LESS:
                        snackbar.setText(R.string.snackbar_failed_less).show();
                        break;
                    case Constants.RESULT_MORE:
                        snackbar.setText(R.string.snackbar_failed_more_percent).show();
                        break;
                    default:
                        break;
                }
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    fab.setVisibility(View.GONE);
                } else {
                    fab.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
