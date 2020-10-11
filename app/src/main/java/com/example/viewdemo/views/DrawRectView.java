package com.example.viewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawRectView extends View {
    public DrawRectView(Context context) {
        super(context);
    }

    public DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint mPaint=new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(100,100,500,500,mPaint);


        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.DKGRAY);
        RectF rectF=new RectF();
        rectF.set(600,100,1000,500);
        canvas.drawRect(rectF,mPaint);


        mPaint.setColor(Color.BLUE);
        Rect rect=new Rect();
        rect.set(100,600,500,1000);
        canvas.drawRect(rect,mPaint);

    }
}
