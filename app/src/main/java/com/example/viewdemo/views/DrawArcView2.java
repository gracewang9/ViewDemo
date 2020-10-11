package com.example.viewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawArcView2 extends View {
    public DrawArcView2(Context context) {
        super(context);
    }

    public DrawArcView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawArcView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint paint=new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.FILL); // 填充模式
        canvas.drawArc(200, 100, 800, 500, -110, 100, true, paint); // 绘制扇
        canvas.drawArc(200, 100, 800, 500, 20, 140, false, paint); // 绘制弧形
        paint.setStyle(Paint.Style.STROKE); // 画线模式
        canvas.drawArc(200, 100, 800, 500, 180, 60, false, paint); // 绘制
    }
}
