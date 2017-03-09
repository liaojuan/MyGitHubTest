package com.lc.liao.mygithub.dataprovider.api.http.base;

/**
 * Created by liao on 2017/3/8.
 * http请求接口定义
 */
public interface HttpApi {

    /**
     * 1.登录
     *
     * @param username
     * @param password
     * @param callBack
     */
    void login(String username, String password, HttpRequestCallBack callBack);
}
