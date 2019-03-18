package org.alie.paintgradientwork.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import org.alie.paintgradientwork.R;


/**
 * Created by Alie on 2019/3/17.
 * 类描述 位图渲染
 * 版本
 */
public class BitmapGradientView extends View {
    private static final String TAG = "BitmapGradientView2";
    private Paint mPaint;
    private Bitmap mBitmap;
    private int mWidth;
    private int mHeight;
    private int[] mColors = {Color.RED,Color.YELLOW,Color.BLUE,Color.GREEN};

    public BitmapGradientView(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.xyjy2);
        mWidth = mBitmap.getWidth();
        mHeight = mBitmap.getHeight();
    }

    public BitmapGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.xyjy2);
        mWidth = mBitmap.getWidth();
        mHeight = mBitmap.getHeight();
    }

    public BitmapGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.xyjy2);
        mWidth = mBitmap.getWidth();
        mHeight = mBitmap.getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG, "width:" + mWidth + " height:" + mHeight);
        BitmapShader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.MIRROR);
        mPaint.setShader(bitmapShader);
        canvas.drawRect(10, 10, mWidth + 10, mHeight * 2+10,mPaint);

    }
}
