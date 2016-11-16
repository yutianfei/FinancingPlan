package com.wsy.plan.common;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

public abstract class MyEditorActionListener implements TextView.OnEditorActionListener {

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == EditorInfo.IME_ACTION_DONE) {
            // 隐藏软键盘
            InputMethodManager imm = (InputMethodManager) textView.getContext().getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            if (imm.isActive()) {
                imm.hideSoftInputFromWindow(textView.getApplicationWindowToken(), 0);
            }
            // 进行处理
            doSomething(textView);
            return true;
        }
        return false;
    }

    /**
     * 当点击完成时进行的操作
     */
    public abstract void doSomething(TextView textView);
}
