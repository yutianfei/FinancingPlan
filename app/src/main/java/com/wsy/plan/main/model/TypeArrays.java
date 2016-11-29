package com.wsy.plan.main.model;

import android.content.Context;

import com.wsy.plan.R;

/**
 * 类型数组
 */

public class TypeArrays {

    public static String[][] get(Context context) {
        String[] food = context.getResources().getStringArray(R.array.food);
        String[] dress = context.getResources().getStringArray(R.array.dress);
        String[] income = context.getResources().getStringArray(R.array.income);
        return new String[][]{food, dress, income};
    }
}
