package com.wsy.plan.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wsy.plan.R;
import com.wsy.plan.databinding.ActivityAddBinding;
import com.wsy.plan.main.model.AccountModel;

public class AddActivity extends AppCompatActivity {

    private AccountModel model = new AccountModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add);
        binding.setModel(model);
        binding.setHandler(this);
    }

    /**
     * 点击保存按钮
     */
    public void onSaveClick() {
        // TODO: 保存数据
    }

    /**
     * 点击取消按钮
     */
    public void onCancelClick() {
        onBackPressed();
    }
}
