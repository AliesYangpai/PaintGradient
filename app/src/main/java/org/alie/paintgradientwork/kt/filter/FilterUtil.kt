package org.alie.paintgradientwork.kt.filter

import android.graphics.ColorMatrix

/**
 * Created by Administrator on 2020/8/11 0011.
 * 类描述
 * 版本
 */
object FilterUtil {
    /**
     * 底片效果
     * @return
     */
    fun getPhotographicPlate(): ColorMatrix {
        return ColorMatrix(
            floatArrayOf(
                -1F, 0F, 0F, 0F, 255F,
                0F, -1F, 0F, 0F, 255F,
                0F, 0F, -1F, 0F, 255F,
                0F, 0F, 0F, 1F, 0F
            )
        )
    }

    /**
     * 颜色增强
     * @return
     */
    fun getColorEnhance(): ColorMatrix {
        return ColorMatrix(
            floatArrayOf(
                1.2f,
                0f,
                0f,
                0f,
                0f,
                0f,
                1.2f,
                0f,
                0f,
                0f,
                0f,
                0f,
                1.2f,
                0f,
                0f,
                0f,
                0f,
                0f,
                1.2f,
                0f
            )
        )
    }

    /**
     * 黑白照片
     * @return
     */
    fun getBlackPicture(): ColorMatrix {
        return ColorMatrix(
            floatArrayOf(
                0.213f, 0.715f, 0.072f, 0f, 0f,
                0.213f, 0.715f, 0.072f, 0f, 0f,
                0.213f, 0.715f, 0.072f, 0f, 0f, 0f, 0f, 0f, 1f, 0f
            )
        )
    }

    /**
     * 发色效果
     * @return
     */
    fun getGaveColor(): ColorMatrix {
        return ColorMatrix(
            floatArrayOf(
                1f,
                0f,
                0f,
                0f,
                0f,
                0f,
                0f,
                1f,
                0f,
                0f,
                0f,
                1f,
                0f,
                0f,
                0f,
                0f,
                0f,
                0f,
                0.5f,
                0f
            )
        )
    }

    /**
     * 复古效果
     */
    fun getOldSchool(): ColorMatrix {
        return ColorMatrix(
            floatArrayOf(
                1 / 2f, 1 / 2f, 1 / 2f, 0f, 0f,
                1 / 3f, 1 / 3f, 1 / 3f, 0f, 0f,
                1 / 4f, 1 / 4f, 1 / 4f, 0f, 0f, 0f, 0f, 0f, 1f, 0f
            )
        )
    }
}