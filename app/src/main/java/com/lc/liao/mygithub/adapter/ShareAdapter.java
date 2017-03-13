package com.lc.liao.mygithub.adapter;

import com.lc.liao.mygithub.adapter.base.CustomerBaseAdapter;
import com.lc.liao.mygithub.adapter.base.ViewHolder;

import java.util.ArrayList;

/**
 * Created by liao on 2017/3/13.
 */

public class ShareAdapter extends CustomerBaseAdapter<String>{

    public ShareAdapter(ArrayList<String> datas, int layoutResId) {
        super(datas, layoutResId);
    }

    @Override
    public void bindData(ViewHolder holder, String s) {

    }
}
