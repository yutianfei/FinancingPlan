package com.wsy.plan.common;

import android.text.TextUtils;

import java.math.BigDecimal;

public class BigDecimalUtils {

    /**
     * 提供精确加法计算的add方法
     *
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static String add(String value1, String value2) {
        value1 = TextUtils.isEmpty(value1) ? "0" : value1;
        value2 = TextUtils.isEmpty(value2) ? "0" : value2;
        return new BigDecimal(value1).add(new BigDecimal(value2)).toString();
    }

    /**
     * 提供精确加法计算的add方法
     *
     * @param values 加数集合
     * @return 参数的和
     */
    public static String add(String[] values) {
        BigDecimal bigDecimal = new BigDecimal("0");
        for (String value : values) {
            value = TextUtils.isEmpty(value) ? "0" : value;
            bigDecimal = bigDecimal.add(new BigDecimal(value));
        }
        return bigDecimal.toString();
    }

    /**
     * 提供精确减法运算的sub方法
     *
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public static String sub(String value1, String value2) {
        value1 = TextUtils.isEmpty(value1) ? "0" : value1;
        value2 = TextUtils.isEmpty(value2) ? "0" : value2;
        return new BigDecimal(value1).subtract(new BigDecimal(value2)).toString();
    }

    /**
     * 提供精确乘法运算的mul方法
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static String multiply(String value1, String value2) {
        value1 = TextUtils.isEmpty(value1) ? "0" : value1;
        value2 = TextUtils.isEmpty(value2) ? "0" : value2;
        BigDecimal result;
        result = new BigDecimal(value1).multiply(new BigDecimal(value2));
        return String.valueOf(result);
    }

    /**
     * 提供精确乘法运算的mul方法
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static String multiplyPercent(String value1, String value2) {
        value1 = TextUtils.isEmpty(value1) ? "0" : value1;
        value2 = TextUtils.isEmpty(value2) ? "0" : value2;
        String v1 = value1;
        String v2 = value2;
        BigDecimal result;
        if (value1.contains("%")) {
            v1 = value1.substring(0, value1.indexOf("%"));
        }
        if (value2.contains("%")) {
            v2 = value2.substring(0, value2.indexOf("%"));
        }
        if ("%".equals(value1)) {
            v1 = "0";
        }
        if ("%".equals(value2)) {
            v2 = "0";
        }
        if (TextUtils.isEmpty(v1)) {
            v1 = "0";
        }
        if (TextUtils.isEmpty(v2)) {
            v2 = "0";
        }
        result = new BigDecimal(v1).multiply(new BigDecimal(v2))
                .divide(new BigDecimal("100"), BigDecimal.ROUND_HALF_UP);
        return String.valueOf(result);
    }

    /**
     * 提供精确的除法运算方法divide
     *
     * @param value1 被除数
     * @param value2 除数
     * @param scale  表示需要精确到小数点以后几位（ scale > 0 ）
     * @return 两个参数的商
     */
    public static String divide(String value1, String value2, int scale) {
        value1 = TextUtils.isEmpty(value1) ? "0" : value1;
        value2 = TextUtils.isEmpty(value2) ? "0" : value2;
        BigDecimal v1 = new BigDecimal(value1);
        BigDecimal v2 = new BigDecimal(value2);
        BigDecimal result = v1.divide(v2, scale, BigDecimal.ROUND_HALF_UP);
        return String.valueOf(result.multiply(new BigDecimal("100")).doubleValue()) + "%";
    }

    /**
     * 提供精确的除法运算方法divide（默认精确度4）
     *
     * @param value1 被除数
     * @param value2 除数
     * @return 两个参数的商
     */
    public static String divide(String value1, String value2) {
        return divide(value1, value2, 4);
    }
}
