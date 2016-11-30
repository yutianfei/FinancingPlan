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
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Html;
import android.text.TextUtils;
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
import com.wsy.plan.common.OnRecyclerItemClickListener;
import com.wsy.plan.common.Utils;
import com.wsy.plan.function.FunctionAssignActivity;
import com.wsy.plan.main.adapter.AccountListAdapter;
import com.wsy.plan.main.decorator.TodayDecorator;
import com.wsy.plan.common.DividerItemDecoration;
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

    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private MaterialCalendarView calendarView;
    private TextView tvMainNotice, tvIncome, tvOut;
    private RecyclerView recordsList;

    private IAccountModelPresenter presenter = new LocalPresenter();
    private List<AccountModel> modelList = new ArrayList<>();
    private AccountListAdapter adapter;
    private String currentDate = "";
    private Toast toast;

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
        tvIncome = (TextView) findViewById(R.id.tv_main_income);
        tvOut = (TextView) findViewById(R.id.tv_main_out);
        toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);

        initCalendarView();
        initAppBarLayout();
        initSubscription();
        initRecycleView();

        // 默认选中当天日期
        setSelectedDay(CalendarDay.today());
    }

    private void initRecycleView() {
        recordsList = (RecyclerView) findViewById(R.id.records_list);
        recordsList.setHasFixedSize(true);
        recordsList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new AccountListAdapter(modelList);
        recordsList.setAdapter(adapter);
        recordsList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recordsList.addOnItemTouchListener(new OnRecyclerItemClickListener(recordsList) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder viewHolder) {
                int position = viewHolder.getAdapterPosition();
                UpdateActivity.startAction(MainActivity.this, position, modelList.get(position));
            }
        });

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
        itemTouchHelper.attachToRecyclerView(recordsList);
    }

    private void initSubscription() {
        Subscription addSubscription = RxBus.getInstance().toObserverable(AccountModel.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<AccountModel>() {
                    @Override
                    public void call(AccountModel model) {
                        addModel(model);
                    }
                });
        Subscription updateSubscription = RxBus.getInstance().toObserverable(Object[].class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Object[]>() {
                    @Override
                    public void call(Object[] obj) {
                        int position = (int) obj[0];
                        AccountModel model = (AccountModel) obj[1];
                        updateModel(position, model);
                    }
                });
        RxBus.getInstance().addSubscription(this, addSubscription);
        RxBus.getInstance().addSubscription(this, updateSubscription);
    }

    private void initAppBarLayout() {
        // 使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
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
        // 给当天日期添加背景
        ArrayList<CalendarDay> dates = new ArrayList<>();
        dates.add(CalendarDay.today());
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
            mCollapsingToolbarLayout.setTitle(selectDate);
            currentDate = selectDate;
            refreshList();
        }
    }

    /**
     * 刷新当日记录显示
     */
    private void refreshList() {
        modelList.clear();
        modelList.addAll(presenter.getModels(currentDate));
        if (modelList.size() > 0) {
            adapter.notifyDataSetChanged();
        }
        refreshTotal();
    }

    /**
     * 添加记录
     */
    private void addModel(AccountModel model) {
        String money = TextUtils.isEmpty(model.account_money.get()) ? "0" : model.account_money.get();
        model.account_money.set(money);
        modelList.add(model);
        adapter.notifyDataSetChanged();
        refreshTotal();
    }

    /**
     * 删除记录
     */
    private void deleteModel(int position) {
        if (presenter.deleteModel(modelList.get(position).id.get())) {
            adapter.notifyItemRemoved(position);
            modelList.remove(position);
            refreshTotal();
            toast.setText(R.string.main_delete_successfully);
        } else {
            toast.setText(R.string.main_delete_failed);
        }
        toast.show();
    }

    /**
     * 更新记录
     */
    private void updateModel(int position, AccountModel model) {
        modelList.remove(position);
        modelList.add(position, model);
        adapter.notifyItemChanged(position);
        refreshTotal();
    }

    /**
     * 更新统计数据
     */
    private void refreshTotal() {
        String strIncome = "0";
        String strOut = "0";
        if (modelList.size() > 0) {
            tvMainNotice.setVisibility(View.GONE);
            recordsList.setVisibility(View.VISIBLE);
            // 计算收入和支出
            BigDecimal total = new BigDecimal("0");
            BigDecimal income = new BigDecimal("0");
            for (AccountModel model : modelList) {
                total = total.add(new BigDecimal(model.account_money.get()));
                if (getString(R.string.income).equals(model.account_first.get())) {
                    income = income.add(new BigDecimal(model.account_money.get()));
                }
            }
            strIncome = income.toString();
            strOut = total.subtract(income).toString();
        } else {
            tvMainNotice.setVisibility(View.VISIBLE);
            recordsList.setVisibility(View.GONE);
        }
        tvIncome.setText(Html.fromHtml(getString(R.string.main_notice_income, strIncome)));
        tvOut.setText(Html.fromHtml(getString(R.string.main_notice_out, strOut)));
    }

    /**
     * 设置当前日期
     */
    private void setSelectedDay(CalendarDay day) {
        calendarView.setSelectedDate(day);
        calendarView.setCurrentDate(day);
        onDateSelected(calendarView, day, true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unSubscribe(this);
    }
}
