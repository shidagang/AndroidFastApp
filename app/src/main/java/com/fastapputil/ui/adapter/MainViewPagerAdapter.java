package com.fastapputil.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fastapputil.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oyty on 11/7/16.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments = new ArrayList<>();
    private BaseFragment currentFragment;

    public MainViewPagerAdapter(FragmentManager fm, List<BaseFragment> baseFragments) {
        super(fm);
        this.fragments = baseFragments;
        currentFragment = fragments.get(0);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public BaseFragment getCurrentFragment() {
        return currentFragment;
    }
}
