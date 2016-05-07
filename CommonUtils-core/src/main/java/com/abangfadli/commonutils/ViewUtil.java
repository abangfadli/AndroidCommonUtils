package com.abangfadli.commonutils;

import android.widget.TextView;

/**
 * Created by ahmadfadli on 4/14/16.
 */
public class ViewUtil {
    public static void setTextIfNotNull(TextView tv, String text) {
        if(!StringUtil.isNullOrEmpty(text)) {
            tv.setText(text);
        }
    }

    public static void setText(TextView tv, String text, String defaultIfNull) {
        if(!StringUtil.isNullOrEmpty(text)) {
            tv.setText(text);
        } else {
            tv.setText(defaultIfNull);
        }
    }
}
