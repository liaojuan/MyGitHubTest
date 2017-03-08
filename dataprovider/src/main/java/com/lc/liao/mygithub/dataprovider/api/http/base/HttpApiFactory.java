package com.lc.liao.mygithub.dataprovider.api.http.base;

import android.content.Context;

import com.lc.liao.mygithub.dataprovider.api.http.retrofitimpl.RetrofitApi;

/**
 * Created by liao on 2017/3/8.
 * httpApi工厂类
 */

public final class HttpApiFactory {

    public static HttpApi createHttpApi(Context context) {
        return RetrofitApi.getInstall(context);
    }
}
