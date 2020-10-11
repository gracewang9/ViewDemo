package com.example.viewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawPathLinerView extends View {
    public DrawPathLinerView(Context context) {
        super(context);
    }

    public DrawPathLinerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawPathLinerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Path path=new Path();
    Paint paint=new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        path.lineTo(100, 100); // 由当前位置 (0, 0) 向 (100, 100) 画一条直线
        path.rLineTo(100, 0); // 由当前位置 (100, 100) 向正右方 100 像素的位置画
        canvas.drawPath(path,paint);

    }
}
