package com.example.viewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawPathView extends View {
    public DrawPathView(Context context) {
        super(context);
    }

    public DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    Paint paint=new Paint();
    Path path=new Path();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 path 对图形进行描述（这段描述代码不必看懂）
        path.addArc(200, 200, 400, 400, -225, 225);
        path.arcTo(400, 200, 600, 400, -180, 225, false);
        path.lineTo(400, 542);

        canvas.drawPath(path,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        path.setFillType(Path.FillType.EVEN_ODD);
        path.addCircle(300,800,200,Path.Direction.CW);
        path.addCircle(500,800,200,Path.Direction.CCW);
        canvas.drawPath(path,paint);


        paint.setStyle(Paint.Style.FILL);
        path.setFillType(Path.FillType.WINDING);
        path.addCircle(300,1300,200,Path.Direction.CW);
        path.addCircle(500,1300,200,Path.Direction.CW);
        canvas.drawPath(path,paint);



    }
}
