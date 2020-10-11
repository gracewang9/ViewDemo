package com.example.viewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawPointView extends View {
    public DrawPointView(Context context) {
        super(context);
    }

    public DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint mPaint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(100);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(100, 100, mPaint);

        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(250, 100, mPaint);

        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(400, 100, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(100,250,mPaint);

        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(250,250,mPaint);


        mPaint.setStrokeWidth(10);
        canvas.drawLine(10,500,1050,500,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(2);
        mPaint.setTextSize(50);
        canvas.drawText("绘制批量点",10,480,mPaint);

        mPaint.setStrokeWidth(20);
        float[] floats={0,0,50,600,150,600,50,700,150,700};
        canvas.drawPoints(floats,2,8,mPaint);

    }
}
