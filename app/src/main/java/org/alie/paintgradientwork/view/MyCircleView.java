package org.alie.paintgradientwork.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by Alie on 2020/2/28.
 * 类描述
 * 版本
 */
public class MyCircleView extends View {

    private Paint mPaintText;
    private Paint mPaintCircle;
    private static final String TEXT = "西瓜";

    public MyCircleView(Context context) {
        super(context);
        mPaintText = new Paint();
        mPaintText.setColor(Color.RED);
        mPaintText.setStrokeWidth(3);
        mPaintCircle = new Paint();
        mPaintCircle.setColor(Color.GREEN);
        mPaintCircle.setStyle(Paint.Style.FILL);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaintText = new Paint();
        mPaintText.setColor(Color.RED);
        mPaintText.setStrokeWidth(3);
        mPaintCircle = new Paint();
        mPaintCircle.setColor(Color.GREEN);
        mPaintCircle.setStyle(Paint.Style.FILL);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaintText = new Paint();
        mPaintText.setColor(Color.RED);
        mPaintText.setStrokeWidth(3);
        mPaintCircle = new Paint();
        mPaintCircle.setColor(Color.GREEN);
        mPaintCircle.setStyle(Paint.Style.FILL);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(60, 60, 30, mPaintCircle);
        float textValue = mPaintText.measureText(TEXT);
        mPaintText.setTextSize(20);
        float x = 60 - textValue / 2;
        Paint.FontMetrics fontMetrics = mPaintText.getFontMetrics();
        // 得到文本字体的总高度
        float fontSize = Math.abs(fontMetrics.ascent) + fontMetrics.descent;
        // 得到文本中心点的长度
        float fontMidle = fontSize / 2;
        // 得到绘制基点到文本中心点的长度
        float s = Math.abs(fontMetrics.ascent) - fontMidle;
        // 相加后得到最终 的基准点坐标
        float y = 60 + s;
        Log.i("MyCircleView", "fontMetrics.ascent:" + fontMetrics.ascent + " fontMetrics.descent:" + fontMetrics.descent);
        canvas.drawText(TEXT, x, y, mPaintText);
    }
}
