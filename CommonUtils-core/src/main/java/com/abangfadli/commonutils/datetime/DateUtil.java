package com.abangfadli.commonutils.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ahmadfadli on 5/2/16.
 */
public class DateUtil {
    public static AFTime getAFTime() {
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

    public static String format(Date date, String format, Locale locale) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
        return sdf.format(date);
    }

    public static String format(int year, int month, int dayOfMonth, String format, Locale locale) {
        Calendar calendar = getCurrentCalendar();
        calendar.set(year, month, dayOfMonth);
        return format(calendar.getTime(), format, locale);
    }

    public static String changeFormat(String dateString, String currentFormat, String newFormat, Locale locale) {
        SimpleDateFormat sdf = new SimpleDateFormat(currentFormat, locale);
        try {
            Date date = sdf.parse(dateString);
            return format(date, newFormat, locale);
        } catch (ParseException e) {
            e.printStackTrace();
            return dateString;
        }
    }

    public static Date parse(String dateString, String format, Locale locale) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date getCurrentDate() {
        return getCurrentCalendar().getTime();
    }

    public static Calendar getCurrentCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getMinimum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getMinimum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getMinimum(Calendar.MILLISECOND));

        return calendar;
    }
}
