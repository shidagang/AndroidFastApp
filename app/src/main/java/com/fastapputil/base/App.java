package com.fastapputil.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.support.multidex.MultiDexApplication;

/**
 * created by bcoly on 2017/7/20.
 */

public class App extends MultiDexApplication {
    private static App instance;
    private static Context context;
//    public static int updateTokenStatus = 1; // 1 需要， 0 不需要自动登录
//    public static boolean refreshingToken = false;
//    public LocationService locationService;
    private static Looper mainLooper;
    private static Handler mainHandler;
    private static Thread mainThread;
    private static long mainThreadId;

    public static synchronized App getInstance() {
        return instance;
    }

    public static Context getContext() {
        return context;
    }

    public static Thread getMainThread() {
        return mainThread;
    }

    public static Looper getMainThreadLooper() {
        return mainLooper;
    }

    public static Handler getMainHandler() {
        return mainHandler;
    }

    public static long getMainThreadId() {
        return mainThreadId;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = getApplicationContext();
        mainThread = Thread.currentThread();
        mainLooper = getMainLooper();
        mainHandler = new Handler();
        mainThreadId = Process.myTid();
    }
}
