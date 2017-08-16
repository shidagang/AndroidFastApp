package com.fastapputil.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.fastapputil.MainActivity;
import com.fastapputil.R;
import com.fastapputil.base.Constants;
import com.fastapputil.util.PreferenceHelper;
import com.fastapputil.widget.imageslider.Indicators.CircleIndicator;
import com.fastapputil.widget.imageslider.Tricks.SlidePagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * created by bcoly on 2017/7/20.
 */

public class GuideActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.circleIndicator)
    CircleIndicator mCircleIndicator;
    @BindView(R.id.nextPageAction)
    Button mNextPageAction;
    @BindView(R.id.skipAction)
    Button mSkipAction;

    private int[] layouts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE); // 去除标题  必须在setContentView()方法之前调用
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // 设置全屏
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);

        layouts = new int[]{
                R.layout.guide_1,
                R.layout.guide_2,
                R.layout.guide_3,
                R.layout.guide_4,
                R.layout.guide_5
        };

        /** making notification bar transparent */
        changeStatusBarColor();

        GuideViewPagerAdapter viewPagerAdapter = new GuideViewPagerAdapter();
        mViewPager.setAdapter(viewPagerAdapter);

        mViewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        mCircleIndicator.setViewPager(mViewPager);
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position == layouts.length - 1) {
                mNextPageAction.setText("开始体验");
                mSkipAction.setVisibility(View.GONE);
            } else {
                mNextPageAction.setText("下一页");
                mSkipAction.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @OnClick({R.id.nextPageAction, R.id.skipAction})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.nextPageAction:
                int current = mViewPager.getCurrentItem() + 1;
                if (current < layouts.length) {
                    mViewPager.setCurrentItem(current);
                } else {
                    gotoMainActivity();
                }
                break;
            case R.id.skipAction:
                gotoMainActivity();
                break;
        }
    }

    private void gotoMainActivity() {
        PreferenceHelper.putBoolean(Constants.IS_FIRST_IN, false);
        Intent intent = new Intent(GuideActivity.this, MainActivity.class);
//        intent.putExtra(Constants.MAIN_TYPE, HomeFragment.class.getSimpleName());
        startActivity(intent);
        finish();
    }

    /**
     * viewpager adapter
     */
    public class GuideViewPagerAdapter extends SlidePagerAdapter {

        private LayoutInflater layoutInflater;

        public GuideViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public int getRealCount() {
            return layouts.length;

        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
