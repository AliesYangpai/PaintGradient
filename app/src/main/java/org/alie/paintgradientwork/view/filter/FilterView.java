package org.alie.paintgradientwork.view.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import org.alie.paintgradientwork.R;
import org.alie.paintgradientwork.util.FilterUtil;

import java.io.File;

/**
 * Created by Alie on 2019/3/24.
 * 类描述
 * 版本
 */
public class FilterView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;
    private Paint mPaintRaw;
    private ColorMatrix colorMatrix;

    public FilterView(Context context) {
        super(context);

        mPaintRaw = new Paint();
        mPaintRaw.setAntiAlias(true);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.xyjy2);
    }

    public FilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mPaintRaw = new Paint();
        mPaintRaw.setAntiAlias(true);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.xyjy2);
    }

    public FilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaintRaw = new Paint();
        mPaintRaw.setAntiAlias(true);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.xyjy2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        RectF rectF = new RectF(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
        canvas.drawBitmap(mBitmap, null, rectF, mPaintRaw);
        canvas.save();

//        colorMatrix = FilterUtil.getPhotographicPlate(); // 底片效果
//        colorMatrix = FilterUtil.getColorEnhance(); // 色彩增强 （美颜）
//        colorMatrix = FilterUtil.getBlackPicture(); // 黑白效果
//        colorMatrix = FilterUtil.getGaveColor(); // 发色效果
        colorMatrix = FilterUtil.getOldSchool(); // 复古效果
        RectF rectTarget = new RectF(0, mBitmap.getHeight() + 10, mBitmap.getWidth(), mBitmap.getHeight() * 2 + 10);
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.restore();
        canvas.drawBitmap(mBitmap, null, rectTarget, mPaint);
    }


}
