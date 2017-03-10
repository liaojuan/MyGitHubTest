package com.lc.liao.mygithub.dataprovider.api.image.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.request.target.SimpleTarget;

/**
 * Created by liao on 2017/3/10.
 *
 * 对于图片的处理
 */

public interface ImageApi {

    /**
     * 便捷加载图片
     *
     * @param context
     * @param imageView
     * @param imageUrl
     */
    void loadImage(Context context, ImageView imageView, String imageUrl);

    /**
     * 加载图片并让他带圆弧
     *
     * @param context
     * @param imageView
     * @param imageUrl
     * @param radius
     * @param margin
     */
    void loadImage(Context context, ImageView imageView, String imageUrl, int radius, int margin);

    /**
     * @param context
     * @param imageView
     * @param imageUrl
     * @param radius
     * @param margin
     */
    void loadImage(Context context, ImageView imageView, String imageUrl, Drawable error, int radius, int margin);

    /**
     * @param context
     * @param imageView
     * @param imageUrl
     * @param placeholder
     * @param error
     */
    void loadImage(Context context, ImageView imageView, String imageUrl, Drawable placeholder, Drawable error);

    /**
     * 获取bitmap
     *
     * @param context
     * @param url
     * @param simpleTarget
     */
    void loadBitmap(Context context, String url, SimpleTarget<Bitmap> simpleTarget);
}
