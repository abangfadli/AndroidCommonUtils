package com.abangfadli.commonutils.datetime;

import android.support.annotation.NonNull;

/**
 * Created by ahmadfadli on 5/2/16.
 */
public class AFTime implements Comparable<AFTime>{
    private int hour;
    private int minute;
    private int second;

    public AFTime(int hour) {
        this.hour = hour;
    }

    public AFTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public AFTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public int compareTo(@NonNull AFTime another) {
        int dif = hour - another.getHour();
        if(dif == 0) {
            dif = minute - another.getMinute();
            if(dif == 0) {
                dif = second = another.getSecond();
            }
        }

        return dif;
    }

    @Override
    public String toString() {
        return toString(true);
    }

    public String toString(boolean includeSecond) {
        if(includeSecond) {
            return String.format("%s:%s:%s", hour, minute, second);
        } else {
            return String.format("%s:%s", hour, minute);
        }
    }
}
