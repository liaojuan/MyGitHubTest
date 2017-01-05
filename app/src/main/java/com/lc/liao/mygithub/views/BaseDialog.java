package com.lc.liao.mygithub.views;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

/**
 * @desc 基础dialog
 * Created by liao on 2017/1/5.
 */

public class BaseDialog extends Dialog{

    public BaseDialog(Context context) {
        super(context);
    }

    public BaseDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected BaseDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    /**
     * 获取组件
     * @param resId
     * @param <T>
     * @return
     */
    protected <T extends View> T getViewById(int resId){
        return (T)findViewById(resId);
    }
}
