package com.lc.liao.mygithub.activity;

import android.view.View;
import android.widget.TextView;

import com.lc.liao.mygithub.R;
import com.lc.liao.mygithub.activity.base.BaseActivity;
import com.lc.liao.mygithub.activity.test.TestActivity;
import com.lc.liao.mygithub.utils.UiUtil;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private TextView leftAndRightTxt;//左右滑动菜单

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        leftAndRightTxt = getViewById(R.id.txt_left_and_right);
        leftAndRightTxt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txt_left_and_right:
                UiUtil.intentActivity(mContext, TestActivity.class);
                break;
        }
    }
}
