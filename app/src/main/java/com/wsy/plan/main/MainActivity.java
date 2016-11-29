package com.wsy.plan.main;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;
import com.wsy.plan.R;
import com.wsy.plan.challenge.Challenge52Activity;
import com.wsy.plan.common.FormatUtils;
import com.wsy.plan.common.Utils;
import com.wsy.plan.function.FunctionAssignActivity;
import com.wsy.plan.main.adapter.AccountListAdapter;
import com.wsy.plan.main.decorator.TodayDecorator;
import com.wsy.plan.main.model.AccountModel;
import com.wsy.plan.main.presenter.IAccountModelPresenter;
import com.wsy.plan.main.presenter.LocalPresenter;
import com.wsy.plan.map.CashMapActivity;
import com.wsy.plan.rxbus.RxBus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnDateSelectedListener {

    private MaterialCalendarView calendarView;
    private TextView tvMainNotice;

    private IAccountModelPresenter presenter = new LocalPresenter();
    private List<AccountModel> modelList = new ArrayList<>();
    private AccountListAdapter adapter;
    private String currentDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddActivity.startAction(MainActivity.this, currentDate);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tvMainNotice = (TextView) findViewById(R.id.tv_main_notice);

        initCalendarView();
        initAppBarLayout();
        initSubscription();
        initRecycleView();
        refreshData();
    }

    private void refreshData() {
        modelList.clear();
        modelList.addAll(presenter.getModels());
        adapter.clearMapData();
        adapter.notifyDataSetChanged();
    }

    private void initRecycleView() {
        RecyclerView recordsList = (RecyclerView) findViewById(R.id.records_list);
        recordsList.setHasFixedSize(true);
        recordsList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new AccountListAdapter(modelList);
        recordsList.setAdapter(adapter);
    }

    private void initSubscription() {
        Subscription refreshSubscription = RxBus.getInstance().toObserverable(String.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        if ("OK".equals(s)) {
                            refreshData();
                        }
                    }
                });
        RxBus.getInstance().addSubscription(this, refreshSubscription);
    }

    private void initAppBarLayout() {
        // 使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mCollapsingToolbarLayout.setTitle(currentDate);
        // 透明度渐变
        AppBarLayout app_bar_layout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        app_bar_layout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float viewHeight = calendarView.getHeight();
                float offset = calendarView.getHeight() - Math.abs(verticalOffset);
                float alpha = new BigDecimal(offset).divide(new BigDecimal(viewHeight),
                        BigDecimal.ROUND_HALF_UP, 4).floatValue();
                calendarView.setAlpha(alpha);
            }
        });
    }

    private void initCalendarView() {
        calendarView = (MaterialCalendarView) findViewById(R.id.calendarView);
        // 设置日期显示
        calendarView.setTitleFormatter(new TitleFormatter() {
            @Override
            public CharSequence format(CalendarDay day) {
                return day.getYear() + "年" + (day.getMonth() + 1) + "月";
            }
        });
        // 默认选中当天日期
        CalendarDay today = CalendarDay.today();
        setSelectedDay(today);
        // 给当天日期添加背景
        ArrayList<CalendarDay> dates = new ArrayList<>();
        dates.add(today);
        calendarView.addDecorator(new TodayDecorator(dates, getDrawable(R.drawable.shape_circle_accent)));
        // 设置监听
        calendarView.setOnDateChangedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;

        } else if (id == R.id.action_today) {
            setSelectedDay(CalendarDay.today());
            return true;

        } else if (id == R.id.action_select) {
            Utils.showDatePickerDialog(this, calendarView.getSelectedDate(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    setSelectedDay(CalendarDay.from(year, monthOfYear, dayOfMonth));
                }
            });
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_function_assign) {
            // 功能账户现金流分配
            startActivity(new Intent(this, FunctionAssignActivity.class));

        } else if (id == R.id.nav_52_challenge) {
            // 52周存钱挑战表
            startActivity(new Intent(this, Challenge52Activity.class));

        } else if (id == R.id.nav_cash_map) {
            // 现金流分配地图
            startActivity(new Intent(this, CashMapActivity.class));

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        String selectDate = FormatUtils.formatDate(date.getCalendar()).substring(0, 11);
        if (!currentDate.equals(selectDate)) {
            Toast.makeText(MainActivity.this, selectDate, Toast.LENGTH_SHORT).show();
            currentDate = selectDate;
            showRecords();
        }
    }

    /**
     * 显示当日记录
     */
    private void showRecords() {
        // TODO
        tvMainNotice.setVisibility(View.GONE);
    }

    /**
     * 设置当前日期
     */
    private void setSelectedDay(CalendarDay day) {
        calendarView.setSelectedDate(day);
        calendarView.setCurrentDate(day);
        onDateSelected(calendarView, day, true);
    }

    /**
     * 处理点击事件
     */
    public void onClickWeekItem(View view, AccountModel item) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unSubscribe(this);
    }
}
