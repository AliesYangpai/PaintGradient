package org.alie.paintgradientwork.kt.gradient

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * Created by Administrator on 2020/8/8 0008.
 * 类描述  环形渲染的view
 * 版本
 */
class RadialGradientView(context: Context, attributeSet: AttributeSet?, defStyle: Int) :
    View(context, attributeSet, defStyle) {
    var mPaint: Paint? = null
    var radialGradient: RadialGradient? = null
    var mColors = intArrayOf(Color.RED, Color.YELLOW)

    init {
        mPaint = Paint()
        mPaint?.isAntiAlias = true
        radialGradient =
            RadialGradient(200F + 10F, 200F + 10F, 150F, mColors, null, Shader.TileMode.CLAMP)
        mPaint?.let {
            it.isAntiAlias = true
            it.shader = radialGradient
        }

    }

    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context) : this(context, null, 0)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(200F + 10F, 200F + 10F, 150F, mPaint!!)
    }
}