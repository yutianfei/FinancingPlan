package com.wsy.plan.main.model;

import android.content.Context;

import com.wsy.plan.R;

/**
 * 类型数组
 */

public class TypeArrays {

    public static String[] getMethod(Context context) {
        return context.getResources().getStringArray(R.array.main_method);
    }

    public static String[] getFirst(Context context) {
        return context.getResources().getStringArray(R.array.main_first);
    }

    public static String[][] get(Context context) {
        String[] food = context.getResources().getStringArray(R.array.food);
        String[] food2 = context.getResources().getStringArray(R.array.food2);
        String[] drink = context.getResources().getStringArray(R.array.drink);
        String[] commodity = context.getResources().getStringArray(R.array.commodity);
        String[] traffic = context.getResources().getStringArray(R.array.traffic);
        String[] hospital = context.getResources().getStringArray(R.array.hospital);
        String[] dress = context.getResources().getStringArray(R.array.dress);
        String[] online = context.getResources().getStringArray(R.array.online);
        String[] tourism = context.getResources().getStringArray(R.array.tourism);
        String[] red = context.getResources().getStringArray(R.array.red);
        String[] regular = context.getResources().getStringArray(R.array.regular);
        String[] loan = context.getResources().getStringArray(R.array.loan);
        String[] credit = context.getResources().getStringArray(R.array.credit);
        String[] other = context.getResources().getStringArray(R.array.other);
        String[] income = context.getResources().getStringArray(R.array.income);
        return new String[][]{food, food2, drink, commodity, traffic, hospital, dress, online,
                tourism, red, regular, loan, credit, other, income};
    }
}
