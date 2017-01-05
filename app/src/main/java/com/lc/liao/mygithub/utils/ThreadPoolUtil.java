package com.lc.liao.mygithub.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @desc 线程池管理工具类
 * Created by liao on 2017/1/5.
 */

public class ThreadPoolUtil {

    private ExecutorService poolUtil;
    private static ThreadPoolUtil threadPoolUtil;
    private int maxThreadNum = 5; //最多线程

    public static ThreadPoolUtil getInstall(){
        if(threadPoolUtil == null) threadPoolUtil = new ThreadPoolUtil();
        return threadPoolUtil;
    }

    public ThreadPoolUtil(){
//        poolUtil = Executors.newCachedThreadPool(); //尽量开到最多
        poolUtil = Executors.newFixedThreadPool(maxThreadNum); //最多开启maxThreadNum
    }

    /**
     * 添加任务
     * @param runnable
     */
    public void addTask(Runnable runnable){
        if(poolUtil != null && runnable != null)
            poolUtil.execute(runnable);
    }

    /**
     * 销毁线程池
     */
    public void destory(){
        if (poolUtil != null)
            poolUtil.shutdownNow();
        poolUtil = null;
        threadPoolUtil = null;
    }
}
