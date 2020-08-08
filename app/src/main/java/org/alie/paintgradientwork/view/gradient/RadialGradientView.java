package org.alie.paintgradientwork.view.gradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by Alie on 2019/3/17.
 * 类描述  环形渲染
 * 版本
 */
public class RadialGradientView extends View {
    private static final String TAG = "RadialGradientView";
    private Paint mPaint;
    private int[] mColors = {Color.RED,Color.YELLOW,Color.BLUE,Color.GREEN};

    public RadialGradientView(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    public RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    public RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG, "onDraw: ==================");
        RadialGradient radialGradient = new RadialGradient(getWidth() / 2, getHeight() / 2,
                getWidth() / 2, mColors,null,Shader.TileMode.CLAMP);
        mPaint.setShader(radialGradient);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2,getWidth() / 2,mPaint);

    }
}
