package com.example.viewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawOvalView extends View {
    public DrawOvalView(Context context) {
        super(context);
    }

    public DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint paint=new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(20);
        canvas.drawOval(100,100,400,300,paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawOval(700,100,500,300,paint);
    }
}
