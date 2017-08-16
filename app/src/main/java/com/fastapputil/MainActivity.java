package com.fastapputil;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;

import com.fastapputil.base.BaseActivity;
import com.fastapputil.base.BaseFragment;
import com.fastapputil.base.Constants;
import com.fastapputil.entity.MainNavigationEntity;
import com.fastapputil.ui.adapter.MainViewPagerAdapter;
import com.fastapputil.util.GsonUtil;
import com.fastapputil.util.PreferenceHelper;
import com.fastapputil.widget.bottomtab.AHBottomNavigation;
import com.fastapputil.widget.bottomtab.AHBottomNavigationItem;
import com.fastapputil.widget.bottomtab.AHBottomNavigationViewPager;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements
        AHBottomNavigation.OnTabSelectedListener,
        AHBottomNavigation.OnNavigationPositionListener,
        AHBottomNavigation.OnChoosePersonalBeforeListener{

    @BindView(R.id.mBottomTabView)
    AHBottomNavigation mBottomTabView;
    @BindView(R.id.mMainViewPager)
    AHBottomNavigationViewPager mMainViewPager;

    private MainViewPagerAdapter mainAdater;
    private List<BaseFragment> baseFragments = new ArrayList<>();
    private ArrayList<AHBottomNavigationItem> bottomItems = new ArrayList<>();

    @Override
    protected int initViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void process(Bundle savedInstanceState) {
        initBottomTab();

    }

    private void initBottomTab() {
        String cache = PreferenceHelper.getString(Constants.Cache.MAIN_NAVIGATION);

        if (TextUtils.isEmpty(cache)) {
            cache = Constants.StaticCache.MAIN_NAVIGATION;
        }

        List<MainNavigationEntity> list = GsonUtil.json2Array(cache, new TypeToken<List<MainNavigationEntity>>(){});

        baseFragments.clear();
        for (int i = 0; i < list.size(); i++) {
            MainNavigationEntity entity = list.get(i);
//            bottomItems.add(new AHBottomNavigationItem(entity.title, QiniuUtil.getImageURL(entity.img_click), QiniuUtil.getImageURL(entity.img_unclick)));

            try {
                baseFragments.add((BaseFragment) Class.forName(entity.function).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        bottomItems.add(new AHBottomNavigationItem("首页", R.drawable.img_1_1, R.drawable.img_1_0));
        bottomItems.add(new AHBottomNavigationItem("商城", R.drawable.img_2_1, R.drawable.img_2_0));
        bottomItems.add(new AHBottomNavigationItem("案例", R.drawable.img_3_1, R.drawable.img_3_0));
        bottomItems.add(new AHBottomNavigationItem("进度", R.drawable.img_4_1, R.drawable.img_4_0));
        bottomItems.add(new AHBottomNavigationItem("我的", R.drawable.img_5_1, R.drawable.img_5_0));


        mBottomTabView.addItems(bottomItems);
        mBottomTabView.setDefaultBackgroundColor(Color.WHITE);
        mBottomTabView.setForceTitlesDisplay(true);
        mBottomTabView.setOnChoosePersonalBeforeListener(this);
        mBottomTabView.setOnTabSelectedListener(this);
        mBottomTabView.setOnNavigationPositionListener(this);
        mBottomTabView.setBehaviorTranslationEnabled(true);
        mMainViewPager.setOffscreenPageLimit(4);
        mainAdater = new MainViewPagerAdapter(getSupportFragmentManager(), baseFragments);
        mMainViewPager.setAdapter(mainAdater);
    }

    @Override
    public boolean onChoosePersonalBefore() {
        return true;//个人中心
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        mMainViewPager.setCurrentItem(position, false);
        return true;
    }

    @Override
    public void onPositionChange(int y) {

    }
}
