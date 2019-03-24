package org.alie.paintgradientwork.util;

import android.graphics.ColorMatrix;

/**
 * Created by Alie on 2019/3/24.
 * 类描述 滤镜的矩阵工具类
 * 版本
 */
public final class FilterUtil {

    /**
     * 底片效果
     * @return
     */
    public static final ColorMatrix getPhotographicPlate() {
        // 反相效果 -- 底片效果
       ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                -1, 0,0,0,255,
                0,-1,0,0,255,
                0,0,-1,0,255,
                0,0,0,1,0,
        });
       return colorMartrix;
    }

    /**
     * 颜色增强
     * @return
     */
    public static final ColorMatrix getColorEnhance() {
        ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                1.2f, 0,0,0,0,
                0,1.2f,0,0,0,
                0,0,1.2f,0,0,
                0,0,0,1.2f,0,
        });
        return colorMartrix;
    }

    /**
     * 黑白照片
     * @return
     */
    public static final ColorMatrix getBlackPicture() {
     ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                0.213f, 0.715f,0.072f,0,0,
                0.213f, 0.715f,0.072f,0,0,
                0.213f, 0.715f,0.072f,0,0,
                0,0,0,1,0,
        });
        return colorMartrix;
    }

    /**
     * 发色效果
     * @return
     */
    public static final ColorMatrix getGaveColor() {
        ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                1,0,0,0,0,
                0, 0,1,0,0,
                0,1,0,0,0,
                0,0,0,0.5F,0,
        });
        return colorMartrix;
    }

    /**
     * 复古效果
     */
    public static final ColorMatrix getOldSchool() {
        ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                1/2f,1/2f,1/2f,0,0,
                1/3f, 1/3f,1/3f,0,0,
                1/4f,1/4f,1/4f,0,0,
                0,0,0,1,0,
        });
        return colorMartrix;
    }

}

