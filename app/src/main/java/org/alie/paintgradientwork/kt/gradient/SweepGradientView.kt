package org.alie.paintgradientwork.kt.gradient

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.SweepGradient
import android.util.AttributeSet
import android.view.View

/**
 * Created by Administrator on 2020/8/9 0009.
 * 类描述
 * 版本
 */
class SweepGradientView(context: Context, attributeSet: AttributeSet?, defStyle: Int) :
    View(context, attributeSet, defStyle) {

    var mPaint: Paint? = null
    var sweepGradient: SweepGradient? = null
    var mColors = intArrayOf(Color.GREEN, Color.TRANSPARENT)

    init {
        sweepGradient = SweepGradient(150F, 150F, mColors, null)
        mPaint = Paint()
        mPaint?.let {
            it.isAntiAlias = true
            it.shader = sweepGradient
        }
    }

    constructor(context: Context, attributeSet: AttributeSet) : this(context, attributeSet, 0)
    constructor(context: Context) : this(context, null, 0)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(150F, 150F, 150F / 2, mPaint!!)
    }
}