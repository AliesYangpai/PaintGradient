package org.alie.paintgradientwork.view.gradient;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import org.alie.paintgradientwork.R;

/**
 * Created by Alie on 2019/3/23.
 * 类描述 组合view
 * 版本
 */
public class ComposeGadientView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;
    private int[] colors = {Color.GRAY, Color.YELLOW};

    public ComposeGadientView(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.heart);
    }

    public ComposeGadientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.heart);
    }

    public ComposeGadientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.heart);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        BitmapShader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        LinearGradient linearGradient = new LinearGradient(0, 0, mBitmap.getWidth(), mBitmap.getHeight(), colors
                , null, Shader.TileMode.CLAMP);
        ComposeShader composeShader = new ComposeShader(bitmapShader, linearGradient, PorterDuff.Mode.MULTIPLY);
        mPaint.setShader(composeShader);
        canvas.drawRect(0,0,mBitmap.getWidth(),mBitmap.getHeight(),mPaint);
    }
}
