package com.example.viewdemo.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.viewdemo.Constants;
import com.example.viewdemo.R;

public class XfermodeView extends View {
    private Paint paint;
    private int IMAGE_WIDTH= (int) Constants.dp2px(200f);
    private float IMAGE_PADDING=  Constants.dp2px(20f);
    private RectF bounds;
    private Xfermode xfermode=new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);

    public XfermodeView(Context context) {
        this(context, null);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        bounds=new RectF(IMAGE_PADDING,IMAGE_PADDING,IMAGE_PADDING+IMAGE_WIDTH,IMAGE_WIDTH+IMAGE_PADDING);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);
        //把绘制区域拉倒单独离屏缓冲里
        int count = canvas.saveLayer(bounds, null);
        canvas.drawOval(IMAGE_PADDING,IMAGE_PADDING,IMAGE_PADDING+IMAGE_WIDTH,IMAGE_WIDTH+IMAGE_PADDING,paint);
        paint.setXfermode(xfermode);
        canvas.drawBitmap(getAvatar(IMAGE_WIDTH), IMAGE_PADDING, IMAGE_PADDING, paint);
        paint.setXfermode(null);
        //把离屏缓冲区域合成后的图片放回绘制区域
        canvas.restoreToCount(count);

    }

    private Bitmap getAvatar(int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.app_logo2, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;

        return BitmapFactory.decodeResource(getResources(), R.mipmap.app_logo2, options);
    }

}
