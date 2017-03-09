package com.lc.liao.mygithub.dataprovider.api.http.retrofitimpl;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by liao on 2017/3/8.
 * Retrofit接口定义
 */
public interface ApiInterfaces {

    /**
     * 1.登录
     *
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("/login")
    Call<JsonObject> login(@Field("username") String username,
                           @Field("password") String password);
}
