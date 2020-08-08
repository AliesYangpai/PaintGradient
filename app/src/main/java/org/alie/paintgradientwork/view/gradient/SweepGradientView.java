package org.alie.paintgradientwork.view.gradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by Alie on 2019/3/18.
 * 类描述
 * 版本
 */
public class SweepGradientView extends View {
    private Paint mPaint;
    private int[] mColors = {Color.RED,Color.YELLOW,Color.BLUE,Color.GREEN};

    public SweepGradientView(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    public SweepGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    public SweepGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        SweepGradient sweepGradient = new SweepGradient(getWidth()/2,getHeight()/2,mColors,null);
        mPaint.setShader(sweepGradient);
        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2,mPaint);
    }
}
