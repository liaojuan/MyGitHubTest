package com.lc.liao.mygithub.dataprovider.api.image.base;

import com.lc.liao.mygithub.dataprovider.api.image.glideimpl.GlideImageApi;

/**
 * Created by liao on 2017/3/10.
 */

public class ImageApiFactory {
    public static ImageApi createImageApi(){
        return GlideImageApi.getInstall();
    }
}
