package com.wsy.plan.function;

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

        final List<Fragment> fragments = new LinkedList<>();
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
        final ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(1);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = -1;
                switch (mViewPager.getCurrentItem()) {
                    case 1:
                        result = ((PercentFragment) fragments.get(1)).update();
                        break;
                    case 2:
                        result = ((CashFragment) fragments.get(2)).update();
                        break;
                    default:
                        break;
                }
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
                        snackbar.setText(R.string.snackbar_failed_more_money).show();
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
