package com.lc.liao.mygithub.dataprovider.api.http.base;

/**
 * Created by liao on 2017/3/9.
 *
 * 重新封装的回调，方便以后扩展
 */
public interface HttpRequestCallBack<T>{
    /**
     * 成功
     */
    void onResponse(T t);

    /**
     * 失败
     */
    void onFailure(T t);
}
