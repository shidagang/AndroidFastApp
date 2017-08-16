package com.fastapputil.base;

import android.content.Context;

import java.util.List;

/**
 * 所有 Adapter 的 Base 类
 * created by bcoly on 2017/7/26.
 */

public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {

    protected Context mContext;
    private List<T> mList;
    protected String key;

    public BaseAdapter(Context context) {
        this.mContext = context;
    }

    public BaseAdapter(Context context, List<T> TList) {
        this.mContext = context;
        this.mList = TList;
    }

    @Override
    public int getCount() {
        if (mList == null)
            return -1;
        return mList.size();
    }

    @Override
    public T getItem(int position) {
        if (mList == null || mList.size() <= 0 || position < 0 || position > mList.size())
            return null;
        return mList.get(position);
    }

    public T getPositionItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setDadaAndNotify(List<T> list) {
        this.mList = list;
        notifyDataSetChanged();
        this.key = "";
    }

    public void setDadaAndNotify(List<T> list,String key) {
        this.mList = list;
        notifyDataSetChanged();
        this.key = key;
    }

    public int getListSize() {
        return mList.size();
    }

    public List<T> getList() {
        return mList;
    }
}
