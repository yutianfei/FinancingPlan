package com.wsy.plan.common;

import android.text.TextUtils;

public class FormatUtils {

    public static String formatLabel(String str) {
        return TextUtils.isEmpty(str) ? "未定义" : str;
    }

    public static String formatSign(String str) {
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    public static String formatPercent(String str) {
        if (TextUtils.isEmpty(str) || "%".equals(str)) {
            str = "0%";
        }
        if (!str.contains("%")) {
            str = str + "%";
        }
        return str;
    }
}
