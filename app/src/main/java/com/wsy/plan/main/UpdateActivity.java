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
import com.wsy.plan.databinding.ActivityUpdateBinding;
import com.wsy.plan.main.model.AccountModel;
import com.wsy.plan.main.model.TypeArrays;
import com.wsy.plan.main.presenter.IAccountModelPresenter;
import com.wsy.plan.main.presenter.LocalPresenter;
import com.wsy.plan.rxbus.RxBus;

public class UpdateActivity extends AppCompatActivity {

    private Spinner spinnerMethod, spinnerFirst, spinnerSecond;

    private String[][] typeArrays;
    private int position;
    private AccountModel model = new AccountModel();
    private IAccountModelPresenter presenter = new LocalPresenter();

    private boolean isStart = true;

    public static void startAction(Context context, int position, AccountModel model) {
        Intent intent = new Intent(context, UpdateActivity.class);
        intent.putExtra("position", position);
        intent.putExtra("model", model);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUpdateBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_update);
        binding.setModel(model);
        binding.setHandler(this);

        // 取消点击窗口外部关闭窗口
        setFinishOnTouchOutside(false);

        if (getIntent() != null) {
            position = getIntent().getIntExtra("position", -1);
            AccountModel am = (AccountModel) getIntent().getSerializableExtra("model");
            model.id.set(am.id.get());
            model.account_date.set(am.account_date.get());
            model.account_method.set(am.account_method.get());
            model.account_first.set(am.account_first.get());
            model.account_second.set(am.account_second.get());
            model.account_money.set(am.account_money.get());
            model.account_comment.set(am.account_comment.get());
            model.account_flag.set(am.account_flag.get());
        }

        initSpinners();
    }

    private void initSpinners() {
        spinnerMethod = (Spinner) findViewById(R.id.spinner_account_method);
        spinnerFirst = (Spinner) findViewById(R.id.spinner_account_first);
        spinnerSecond = (Spinner) findViewById(R.id.spinner_add_second);

        typeArrays = TypeArrays.get(this);

        // 设置已有的选项
        for (int i = 0; i < TypeArrays.getMethod(this).length; i++) {
            if (TypeArrays.getMethod(this)[i].equals(model.account_method.get())) {
                spinnerMethod.setSelection(i);
            }
        }
        for (int j = 0; j < TypeArrays.getFirst(this).length; j++) {
            if (TypeArrays.getFirst(this)[j].equals(model.account_first.get())) {
                spinnerFirst.setSelection(j);
            }
        }

        // 绑定监听
        spinnerFirst.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerSecond.setAdapter(new ArrayAdapter<>(UpdateActivity.this,
                        android.R.layout.simple_spinner_dropdown_item, typeArrays[i]));
                if (isStart) { // 如果是初次选择，则默认选中保存的数据
                    for (int k = 0; k < spinnerSecond.getCount(); k++) {
                        if (spinnerSecond.getItemAtPosition(k).equals(model.account_second.get())) {
                            spinnerSecond.setSelection(k);
                        }
                    }
                    isStart = false;
                }
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
        if (presenter.updateModel(model.id.get(), model)) {
            Toast.makeText(this, R.string.main_update_successfully, Toast.LENGTH_SHORT).show();
            RxBus.getInstance().post(new Object[]{position, model});
            onBackPressed();
        } else {
            Toast.makeText(this, R.string.main_update_failed, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 点击取消按钮
     */
    public void onCancelClick() {
        onBackPressed();
    }
}
