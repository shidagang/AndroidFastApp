package com.fastapputil.ui.fragment;

import android.support.v7.widget.Toolbar;

import com.fastapputil.R;
import com.fastapputil.base.BaseLazyFragment;
import com.fastapputil.util.StatusBarUtil;

import butterknife.BindView;

/**
 * created by bcoly on 2017/7/21.
 */

public class Fragment_2 extends BaseLazyFragment {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int initViewId() {
        return R.layout.fragment_2;
    }

    @Override
    protected void initTitleBar() {
        setTitle("中心标题");
        initStatusBarTranslate();
    }

    /**
     * 透明状态栏
     */
    private void initStatusBarTranslate() {
        /**状态栏透明和间距处理*/
        StatusBarUtil.immersive(getActivity());
        StatusBarUtil.setPaddingSmart(getActivity(), mToolbar);
    }

    @Override
    protected void process() {

    }

}
