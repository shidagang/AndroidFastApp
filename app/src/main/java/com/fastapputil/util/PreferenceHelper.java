package com.fastapputil.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.fastapputil.base.App;
import com.fastapputil.base.Constants;

/**
 * created by bcoly on 2017/7/20.
 */

public class PreferenceHelper {
    public static final String PREFERENCE_NAME_CIRCLE = "sharepreference_flash";
    public static final String SHOW_LOCK__NOTIFICATION = "show_lock__notification";


    private static SharedPreferences getSharedPreference() {
        Context context = App.getInstance().getApplicationContext();
        return context.getSharedPreferences(PREFERENCE_NAME_CIRCLE, Context.MODE_PRIVATE);

    }

    public static boolean putString(String tag, String value) {
        SharedPreferences prefs = getSharedPreference();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(tag, value);
        return editor.commit();
    }

    public static String getString(String tag) {
        return getString(tag, "");
    }

    public static String getString(String tag, String defaultValue) {
        SharedPreferences prefs = getSharedPreference();
        return prefs.getString(tag, defaultValue);
    }

    public static boolean putBoolean(String tag, boolean value) {
        SharedPreferences prefs = getSharedPreference();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(tag, value);
        return editor.commit();
    }

    public static boolean getBoolean(String tag) {
        return getBoolean(tag, false);
    }

    public static boolean getBoolean(String tag, boolean defaultValue) {
        SharedPreferences prefs = getSharedPreference();
        return prefs.getBoolean(tag, defaultValue);
    }

    public static boolean isFirstIn() {
        return getBoolean(Constants.IS_FIRST_IN, true);
    }



}
