package com.lc.liao.mygithub.adapter.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by liao on 2017/3/13.
 */

public abstract class CustomerBaseAdapter<T> extends BaseAdapter{
    private ArrayList<T> datas;
    private int layoutResId;

    public CustomerBaseAdapter(ArrayList<T> datas, int layoutResId){
        this.datas = datas;
        this.layoutResId = layoutResId;
    }

    @Override
    public int getCount() {
        if(datas != null)
            return datas.size();
        return 0;
    }

    @Override
    public T getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutResId, null);
            holder = new ViewHolder(view, i);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
            holder.setPosition(i);
        }
        bindData(holder, datas.get(i));

        return view;
    }

    /**
     * 绑定数据
     *
     * @param holder
     * @param t
     */
    public abstract void bindData(ViewHolder holder, T t);

    /**
     * 替换数据
     *
     * @param datas
     */
    public void setDatas(ArrayList<T> datas){
        this.datas = datas;
        notifyDataSetChanged();
    }

    /**
     * 增加数据
     *
     * @param newDatas
     */
    public void addDatas(ArrayList<T> newDatas) {
        this.datas.addAll(newDatas);
        notifyDataSetChanged();
    }

    /**
     * 清除所有数据
     */
    public void clearData() {
        this.datas.removeAll(datas);
        notifyDataSetInvalidated();
    }


    /**
     * 获取数据
     *
     * @return
     */
    public ArrayList<T> getDatas() {
        return datas;
    }
}
