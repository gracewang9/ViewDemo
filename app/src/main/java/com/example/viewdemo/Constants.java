package com.example.viewdemo;

import android.content.res.Resources;
import android.util.TypedValue;

public class Constants {

    public static float dp2px(float value) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, Resources.getSystem().getDisplayMetrics());
    }
}
