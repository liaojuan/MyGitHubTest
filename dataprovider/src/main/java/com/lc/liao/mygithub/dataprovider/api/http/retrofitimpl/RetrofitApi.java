package com.lc.liao.mygithub.dataprovider.api.http.retrofitimpl;

import android.content.Context;
import android.util.Log;

import com.lc.liao.mygithub.dataprovider.api.http.Contact;
import com.lc.liao.mygithub.dataprovider.api.http.base.HttpApi;
import com.lc.liao.mygithub.dataprovider.api.preference.SharePreferenceApi;
import com.lc.liao.mygithub.dataprovider.api.preference.SharePreferenceContact;
import com.lc.liao.mygithub.dataprovider.api.util.APPUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
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
        String accessToken = SharePreferenceApi.getInstall(context).getString(SharePreferenceContact.ACCESS_TOKEN, "");
        String appVersion = APPUtil.getAppVersion(context);
        retroApi = new Retrofit.Builder().baseUrl(Contact.apiUrl).addConverterFactory(GsonConverterFactory.create()).client(genericClient(accessToken, appVersion)).build();
    }

    /**
     * 添加投信息，以及一些配置
     *
     * @param accessToken
     * @param appVersion
     * @return
     */
    public static OkHttpClient genericClient(final String accessToken, final String appVersion){
        Log.e("Http请求返回数据","----data:accessToken----" + accessToken + "----appVersion----" + appVersion);
        //日志显示级别
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("Http请求返回数据","----OkHttp====Message:"+message);
            }
        });
        loggingInterceptor.setLevel(level);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("token", accessToken)
                                .addHeader("APP_VERSION", appVersion)
                                .addHeader("CHANNEL","ANDROID")
                                .addHeader("other","other")
                                .build();//添加请求头里面放入参数
                        return chain.proceed(request);
                    }
                }).connectTimeout(Contact.TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(Contact.TIMEOUT, TimeUnit.MILLISECONDS).writeTimeout(Contact.TIMEOUT, TimeUnit.MILLISECONDS).build();
        return httpClient;
    }

    @Override
    public void login() {

    }
}
