package com.wsy.plan.main;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.wsy.plan.R;
import com.wsy.plan.databinding.ActivityAddBinding;
import com.wsy.plan.main.model.AccountModel;
import com.wsy.plan.main.model.TypeArrays;
import com.wsy.plan.main.presenter.IAccountModelPresenter;
import com.wsy.plan.main.presenter.LocalPresenter;
import com.wsy.plan.rxbus.RxBus;

public class AddActivity extends AppCompatActivity {

    private Spinner spinnerMethod, spinnerFirst, spinnerSecond;

    private String[][] typeArrays;
    private AccountModel model = new AccountModel();
    private IAccountModelPresenter presenter = new LocalPresenter();

    public static void startAction(Context context, String date) {
        Intent intent = new Intent(context, AddActivity.class);
        intent.putExtra("date", date);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add);
        binding.setModel(model);
        binding.setHandler(this);

        // 取消点击窗口外部关闭窗口
        setFinishOnTouchOutside(false);

        if (getIntent() != null) {
            model.account_date.set(getIntent().getStringExtra("date"));
        }

        initSpinners();
    }

    private void initSpinners() {
        spinnerMethod = (Spinner) findViewById(R.id.spinner_account_method);
        spinnerFirst = (Spinner) findViewById(R.id.spinner_account_first);
        spinnerSecond = (Spinner) findViewById(R.id.spinner_add_second);

        typeArrays = TypeArrays.get(this);
        spinnerFirst.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerSecond.setAdapter(new ArrayAdapter<>(AddActivity.this,
                        android.R.layout.simple_spinner_dropdown_item, typeArrays[i]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    /**
     * 点击保存按钮
     */
    public void onSaveClick() {
        model.account_flag.set(getString(R.string.income).equals(spinnerFirst.getSelectedItem()) ? 1 : 0);
        model.account_method.set((String) spinnerMethod.getSelectedItem());
        model.account_first.set((String) spinnerFirst.getSelectedItem());
        model.account_second.set((String) spinnerSecond.getSelectedItem());
        long id = presenter.saveModel(model);
        if ( id > -1) {
            model.id.set(id);
            Toast.makeText(this, R.string.main_save_successfully, Toast.LENGTH_SHORT).show();
            RxBus.getInstance().post(model);
            onBackPressed();
        } else {
            Toast.makeText(this, R.string.main_save_failed, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 点击取消按钮
     */
    public void onCancelClick() {
        onBackPressed();
    }
}
