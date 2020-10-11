package com.example.viewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawCircleView extends View {
    public DrawCircleView(Context context) {
        super(context);
    }

    public DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        canvas.drawCircle(300, 300, 200, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(20);
        canvas.drawCircle(800,300,200,paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(300,800,200,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(50);
        canvas.drawCircle(800,800,200,paint);

    }
}
