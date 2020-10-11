package com.example.viewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawViewPractice2 extends View {
    public DrawViewPractice2(Context context) {
        super(context);
    }

    public DrawViewPractice2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawViewPractice2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Path path=new Path();
    private Paint paint=new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#4B616D"));
        //绘制扇形
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#C94342"));
        canvas.drawArc(150,150,680,680,-180,120,true,paint);


        paint.setColor(Color.parseColor("#C99E30"));
        //useCenter表示是否连接到圆心
        canvas.drawArc(150,150,700,700,-60,40,true,paint);


        paint.setColor(Color.parseColor("#783785"));
        //useCenter表示是否连接到圆心
        canvas.drawArc(150,150,700,700,-20,20,true,paint);


        paint.setColor(Color.parseColor("#7E878F"));
        canvas.drawArc(150,150,700,700,0,30,true,paint);


        paint.setColor(Color.parseColor("#127E85"));
        canvas.drawArc(150,150,700,700,30,60,true,paint);

        paint.setColor(Color.parseColor("#117EC2"));
        canvas.drawArc(150,150,700,700,90,90,true,paint);


        paint.setColor(Color.WHITE);
        paint.setTextSize(30);
        canvas.drawText("Lollipop",10,170,paint);
        canvas.drawLine(110,160,200,160,paint);
        canvas.drawLine(200,160,260,200,paint);

//        paint.setColor(Color.WHITE);
//        paint.setTextSize(30);
        canvas.drawText("Marshmallow",800,380,paint);
        canvas.drawLine(695,375,800,370,paint);
//        canvas.drawLine(650,270,700,230,paint);

        canvas.drawText("Marshmallow 2",800,240,paint);
        canvas.drawLine(700,230,800,230,paint);
        canvas.drawLine(650,270,700,230,paint);
    }
}
