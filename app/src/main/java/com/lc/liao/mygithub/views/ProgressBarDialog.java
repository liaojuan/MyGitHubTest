package com.lc.liao.mygithub.views;

import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lc.liao.mygithub.R;

/**
 * Created by liao on 2017/1/5.
 */

public class ProgressBarDialog extends BaseDialog{

    /**
     * 操作加载的效果
     */
    ProgressBar progressBar;
    TextView txtView;

    public ProgressBarDialog(Context context) {
        super(context, R.style.dialog);
        initView();
    }

    public ProgressBarDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected ProgressBarDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    private void initView(){
        setContentView(R.layout.layout_progressbar_dialog);
        setCancelable(false);
        getWindow().setBackgroundDrawableResource(R.drawable.dialog_shape_bg);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        txtView = (TextView) findViewById(R.id.textView);
    }

    /**
     * 加载的时候显示的提示字体内容
     * @param value
     */
    public void show(String value) {
        txtView.setText(value + "...");
        show();
    }

}
