package com.lc.liao.mygithub;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.lc.liao.mygithub.utils.ThreadPoolUtil;

import java.util.Stack;

/**
 * Created by liao on 2017/1/5.
 */

public class CustomApplication extends MultiDexApplication {

    private static Stack<Activity> activityStack;

    @Override
    public void onTerminate() {
        ThreadPoolUtil.getInstall().destory();
        super.onTerminate();
    }

    //下面的将是activity 的管理方法
    /**
     * 添加Activity到栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（栈顶Activity）
     */
    public Activity currentActivity() {
        if (activityStack == null || activityStack.isEmpty()) {
            return null;
        }
        Activity activity = activityStack.lastElement();
        return activity;
    }
    /**
     * 获取当前Activity（栈顶Activity）
     */
    public int currentActivityLength() {
        if (activityStack == null || activityStack.isEmpty()) {
            return 0;
        }
        return activityStack.size();
    }

    /**
     * 获取当前Activity（栈顶Activity） 没有找到则返回null
     */
    public Activity findActivity(Class<?> cls) {
        Activity activity = null;
        for (Activity aty : activityStack) {
            if (aty.getClass().equals(cls)) {
                activity = aty;
                break;
            }
        }
        return activity;
    }

    /**
     * 结束当前Activity（栈顶Activity）
     */
    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity(重载)
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定的Activity(重载)
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    public void getActivity() {
        if(activityStack != null && activityStack.size() > 1){
            for (int i = 0 , size = activityStack.size(); i < size - 1; i++){
                activityStack.get(i).finish();
            }
        }
    }

    /**
     * 关闭除了指定activity以外的全部activity 如果cls不存在于栈中，则栈全部清空
     *
     * @param cls
     */
    public void finishOthersActivity(Class<?> cls) {
        Stack<Activity> activityList = new Stack<Activity>();
        for (Activity activity : activityStack) {
            if (!(activity.getClass().equals(cls))) {
                activityList.add(activity);
            }
        }
        for(int i = 0 , size = activityList.size(); i < size; i++){
            if(null != activityStack.get(i)){
                activityList.get(i).finish();
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 应用程序退出
     */
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            ActivityManager activityMgr = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
