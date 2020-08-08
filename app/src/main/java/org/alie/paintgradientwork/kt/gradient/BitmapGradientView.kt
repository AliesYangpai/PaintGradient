package org.alie.paintgradientwork.kt.gradient

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import org.alie.paintgradientwork.R

/**
 * Created by Administrator on 2020/8/8 0008.
 * 类描述 位图渲染的view
 * 版本
 */
class BitmapGradientView(context: Context, attributeSet: AttributeSet?, defStyle: Int) :
    View(context, attributeSet, defStyle) {
    var mBitmap: Bitmap? = null
    var mPaint: Paint? = null
    var mWidth = 0
    var mHeight = 0
    var bitmapShader: BitmapShader? = null

    init {
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.xyjy2)
        mWidth = mBitmap!!.width
        mHeight = mBitmap!!.height
        mPaint = Paint()
        // 关键代码，创建位图着色器，传入目标bitmap和多出bitmap宽高部分的拉伸模式
        bitmapShader = BitmapShader(mBitmap!!, Shader.TileMode.CLAMP, Shader.TileMode.MIRROR)
        mPaint?.let {
            it.isAntiAlias = true
            it.shader = bitmapShader
        }
    }

    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context) : this(context, null, 0)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawRect(
            10F, 10F, (mWidth + 10).toFloat(), (mHeight + 10 + mHeight).toFloat(),
            mPaint!!
        )
    }
}