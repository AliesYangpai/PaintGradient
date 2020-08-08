package org.alie.paintgradientwork.kt.gradient

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * Created by Administrator on 2020/8/8 0008.
 * 类描述 线性渲染的view
 * 版本
 */
class LinearGradientView(context: Context, attributeSet: AttributeSet?, defStyle: Int) :
    View(context, attributeSet, defStyle) {

    var mPaint: Paint? = null
    var mLinearShader: LinearGradient? = null
    var mColors = intArrayOf(
        Color.RED,
        Color.YELLOW,
        Color.BLUE,
        Color.GREEN
    )

    var lgStartX = 10F
    var lgStartY = 10F
    var lgEndX = 900F
    var lgEndY = 20F

    init {
        mPaint = Paint();
        mLinearShader =
            LinearGradient(lgStartX, lgStartY, lgEndX, lgEndY, mColors, null, Shader.TileMode.CLAMP)
        mPaint?.let {
            it.isAntiAlias = true
            it.shader = mLinearShader
        }
    }

    constructor(context: Context, attributeSet: AttributeSet) : this(context, attributeSet, 0)
    constructor(context: Context) : this(context, null, 0)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 这里的+10为的是显示多出货色器的部分的拉伸效果，由于这里是颜色，非图像，因此实际上几乎看不出来效果
        // 但是这部分知识点要注意
        canvas?.drawRect(lgStartX + 10, lgStartY + 10, lgEndX + 10, lgEndY + 10, mPaint!!)
    }
}
