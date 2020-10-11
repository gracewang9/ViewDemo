package com.example.viewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawArcView extends View {
    public DrawArcView(Context context) {
        super(context);
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint paint = new Paint();
    Path path = new Path();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#4B6160"));
        //

//        paint.setStyle(Paint.Style.FILL); // 填充模式
//        canvas.drawArc(200, 100, 800, 500, -110, 100, true, paint); // 绘制扇
//        canvas.drawArc(200, 100, 800, 500, 20, 140, false, paint); // 绘制弧形
//        paint.setStyle(Paint.Style.STROKE); // 画线模式
//        canvas.drawArc(200, 100, 800, 500, 180, 60, false, paint); // 绘制不封
        //绘制扇
        paint.setColor(Color.parseColor("#C1423D"));
        paint.setAntiAlias(true);//锯齿
        canvas.drawArc(190, 190, 490, 490, -200, 100, true, paint);
        paint.setColor(Color.parseColor("#C89D1B"));
        canvas.drawArc(200, 200, 500, 500, -100, 50, true, paint);
        paint.setColor(Color.GREEN);
        canvas.drawArc(200, 200, 500, 500, -50, 50, true, paint);
        paint.setColor(Color.BLACK);
        canvas.drawArc(200, 200, 500, 500, -30, 150, true, paint);
        paint.setColor(Color.YELLOW);
        canvas.drawArc(200, 200, 500, 500, 120, 40, true, paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(50);
        canvas.drawText("饼图", 300, 680, paint);
        canvas.drawLine(0, 700, 1200, 700, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);

        path.moveTo(180,190);
        path.lineTo(250, 190);
        path.rLineTo(20, 20);
        canvas.drawPath(path, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        paint.setTextSize(50);
        canvas.drawText("Lollipop", 10, 200, paint);


        paint.setStyle(Paint.Style.STROKE);
        path.moveTo(450,175);
        path.rLineTo(50,-10);
        path.lineTo(600,175);
        canvas.drawPath(path,paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        paint.setTextSize(50);
        canvas.drawText("Marshmallow", 600, 200, paint);

    }
}
