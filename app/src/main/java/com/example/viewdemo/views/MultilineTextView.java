package com.example.viewdemo.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.viewdemo.Constants;
import com.example.viewdemo.R;

public class MultilineTextView extends View {
    private Paint paint;
    private String text = "Xfermode is called transition mode in foreign countries. This kind of translation is more appropriate, but I'm afraid it is not easy to understand. You can also directly call it image blending mode, because the so-called transition is actually a kind of image blending, which is quite similar to the setcolorfilter we mentioned above. Looking at the API document, we found that there are three subclasses: avoidxfermode, pixelxorxfermode and porterduffxfermode. The functions of these three subclasses are much more complex than those of setcolorfilter. " +
            "Due to avoidxfermode, Pixelxorxfermode has been marked as obsolete, so this time we mainly study the porterduffxfermode which is still in use: this class also has and only one constructor with a parameter, porterduffxfermode（ PorterDuff.Mode Mode), although there is only one signature list in the constructor PorterDuff.Mode But it can achieve a lot of cool graphics effects!! The concept of Porter duffxfermode is the meaning of graphic blending mode. The concept of Porter duffxfermode comes from Tomas of siggraph" +
            "Proter and Tom Duff, the concept of mixed graphics has greatly promoted the development of graphics and imaging, and extended to computer graphics and imaging. Many famous design software of adobe and Autodesk companies can be said to be affected to a certain extent. The name of our porterduffxfermode also comes from the combination of their names, porterduff. What can porterduffxfermode do?";

    private TextPaint textPaint;
    private Paint.FontMetrics fontMetrics;
    private int IMAGE_WIDTh = (int) Constants.dp2px(200);
    private int IMAGE_PADDING = (int) Constants.dp2px(50);


    public MultilineTextView(Context context) {
        this(context, null);
    }

    public MultilineTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultilineTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(Constants.dp2px(14f));

        paint = new Paint();
        paint.setTextSize(Constants.dp2px(14f));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        fontMetrics = new Paint.FontMetrics();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制多行文字
//        StaticLayout staticLayout=new StaticLayout(text,textPaint,getWidth(), Layout.Alignment.ALIGN_NORMAL,1f,0f,false);
//        staticLayout.draw(canvas);


        canvas.drawBitmap(getAvatar(IMAGE_WIDTh), getWidth() - IMAGE_WIDTh, IMAGE_PADDING, paint);
        paint.getFontMetrics(fontMetrics);
        float[] measureWidth = new float[0];
        //图文混排
        int count;
        int start = 0;
        int verticalOffset = (int) -fontMetrics.top;
        float maxWidth;
        while (start < text.length()) {
            if ((verticalOffset + fontMetrics.bottom < IMAGE_PADDING) || (verticalOffset + fontMetrics.top > IMAGE_PADDING + IMAGE_WIDTh)) {
                maxWidth = getWidth();
            } else {
                maxWidth = getWidth() - IMAGE_WIDTh;
            }
            count = paint.breakText(text, start, text.length(), true, maxWidth, measureWidth);
            canvas.drawText(text, start, count + start, 0f, verticalOffset, paint);
            start += count;
            verticalOffset += paint.getFontSpacing();
        }

    }

    private Bitmap getAvatar(int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.c2, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;
        return BitmapFactory.decodeResource(getResources(), R.mipmap.c2, options);
    }
}
