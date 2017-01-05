package com.lc.liao.mygithub.activity.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.lc.liao.mygithub.CustomApplication;
import com.lc.liao.mygithub.R;
import com.lc.liao.mygithub.utils.ScreenUtil;
import com.lc.liao.mygithub.views.ProgressBarDialog;

/**
 * Created by liao on 2016/12/30.
 */

public abstract class BaseActivity extends AppCompatActivity{
    protected Context mContext;
    private FrameLayout contairLayout;
    protected Toolbar toolbar;
    protected TextView leftBtn;
    protected TextView rightBtn;
    protected TextView titleLab;
    protected ProgressBarDialog progressBarDialog;
    /**
     * 数据加载状态展示View
     */
    protected View loadStatusView;
    protected TextView loadStatusTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        super.onCreate(savedInstanceState);
        ((CustomApplication) getApplication()).addActivity(this);
        mContext = this;
        setContentView(R.layout.activity_base);
        toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        toolbar.setTitle("");
        toolbar.setTitleMargin(0, 0, 0, 0);
        setSupportActionBar(toolbar);
        //重置toolbar高度，由于android最小高度是56dp 而设计图是48dp
        toolbar.getLayoutParams().height = ScreenUtil.getStatusHeight(mContext) + ScreenUtil.getDpToPx(48, mContext);

        contairLayout = getViewById(R.id.contair);
        View contentView = initRootView();
        if (contentView != null) {
            loadStatusView = getLayoutInflater().inflate(R.layout.layout_load_status, null);
            loadStatusTextView = (TextView) loadStatusView.findViewById(R.id.load_status_textView);
            contairLayout.addView(contentView);
            contairLayout.addView(loadStatusView);
            hideLoadStatusView();
        }
        leftBtn = getViewById(R.id.left_btn);
        rightBtn = getViewById(R.id.right_btn);
        titleLab = getViewById(R.id.title);
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLeftClick();
            }
        });
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRightClick();
            }
        });
        setToolTitle(getTitle().toString());
        initView();
    }

    /**
     * 隐藏toolbar（有阴影）
     */
    protected void hideToolbar() {
        setToolbarHeight(ScreenUtil.getStatusHeight(mContext));
    }

    /**
     * 隐藏toolbar(无阴影)
     */
    protected void hideToolbarAndElevation() {
        hideToolbar();
        hideElevation();
    }

    /**
     * 隐藏阴影
     */
    protected void hideElevation() {
        if (Build.VERSION.SDK_INT >= 21) {
            toolbar.setElevation(0);
        }
    }

    /**
     * 设置toolbar高度
     *
     * @param height
     */
    protected void setToolbarHeight(int height) {
        toolbar.getLayoutParams().height = height;
    }


    /**
     * 初始化布局view
     */
    protected abstract void initView();

    /**
     * 初始化界面布局
     *
     * @return
     */
    private View initRootView() {
        if (getLayoutId() != 0)
            return getLayoutInflater().inflate(getLayoutId(), null);
        return null;
    }

    /**
     * 获取布局的资源ID
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 获取组件
     *
     * @param resId
     * @param <T>
     * @return
     */
    protected <T extends View> T getViewById(int resId) {
        return (T) findViewById(resId);
    }

    /**
     * 获取组件
     *
     * @param resId
     * @param parent
     * @param <T>
     * @return
     */
    protected <T extends View> T getViewById(int resId, View parent) {
        return (T) parent.findViewById(resId);
    }

    /**
     * left 点击
     */
    protected void onLeftClick() {
        finish();
    }

    /**
     * right 点击
     */
    protected void onRightClick() {

    }

    /**
     * 设置标题
     *
     * @param titleStr
     */
    protected void setToolTitle(String titleStr) {
        if (titleLab != null) titleLab.setText(titleStr);
    }

    /**
     * 设置标题
     *
     * @param resId
     */
    protected void setToolTitle(int resId) {
        setToolTitle(getString(resId));
    }

    /**
     * 获取颜色
     *
     * @param resId
     * @return
     */
    protected int getResourceColor(int resId) {
        return ContextCompat.getColor(mContext, resId);
    }

    /**
     * 获取图片资源
     *
     * @param resId
     * @return
     */
    protected Drawable getResourceDrawable(int resId) {
        return ContextCompat.getDrawable(mContext, resId);

    }

    /**
     * 显示操作提示
     *
     * @param value 提示文本
     */
    public void showProgressBarDialog(String value) {
        if (progressBarDialog == null)
            progressBarDialog = new ProgressBarDialog(this);

        if (!progressBarDialog.isShowing()) {
            if (TextUtils.isEmpty(value))
                progressBarDialog.show();
            else
                progressBarDialog.show(value);
        }
    }

    /**
     * 显示操作提示
     */
    public void showProgressBarDialog() {
        showProgressBarDialog("");
    }

    /**
     * 撤销操作提示
     */
    public void dismissProgressbarDialog() {
        if (progressBarDialog != null && progressBarDialog.isShowing()) {
            progressBarDialog.dismiss();
        }
    }

    /**
     * 显示标题栏左边返回按钮
     */
    protected void showToolTitleLeft() {
        if (leftBtn.getVisibility() == View.GONE) {
            leftBtn.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 消失标题栏左边返回按钮
     */
    protected void dismissToolTitleLeft() {
        if (leftBtn.getVisibility() == View.VISIBLE) {
            leftBtn.setVisibility(View.GONE);
        }
    }

    /**
     * 显示加载状态界面
     *
     * @param resId        图片资源
     * @param charSequence 文本内容
     */
    protected void showLoadStatusView(int resId, CharSequence charSequence) {
        if (loadStatusTextView == null || (resId <= 0 && TextUtils.isEmpty(charSequence))) return;
        if (resId > 0)
            loadStatusTextView.setCompoundDrawablesWithIntrinsicBounds(0, resId, 0, 0);
        loadStatusTextView.setText(charSequence);
        loadStatusView.setVisibility(View.VISIBLE);
    }

    /**
     * 隐藏加载结果界面
     */
    protected void hideLoadStatusView() {
        if (loadStatusView != null)
            loadStatusView.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        dismissProgressbarDialog();
        super.onDestroy();
    }
}
