package com.example.viewdemo.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.viewdemo.R;

public class DrawBitmapView extends View {
    private Context context;

    public DrawBitmapView(Context context) {
        super(context);
        this.context = context;
    }

    public DrawBitmapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public DrawBitmapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();


//        paint.setStyle(Paint.Style.FILL);
        @SuppressLint("DrawAllocation")
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.light);
//        canvas.drawBitmap(bitmap, 100, 100, paint);


        Matrix matrix=new Matrix();
        //平移
//        matrix.setTranslate(1f,0.5f);
//        canvas.drawBitmap(bitmap,matrix,paint);
//        //缩放
//        matrix.setScale(0.5f,0.5f,1000,400);
//        canvas.drawBitmap(bitmap,matrix,paint);
//        //倾斜
//        matrix.setSkew(1.5f,1.0f,1000,500);
//        canvas.drawBitmap(bitmap,matrix,paint);

        //旋转
        paint.setColor(Color.BLACK);
        paint.setTextSize(50);
        canvas.drawText("旋转90度",600,500,paint);
        matrix.setRotate(90,100,500);
        canvas.drawBitmap(bitmap,matrix,paint);
    }
}
