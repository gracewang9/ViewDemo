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

public class XfermodeView2 extends View {
    private Paint paint = new Paint();
    private int Bitmap_WIDTH = (int) Constants.dp2px(150f);
    private RectF bounds = new RectF(Bitmap_WIDTH, Constants.dp2px(50f), Constants.dp2px(300f), Constants.dp2px(200f));
    private Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.XOR);
    private Context context;

    private Bitmap circleBitmap = Bitmap.createBitmap(Bitmap_WIDTH, Bitmap_WIDTH, Bitmap.Config.ARGB_8888);
    private Bitmap squareBitmap = Bitmap.createBitmap(Bitmap_WIDTH, Bitmap_WIDTH, Bitmap.Config.ARGB_8888);

    public XfermodeView2(Context context) {
        this(context, null);
    }

    public XfermodeView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XfermodeView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        Canvas canvas = new Canvas(circleBitmap);
        paint.setColor(Color.parseColor("#D81B60"));
        canvas.drawOval(Constants.dp2px(50f), Constants.dp2px(0f), Constants.dp2px(150f), Constants.dp2px(100f), paint);
        paint.setColor(Color.parseColor("#2196F3"));
        canvas.setBitmap(squareBitmap);
        canvas.drawRect(Constants.dp2px(0f), Constants.dp2px(50f), Constants.dp2px(100f), Constants.dp2px(150f), paint);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int count = canvas.saveLayer(bounds, null);
        canvas.drawBitmap(circleBitmap, Constants.dp2px(150f), Constants.dp2px(50f), paint);
        paint.setXfermode(xfermode);
        canvas.drawBitmap(squareBitmap, Constants.dp2px(150f), Constants.dp2px(50f), paint);
        paint.setXfermode(null);
        canvas.restoreToCount(count);

    }

}
