package com.example.viewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawLinesView extends View {
    public DrawLinesView(Context context) {
        super(context);
    }

    public DrawLinesView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawLinesView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint paint=new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        float[] floats={20, 20, 120, 20, 70, 20, 70, 120, 20, 120, 120, 12};
        canvas.drawLines(floats,2,8,paint);
    }
}
