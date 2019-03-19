package org.alie.paintgradientwork.targetview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Alie on 2019/3/19.
 * 类描述
 * 版本
 */
public class RadarView extends View {

    private int mWidth;
    private int mHeight;
    private Paint mCirclePaint;
    private Paint mSweepPaint;


    //五个圆
    private float[] pots = {0.05f, 0.1f, 0.15f, 0.2f, 0.25f};
    private SweepGradient sweepGradient;
    private int[] sweepColorArry = {Color.TRANSPARENT, Color.GRAY};
    private Matrix matrix = new Matrix();
    private int scanSpeed = 5; // 扫描速度

    public RadarView(Context context) {
        super(context);
        mCirclePaint = new Paint(); // 画5个圆需要用到的画笔
        mCirclePaint.setStyle(Paint.Style.STROKE); // 描边
        mCirclePaint.setStrokeWidth(1);
        mCirclePaint.setAlpha(100); // 透明度
        mCirclePaint.setAntiAlias(true); // 设置抗锯齿
        mCirclePaint.setColor(Color.GRAY);

        mSweepPaint = new Paint(); // 扫描用的paint
        mSweepPaint.setStyle(Paint.Style.FILL_AND_STROKE); // 设置样式填充
        mSweepPaint.setAntiAlias(true); // 设置抗锯齿
        post(runnable);
    }

    public RadarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mCirclePaint = new Paint(); // 画5个圆需要用到的画笔
        mCirclePaint.setStyle(Paint.Style.STROKE); // 描边
        mCirclePaint.setStrokeWidth(1);
        mCirclePaint.setAlpha(100); // 透明度
        mCirclePaint.setAntiAlias(true); // 设置抗锯齿
        mCirclePaint.setColor(Color.GRAY);

        mSweepPaint = new Paint(); // 扫描用的paint
        mSweepPaint.setStyle(Paint.Style.FILL_AND_STROKE); // 设置样式填充
        mSweepPaint.setAntiAlias(true); // 设置抗锯齿
        /**
         * 将runnable加入到消息队列，这个runnable将会在主线程上运行
         */
        post(runnable);
    }

    public RadarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mCirclePaint = new Paint(); // 画5个圆需要用到的画笔
        mCirclePaint.setStyle(Paint.Style.STROKE); // 描边
        mCirclePaint.setStrokeWidth(1);
        mCirclePaint.setAlpha(100); // 透明度
        mCirclePaint.setAntiAlias(true); // 设置抗锯齿
        mCirclePaint.setColor(Color.GRAY);

        mSweepPaint = new Paint(); // 扫描用的paint
        mSweepPaint.setStyle(Paint.Style.FILL_AND_STROKE); // 设置样式填充
        mSweepPaint.setAntiAlias(true); // 设置抗锯齿
        post(runnable);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = this.getMeasuredWidth();
        mHeight = this.getMeasuredHeight();
        mWidth = Math.max(mWidth, mHeight);
        mHeight = mWidth;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (float pot : pots) {
            canvas.drawCircle(mWidth / 2, mHeight / 2, mWidth * pot, mCirclePaint);
        }

        /**
         * save：用来保存Canvas的状态。save之后，可以调用Canvas的平移、放缩、旋转、错切、裁剪等操作。
         * restore：用来恢复Canvas之前保存的状态。防止save后对Canvas执行的操作对后续的绘制有影响。
         */
        canvas.save();
        sweepGradient = new SweepGradient(mWidth / 2, mHeight / 2, sweepColorArry, null);
        mSweepPaint.setShader(sweepGradient);
        /**
         * Canvas.setMatrix(matrix)：用 Matrix 直接替换 Canvas 当前的变换矩阵，
         * 即抛弃 Canvas 当前的变换，改用 Matrix 的变换
         *
         * Canvas.concat(matrix)：用 Canvas 当前的变换矩阵和 Matrix 相乘，
         * 即基于 Canvas 当前的变换，叠加上 Matrix 中的变换。
         * ---------------------
         */
        canvas.concat(matrix);
        canvas.drawCircle(mWidth / 2, mHeight / 2, pots[4] * mWidth, mSweepPaint);
        canvas.restore();
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            /**
             * postRotate (float degrees, float px, float py)
             * degrees : 旋转角度
             * px：围绕圆心x
             * px：围绕圆心y
             */
            matrix.postRotate(scanSpeed,mWidth/2,mHeight/2);

            invalidate(); // 通知view重绘 只能在UI线程中调用
            postDelayed(runnable, 50); // 调用自身 重复绘制
        }
    };
}
