package org.alie.paintgradientwork.kt.filter

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import org.alie.paintgradientwork.R

/**
 * Created by Administrator on 2020/8/11 0011.
 * 类描述  这是滤镜的view主要为了实现图片的滤镜效果（Paint高级特性2）
 * 版本
 */
class FilterView(context: Context, attributeSet: AttributeSet?, defStyle: Int) :
    View(context, attributeSet, defStyle) {

    var mPaint: Paint? = null
    var mBitmap: Bitmap? = null

    init {
        mPaint = Paint()
        mPaint?.isAntiAlias = true
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.blanni)

    }

    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context) : this(context, null, 0)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val rectRaw = Rect(10, 10, mBitmap!!.width + 10, mBitmap!!.height + 10)
        canvas?.drawBitmap(mBitmap!!, null, rectRaw, null)

        val rectTarget =
            Rect(
                10,
                10 + mBitmap!!.height + 10,
                10 + mBitmap!!.width,
                10 + mBitmap!!.height + 10 + mBitmap!!.height
            )

        mPaint?.colorFilter = ColorMatrixColorFilter(FilterUtil.getOldSchool())
        canvas?.drawBitmap(mBitmap!!, null, rectTarget, mPaint)

    }
}