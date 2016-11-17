package com.wsy.plan.common;

import android.text.Editable;
import android.text.TextWatcher;

public abstract class MyTextChangedListener implements TextWatcher {

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
        doSomething(editable);
    }

    /**
     * 当输入字符后进行的操作
     */
    public abstract void doSomething(Editable editable);
}
