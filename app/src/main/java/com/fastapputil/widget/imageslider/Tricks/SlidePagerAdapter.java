package com.fastapputil.widget.imageslider.Tricks;

import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * Created by oyty on 10/21/16.
 */

public class SlidePagerAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    public int getRealCount() {
        return 0;
    }
}
