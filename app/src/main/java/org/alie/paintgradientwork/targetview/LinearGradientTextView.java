package org.alie.paintgradientwork.targetview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * Created by Alie on 2019/3/20.
 * 类描述 这个是霓虹灯文字控件
 * 版本
 */
public class LinearGradientTextView extends AppCompatTextView {

    private TextPaint mTextPaint;
    private LinearGradient mLinearGradient;
    private int[] colors = {0x22ffffff, 0xffffffff, 0x22ffffff};
    private Matrix mMatrix;
    private float mTranslate;
    private float DELTAX = 20;

    public LinearGradientTextView(Context context) {
        super(context);
    }

    public LinearGradientTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearGradientTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // 获取textView中的画笔
        mTextPaint = this.getPaint();
        String text = this.getText().toString();
        // 使用画笔测量textView的宽度
        float textWidth = mTextPaint.measureText(text);
        // 得到3个文字的宽度
        int gradientSize = (int) ((textWidth / text.length()) * 3);
        // 从左边-gradientSize开始，即左边距离文字gradientSize开始渐变
        mLinearGradient = new LinearGradient(-gradientSize,
                0, 0, 0, colors, null, Shader.TileMode.CLAMP);
        mTextPaint.setShader(mLinearGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mTranslate += DELTAX;
        float textWidth = getPaint().measureText(getText().toString());

        // 这个逻辑判断是为了让坐标左右来回移动
        if(mTranslate > textWidth+1 || mTranslate <1){
            DELTAX = -DELTAX;
        }
        mMatrix = new Matrix();
        mMatrix.setTranslate(mTranslate,0); // 平移
        mLinearGradient.setLocalMatrix(mMatrix);
        postInvalidateDelayed(50);
    }
}
