package com.lc.liao.mygithub.dataprovider.api.preference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by liao on 2017/3/8.
 */

public class SharePreferenceApi {
    private SharedPreferences preferences;
    private static SharePreferenceApi sharePreferenceApi;

    public static SharePreferenceApi getInstall(Context context){
       if(sharePreferenceApi == null) sharePreferenceApi = new SharePreferenceApi(context);
        return sharePreferenceApi;
    }

    public SharePreferenceApi(Context context){
        preferences = context.getSharedPreferences(SharePreferenceContact.PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    /**
     * 存入字符串
     * @param key
     * @param value
     */
    public void setString(String key, String value){
        if(preferences != null)
            preferences.edit().putString(key, value).commit();
    }

    /**
     * 读取字符串
     * @param key
     * @param defaultValue
     * @return
     */
    public String getString(String key, String defaultValue){
        if(preferences != null)
            return preferences.getString(key, defaultValue);
        return "";
    }

    /**
     * 设置boolean值
     */
    public void setBoolean(String key, boolean value) {
        if (preferences != null)
            preferences.edit().putBoolean(key, value).commit();
    }

    public boolean getBoolean(String key, boolean defalutValue) {
        if (preferences != null)
            preferences.getBoolean(key, defalutValue);
        return defalutValue;
    }

    //int
    public void setInt(String key, int value) {
        if (preferences != null)
            preferences.edit().putInt(key, value).commit();
    }

    public int getInt(String key, int defalutValue) {
        if (preferences != null)
            return preferences.getInt(key, defalutValue);
        return defalutValue;
    }

    //float
    public void setFloat(String key, float value) {
        if (preferences != null)
            preferences.edit().putFloat(key, value).commit();
    }

    public float getFloat(String key, float defalutValue) {
        if (preferences != null)
            return preferences.getFloat(key, defalutValue);
        return defalutValue;
    }

    //long
    public void setLong(String key, long value) {
        if (preferences != null)
            preferences.edit().putLong(key, value).commit();
    }

    public long getLong(String key, long defalutValue) {
        if (preferences != null)
            return preferences.getLong(key, defalutValue);
        return defalutValue;
    }
}
