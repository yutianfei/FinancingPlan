package com.wsy.plan.setting;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.wsy.plan.BaseActivity;
import com.wsy.plan.R;
import com.wsy.plan.databinding.ActivitySettingBinding;

public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySettingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_setting);
        binding.setHandlers(this);
        initToolbar();
    }

    /**
     * 设置固定支出
     */
    public void settingFixed() {
        startActivity(new Intent(this, SettingFixedActivity.class));
    }
}
