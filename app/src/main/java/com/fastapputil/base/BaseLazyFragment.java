package com.fastapputil.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * fragment配合viewpager使用时,
 *
 * 由于viewpager的缓存机制使得fragment的生命周期回掉函数失去其原来的意义
 *
 * BaseLazyFragment对fragment略做处理，以保证onFragmentVisibleChanged()
 *
 * 在fragment第一次加载时正确，其它情况回调时机跟 {@link #setUserVisibleHint(boolean)}一致。
 *
 * created by bcoly on 2017/7/21.
 */

public abstract class BaseLazyFragment extends BaseFragment {
    protected boolean isFragmentVisible;
    protected boolean hasCreateView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isFragmentVisible = false;
        hasCreateView = false;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!hasCreateView && getUserVisibleHint()) {//说明fragment是第一次加载
            isFragmentVisible = true;
            onFragmentVisibleChanged(true);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (null == mView) {
            return;
        }
        hasCreateView = true;
        if (isVisibleToUser) {
            isFragmentVisible = true;
            onFragmentVisibleChanged(true);
            return;
        }
        if (isFragmentVisible) {
            isFragmentVisible = false;
            onFragmentVisibleChanged(false);
        }
    }

    protected void onFragmentVisibleChanged(boolean isVisible) {
    }
}
