package com.lc.liao.mygithub.dataprovider.api.image.glideimpl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.lc.liao.mygithub.dataprovider.api.image.base.ImageApi;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by liao on 2017/3/10.
 */

public class GlideImageApi implements ImageApi{
    private static GlideImageApi glideImageApi;

    public static GlideImageApi getInstall(){
        if(glideImageApi == null)
            glideImageApi = new GlideImageApi();
        return  glideImageApi;
    }

    /**
     * 便捷加载图片
     *
     * @param context
     * @param imageView
     * @param imageUrl
     */
    @Override
    public void loadImage(Context context, ImageView imageView, String imageUrl) {
        Glide.with(context).load(imageUrl).into(imageView);
    }

    /**
     * 加载图片并让他带圆弧
     *
     * @param context
     * @param imageView
     * @param imageUrl
     * @param radius
     * @param margin
     */
    @Override
    public void loadImage(Context context, ImageView imageView, String imageUrl, int radius, int margin) {
        Glide.with(context).load(imageUrl).bitmapTransform(new RoundedCornersTransformation(context, radius, margin)).into(imageView);
    }

    @Override
    public void loadImage(Context context, ImageView imageView, String imageUrl, Drawable error, int radius, int margin) {
        Glide.with(context).load(imageUrl).error(error).bitmapTransform(new RoundedCornersTransformation(context, radius, margin)).into(imageView);
    }

    @Override
    public void loadImage(Context context, ImageView imageView, String imageUrl, Drawable placeholder, Drawable error) {
        Glide.with(context).load(imageUrl).placeholder(placeholder).error(error).into(imageView);
    }


    /**
     * 获取bitmap
     *
     * @param context
     * @param url
     * @param simpleTarget
     */
    @Override
    public void loadBitmap(Context context, String url, SimpleTarget<Bitmap> simpleTarget) {
        Glide.with(context).load(url).asBitmap().into(simpleTarget);
    }
}
