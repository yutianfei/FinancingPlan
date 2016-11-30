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

    public static String formatMoney(String str) {
        String money = TextUtils.isEmpty(str) ? "0" : str;
        if (".".equals(money)) {
            money = "0";
        }
        if (money.contains(".")) {
            String[] numbers = money.split("\\.");
            if (numbers.length > 1) {
                if (numbers[1].length() > 2) {
                    money = numbers[0] + "." + numbers[1].substring(0, 2);
                } else {
                    money = numbers[0] + "." + numbers[1];
                }
            } else {
                money = numbers[0];
            }
        }
        if (money.contains(".")) {
            String decimal = money.substring(money.indexOf(".") + 1);
            if ("00".equals(decimal) || "0".equals(decimal)) {
                money = money.substring(0, money.indexOf("."));
            } else if (decimal.charAt(decimal.length() - 1) == '0') {
                money = money.substring(0, money.length() - 1);
            }
        }
        return money;
    }

}
