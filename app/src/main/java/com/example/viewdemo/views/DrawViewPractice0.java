package com.example.viewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawViewPractice0 extends View {
    private PathMeasure pathMeasure;
    private PathDashPathEffect pathEffect;
    private Path path;
    private Paint paint;
    private Paint textPaint;
    private Path dash;
    private float DASH_WIDTH = dp2px(1f);
    private float DASH_LENGTH = dp2px(5f);
    private float match = dp2px(20f);
    private float radius = dp2px(5f);//圆半径
    private int index = 5;
    private float textWidth;
    private int width;
    private int height;
    private OnItemSelectListener listener;

    public DrawViewPractice0(Context context) {
        this(context, null);
    }

    public DrawViewPractice0(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawViewPractice0(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(dp2px(1));
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setStrokeWidth(dp2px(1));
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(sp2px(14f));
        textPaint.setAntiAlias(true);

        path = new Path();
        dash = new Path();
        dash.addRect(0, 0, DASH_WIDTH, DASH_LENGTH, Path.Direction.CCW);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        path.reset();
        path.moveTo(match, getHeight() / 2 + DASH_LENGTH);
        path.lineTo(getWidth() - match, getHeight() / 2 + DASH_LENGTH);
        pathMeasure = new PathMeasure();
        pathMeasure.setPath(path, false);
        pathEffect = new PathDashPathEffect(dash, ((pathMeasure.getLength() - DASH_WIDTH) / 10f), 0f, PathDashPathEffect.Style.ROTATE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
        path.reset();
        path.moveTo(match, getHeight() / 2);
        path.lineTo(getWidth() - match, getHeight() / 2);
        paint.setPathEffect(pathEffect);
        canvas.drawPath(path, paint);
        paint.setPathEffect(null);
        paint.setStrokeWidth(dp2px(1));
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(dp2px(14f));

        canvas.drawText("cm", pathMeasure.getLength() + dp2px(10f), getHeight() / 2 - dp2px(10f), textPaint);
        for (int i = 0; i < 11; i++) {
            textWidth = paint.measureText(i + "");
            float cx = ((pathMeasure.getLength() - DASH_WIDTH) / 10f) * i + (match - 5);
            if (i == index) {
                textPaint.setTextSize(sp2px(16f));
                textPaint.setColor(Color.BLUE);
                canvas.drawCircle(cx + dp2px(2f), getHeight() / 2 + DASH_LENGTH, radius, textPaint);
            } else {
                textPaint.setTextSize(sp2px(14f));
                textPaint.setColor(Color.BLACK);
            }
            canvas.drawText(String.valueOf(i), cx, getHeight() / 2 + dp2px(25f), textPaint);
        }
    }


    private float dp2px(float values) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, values, getResources().getDisplayMetrics());
    }

    private float sp2px(float values) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, values, getResources().getDisplayMetrics());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_DOWN:
                //获取屏幕上点击的坐标
                float x = event.getX();
                float y = event.getY();
                //如果坐标在我们的文字区域内，则将点击的文字改颜色
                if (y > height - 2 * textWidth) {
                    //点击后，获取坐标代表的单词的含义
                    index = (int) (x / (width / 11));
                    //此处有增加，当屏幕被点击后，将参数传入。
                    if (listener != null) {
                        listener.onItemSelect(index);
                    }
                    invalidate();//更新视图
                    return true;
                }

                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    public void setListener(OnItemSelectListener listener) {
        this.listener = listener;
    }

    //定义一个接口
    public interface OnItemSelectListener {
        public void onItemSelect(int index);
    }
}
