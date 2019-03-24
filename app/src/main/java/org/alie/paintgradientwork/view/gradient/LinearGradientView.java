package org.alie.paintgradientwork.view.gradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Alie on 2019/3/18.
 * 类描述
 * 版本
 */
public class LinearGradientView extends View {
    private Paint mPaint;
    private int[] mColors = {Color.RED,Color.YELLOW,Color.BLUE,Color.GREEN};
    public LinearGradientView(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LinearGradient linearGradient = new LinearGradient(0,0,getWidth(),0,mColors,null,Shader.TileMode.CLAMP);
        mPaint.setShader(linearGradient);
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);
    }
}
