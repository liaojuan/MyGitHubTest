package com.lc.liao.mygithub.utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by liao on 2017/1/5.
 */

public class UiUtil {

    /**
     * 跳转页面，不需要返回值
     *
     * @param context
     * @param cla
     */
    public static void intentActivity(Context context, Class<?> cla) {
        Intent intent = new Intent(context, cla);
        context.startActivity(intent);
    }
}
