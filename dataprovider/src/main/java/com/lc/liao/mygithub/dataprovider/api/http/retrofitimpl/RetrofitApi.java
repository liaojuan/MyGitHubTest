package com.lc.liao.mygithub.dataprovider.api.http.retrofitimpl;

import android.content.Context;

import com.lc.liao.mygithub.dataprovider.api.http.base.HttpApi;

import retrofit2.Retrofit;

/**
 * Created by liao on 2017/3/8.
 */

public class RetrofitApi implements HttpApi{
    private Retrofit retroApi;
    private static RetrofitApi retrofitApi;

    public static RetrofitApi getInstall(Context context){
        if(retrofitApi == null)
            retrofitApi = new RetrofitApi();
        retrofitApi.initRetrofit(context);
        return  retrofitApi;
    }

    private void initRetrofit(Context context){

    }

    @Override
    public void login() {

    }
}
