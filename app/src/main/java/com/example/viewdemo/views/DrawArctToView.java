package com.example.viewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawArctToView extends View {
    public DrawArctToView(Context context) {
        super(context);
    }

    public DrawArctToView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawArctToView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Path path = new Path();
    private Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        path.moveTo(100,500);
        path.lineTo(300,500);//
        path.addCircle(250, 200, 200, Path.Direction.CW);

        path.arcTo(100f,100f,500f,500f,90f,-90f,true);
        //forceMoveTo 参数的意思是，绘制是要「抬一 下笔移动过去」，还是「直接拖着笔过去」，区别在于是否留下移动的痕迹
//        path.addCircle(300, 300, 200, Path.Direction.CW);

        paint.setStyle(Paint.Style.STROKE);
        path.moveTo(100, 100);
        path.lineTo(200, 100);
        path.lineTo(150, 150);
        path.close(); // 使用 close() 封闭子图形。等价于 path.lineTo(100, 100)
//close() 和 lineTo(起点坐标) 是完全等价的。
        canvas.drawPath(path, paint);
    }
}
