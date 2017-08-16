package com.fastapputil.ui.fragment;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fastapputil.R;
import com.fastapputil.base.BaseLazyFragment;
import com.fastapputil.util.StatusBarUtil;
import com.fastapputil.widget.banner.GlideImageLoader;
import com.fastapputil.widget.custom.MyScrollView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * created by bcoly on 2017/7/21.
 */

public class Fragment_1 extends BaseLazyFragment {

    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.scrollView)
    MyScrollView mScrollView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private int h = 0;

    @Override
    protected int initViewId() {
        return R.layout.fragment_1;
    }

    @Override
    protected void process() {
        initStatusBarTranslate();
        initBanner();

    }

    private int mOffset = 0;
    private int mScrollY = 0;

    /**
     * 透明状态栏
     */
    private void initStatusBarTranslate() {
        /**状态栏透明和间距处理*/
        StatusBarUtil.immersive(getActivity());
        StatusBarUtil.setPaddingSmart(getActivity(), mToolbar);

        ViewGroup.LayoutParams bannerParams = mBanner.getLayoutParams();
        ViewGroup.LayoutParams titleBarParams = mToolbar.getLayoutParams();
        Log.d("TAG", "bannerParams.height - " + bannerParams.height);
        Log.d("TAG", "titleBarParams.height - " + titleBarParams.height);
        h = bannerParams.height - titleBarParams.height;

        mScrollView.setScrollViewListener(new MyScrollView.ScrollViewListener() {
            private int lastScrollY = 0;

            private int color = ContextCompat.getColor(mContext, R.color.colorAccent) & 0x00ffffff;

            @Override
            public void onScrollChanged(MyScrollView scrollView, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if (lastScrollY < h && scrollY>=0) {
                    scrollY = Math.min(h, scrollY);
                    mScrollY = scrollY > h ? h : scrollY;
//                    mToolbar.setAlpha(1f * mScrollY / h);
                    mToolbar.setBackgroundColor(((255 * mScrollY / h) << 24) | color);
                }
                Log.d("TAG", "scrollY - " + scrollY);
                lastScrollY = scrollY;
            }
        });

        mToolbar.setBackgroundColor(0);


    }

    /**
     * ViewPager 广告 图片 轮播
     */
    private void initBanner() {
        mBanner.setImageLoader(new GlideImageLoader());

        /**设置图片集合*/
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.b1);
        imageList.add(R.drawable.b2);
        imageList.add(R.drawable.b3);
        imageList.add(R.drawable.b4);
        imageList.add(R.drawable.b5);
        imageList.add(R.drawable.b6);
        imageList.add(R.drawable.b7);
        imageList.add(R.drawable.b8);

        /**设置标题集合*/
        final List<String> titleList = new ArrayList<>();
        titleList.add("天");
        titleList.add("地");
        titleList.add("玄");
        titleList.add("黄");
        titleList.add("宇");
        titleList.add("宙");
        titleList.add("洪");
        titleList.add("荒");

        mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(imageList);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.Accordion);
        //设置标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(titleList);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(2500);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();

        mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(mContext, titleList.get(position), Toast.LENGTH_SHORT).show();


            }
        });

    }

}
