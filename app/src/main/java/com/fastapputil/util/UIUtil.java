package com.fastapputil.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;

import com.fastapputil.base.App;

/**
 * created by bcoly on 2017/7/26.
 */

public class UIUtil {
    public static Context getContext() {
        return App.getContext();
    }

    public static Resources getResources() {
        return getContext().getResources();
    }

    public static String getString(int resId) {
        return getResources().getString(resId);
    }

    public static String[] getStringArray(int resId) {
        return getResources().getStringArray(resId);
    }

    public static String getPackageName() {
        return getContext().getPackageName();
    }

    public static int getColor(int resId) {
        return getResources().getColor(resId);
    }

    public static float getDimen(int resId) {
        return getResources().getDimension(resId);
    }

    public static Handler getMainHandler() {
        return App.getMainHandler();
    }

    public static long getMainThreadId() {
        return App.getMainThreadId();
    }
}
