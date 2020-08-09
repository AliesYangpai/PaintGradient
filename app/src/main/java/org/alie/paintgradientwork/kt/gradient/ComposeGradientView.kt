package org.alie.paintgradientwork.kt.gradient

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import org.alie.paintgradientwork.R

/**
 * Created by Administrator on 2020/8/9 0009.
 * 类描述
 * 版本
 */
class ComposeGradientView(context: Context, attributeSet: AttributeSet?, defStyle: Int) :
    View(context, attributeSet, defStyle) {
    var mPaint: Paint? = null
    var mBitmapShader: BitmapShader? = null
    var mBitmap: Bitmap? = null
    var mWidth = 0
    var mHeight = 0
    var mLinearGradient: LinearGradient? = null
    val mColors = intArrayOf(Color.GRAY, Color.YELLOW,Color.RED)
    var mComposeShader: ComposeShader? = null

    init {
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.heart)
        mWidth = mBitmap?.width!!
        mHeight = mBitmap?.height!!
        mBitmapShader = BitmapShader(mBitmap!!, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        mLinearGradient =
            LinearGradient(
                0F,
                0F,
                mWidth.toFloat(),
                mHeight.toFloat(),
                mColors,
                null,
                Shader.TileMode.CLAMP
            )
        mComposeShader = ComposeShader(mBitmapShader!!, mLinearGradient!!, PorterDuff.Mode.MULTIPLY)
        mPaint = Paint()
        mPaint?.let {
            it.isAntiAlias = true
            it.shader = mComposeShader
        }

    }

    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context) : this(context, null, 0)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawRect(0F, 0F, mWidth.toFloat(), mHeight.toFloat(), mPaint!!)
    }
}