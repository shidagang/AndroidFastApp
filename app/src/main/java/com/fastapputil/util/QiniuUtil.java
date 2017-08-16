package com.fastapputil.util;

import android.text.TextUtils;

import com.fastapputil.base.AppUtil;


/**
 * Created by oyty on 12/19/16.
 */

public class QiniuUtil {

    public static String getImageURL(String url) {
        if (TextUtils.isEmpty(url) || url.contains("NULL")) {
            return "";
        }
        if (url.startsWith("http://") || url.startsWith("https://")) {
            return url;
        } else {

            return AppUtil.getImageHost() + "/" + url;
        }
    }

    public static String getThumbUrl(String url, int width, int height) {
        StringBuilder sb = new StringBuilder(url);
        sb.append("?imageView2/1/w/");
        sb.append(width + "/h/");
        sb.append(height);
        return sb.toString();
    }

}
