package com.wsy.plan.common;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FormatUtils {

    public static String formatDate(Calendar calendar) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return format.format(calendar.getTime());
    }

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
