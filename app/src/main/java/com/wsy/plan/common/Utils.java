package com.wsy.plan.common;

import android.app.DatePickerDialog;
import android.content.Context;

import com.prolificinteractive.materialcalendarview.CalendarDay;

public class Utils {

    /**
     * 时间选择窗口
     */
    public static void showDatePickerDialog(Context context, CalendarDay day,
                                            DatePickerDialog.OnDateSetListener callback) {
        if (day == null) {
            day = CalendarDay.today();
        }
        DatePickerDialog dialog = new DatePickerDialog(
                context, 0, callback, day.getYear(), day.getMonth(), day.getDay()
        );
        dialog.show();
    }
}
