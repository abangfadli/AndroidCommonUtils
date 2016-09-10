package com.abangfadli.commonutils.converter;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class UnitConverter {
    public float sp_px(Context context, float sp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }

    public float dp_px(Context context, float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }
}
