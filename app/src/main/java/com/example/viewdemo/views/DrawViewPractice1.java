package com.example.viewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawViewPractice1 extends View {
    public DrawViewPractice1(Context context) {
        super(context);
    }

    public DrawViewPractice1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawViewPractice1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint paint = new Paint();
    private Path path = new Path();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#4B616D"));
        paint.setColor(Color.WHITE);
        canvas.drawLine(100, 0, 100, 800, paint);
        canvas.drawLine(100, 800, 1000, 800, paint);

        float left = 120;
        float right = 140;
        float x = 100;

        float top = 750;
        for (int i = 0; i < 5; i++) {
            paint.setColor(Color.parseColor("#5C9737"));
            canvas.drawRect(left, top, right, 800, paint);

            paint.setColor(Color.WHITE);
            paint.setTextSize(30);
            canvas.drawText("Froyo" + i, x, 830, paint);
            left += 130;
            right += 130;
            x += 130;

            if (i % 2 == 0) {
                top -= 100;
            }else {
                if (i==3){
                    top = 780;
                }else
                top -= 50;
            }

        }
    }
}
