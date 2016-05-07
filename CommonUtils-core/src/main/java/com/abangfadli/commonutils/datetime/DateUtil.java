package com.abangfadli.commonutils.datetime;

import java.util.Calendar;

/**
 * Created by ahmadfadli on 5/2/16.
 */
public class DateUtil {
    public static AFTime getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        return new AFTime(hour, minute, second);
    }
}
