package com.example.viewdemo;

import android.content.Context;
import android.provider.Settings;
import android.util.TypedValue;

public class Constants {

    public static float dp2px(float value, Context context) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());
    }
}
