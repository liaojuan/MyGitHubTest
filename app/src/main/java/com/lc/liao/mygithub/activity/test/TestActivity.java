package com.lc.liao.mygithub.activity.test;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import com.lc.liao.mygithub.R;
import com.lc.liao.mygithub.activity.base.BaseActivity;

/**
 * Created by liao on 2017/1/5.
 */

public class TestActivity extends BaseActivity{
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void initView() {
        mDrawerLayout = getViewById(R.id.id_drawer_layout);
        mNavigationView = getViewById(R.id.id_nv_menu);

        Toolbar toolbar = getViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }
}
