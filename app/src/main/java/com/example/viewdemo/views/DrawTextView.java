package com.example.viewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.viewdemo.Constants;

public class DrawTextView extends View {
    private Paint mPaint;
    private float width = Constants.dp2px(20f);
    private Rect bounds;
    private Paint.FontMetrics fontMetrics;

    public DrawTextView(Context context) {
        this(context, null);
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(20f);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        bounds = new Rect();
        fontMetrics=new Paint.FontMetrics();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 200f, mPaint);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(getWidth() / 2 - 200f, getHeight() / 2 - 200f, getWidth() / 2 + 200f,
                getHeight() / 2 + 200f, -90, 160f, false, mPaint);
        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(Constants.dp2px(18f));
        //居中显示
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.getTextBounds("abapa", 0, "abapa".length(), bounds);
        canvas.drawText("abapa", getWidth() / 2, getHeight() / 2 - (bounds.top + bounds.bottom) / 2, mPaint);
        //向左对齐
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.getFontMetrics(fontMetrics);
        mPaint.getTextBounds("abapa", 0, "abapa".length(), bounds);
        canvas.drawText("abapa", 0, -bounds.top, mPaint);


    }
}
