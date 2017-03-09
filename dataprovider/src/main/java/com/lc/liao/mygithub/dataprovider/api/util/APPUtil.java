package com.lc.liao.mygithub.dataprovider.api.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

/**
 * Created by liao on 2017/3/9.
 */

public class APPUtil {

    /**
     * 获取单个APP版本号
     * @param context
     * @return
     */
    public static String getAppVersion(Context context){
        String appVersion = "1.0";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            appVersion = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appVersion;
    }

    /**
     * 获取单个APP图片
     * @param context
     * @return
     */
    public static Drawable getAppIcon(Context context){
        Drawable icon = null;
        try {
            icon = context.getPackageManager().getApplicationIcon(context.getPackageName());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return icon;
    }

    /**
     * 获取单个APP名称
     * @param context
     * @return
     */
    public static String getAppName(Context context){
        String appName = "";
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            appName = context.getPackageManager().getApplicationLabel(appInfo).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appName;
    }

    /**
     * 获取单个APP的所有权限
     * @param context
     * @return
     */
    public static String[] getAppPermission(Context context){
        String[] permission = null;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS);
            permission = packageInfo.requestedPermissions;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return permission;
    }

    /**
     * 获取单个APP的签名
     * @param context
     * @return
     */
    public static String getAppSignature(Context context){
        String appSignature = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            appSignature = packageInfo.signatures[0].toCharsString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appSignature;
    }
}
