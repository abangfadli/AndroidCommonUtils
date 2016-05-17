package com.abangfadli.commonutils.datetime;

import java.util.Calendar;

/**
 * Created by ahmadfadli on 5/2/16.
 */
public class DateUtil {
    public static AFTime getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        return getTime(cal);
    }

    public static AFTime getTime(Calendar calendar) {
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return new AFTime(hour, minute, second);
    }

    public static AFTime getTime(String timeString) {
        try {
            String[] splitted = timeString.split(":");
            int hour = Integer.parseInt(splitted[0]);
            int minute = Integer.parseInt(splitted[1]);
            int second = 0;
            if(splitted.length > 2) {
                second = Integer.parseInt(splitted[2]);
            }

            return new AFTime(hour, minute, second);
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
            return null;
        }
    }
}
