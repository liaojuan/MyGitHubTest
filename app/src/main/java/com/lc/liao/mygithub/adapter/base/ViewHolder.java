package com.lc.liao.mygithub.adapter.base;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;

/**
 * Created by liao on 2017/3/13.
 *
 * 公用的view
 */

public class ViewHolder {
    /**
     * 对应的布局view
     */
    private View itemView;
    /**
     * 位置
     */
    private int position;

    public ViewHolder(View view, int position){
        this.itemView = view;
        this.position = position;
    }

    /**
     * 获取组件
     *
     * @param resId
     * @param <T>
     * @return
     */
    public <T extends View> T getViewById(int resId){
        if(itemView != null)
            return (T) itemView.findViewById(resId);
        return null;
    }

    /**
     * 获取上下文(这里用这个方法是在用的Image加载图片的时候处理)
     *
     * @return
     */
    public Context getContext(){
        return itemView.getContext();
    }

    /**
     * 获取位置
     *
     * @return
     */
    public int getPosition(){
        return position;
    }

    /**
     * 获取itemView
     *
     * @return
     */
    public View getItemView(){
        return itemView;
    }

    /**
     * 更新position
     *
     * @param position
     */
    public void setPosition(int position){
        this.position = position;
    }

    /**
     * 获取资源string
     *
     * @param resId
     * @return
     */
    public String getResourceString(int resId) {
        return getContext().getResources().getString(resId);
    }

    /**
     * 获取资源string
     * @param resId
     * @param args
     * @return
     */
    public String getResourceString(int resId, Object... args) {
        return getContext().getResources().getString(resId, args);
    }

    /**
     * 获取资源COLOR
     *
     * @param resId
     * @return
     */
    public int getResourceColor(int resId) {
        return ContextCompat.getColor(getContext(), resId);
    }

    /**
     * 获取资源 Dimension
     *
     * @param resId
     * @return
     */
    public int getResourceDimensionPixel(int resId) {
        return getContext().getResources().getDimensionPixelSize(resId);
    }
}
