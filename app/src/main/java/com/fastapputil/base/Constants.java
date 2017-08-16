package com.fastapputil.base;

/**
 * created by bcoly on 2017/7/20.
 */

public class Constants {

    public static final String IS_FIRST_IN = "is_first_in";

    public interface Cache {
        String MAIN_NAVIGATION = "main_navigation";
    }

    public interface StaticCache {
        String MAIN_NAVIGATION =
                "[" +
                        "{\"id\":1,\"title\":\"首页\"," +
                        "\"img_click\":\"R.drawable.img_1_1\"," +
                        "\"img_unclick\":\"R.drawable.img_1_0\"," +
                        "\"function\":\"com.fastapputil.ui.fragment.Fragment_1\"," +
                        "\"params\":[]}," +
                        "" +
                        "" +
                        "{\"id\":2,\"title\":\"商城\"," +
                        "\"img_click\":\"R.drawable.img_2_1\"," +
                        "\"img_unclick\":\"R.drawable.img_2_0\"," +
                        "\"function\":\"com.fastapputil.ui.fragment.Fragment_2\"," +
                        "\"params\":[]}," +
                        "" +
                        "" +
                        "" +
                        "{\"id\":3,\"title\":\"案例\"," +
                        "\"img_click\":\"R.drawable.img_3_1\"," +
                        "\"img_unclick\":\"R.drawable.img_3_0\"," +
                        "\"function\":\"com.fastapputil.ui.fragment.Fragment_3\"," +
                        "\"params\":[]}," +
                        "" +
                        "" +
                        "" +
                        "{\"id\":3,\"title\":\"进度\"," +
                        "\"img_click\":\"R.drawable.img_4_1\"," +
                        "\"img_unclick\":\"R.drawable.img_4_0\"," +
                        "\"function\":\"com.fastapputil.ui.fragment.Fragment_4\"," +
                        "\"params\":[]}," +
                        "" +
                        "" +
                        "" +
                        "{\"id\":4,\"title\":\"我的\"," +
                        "\"img_click\":\"R.drawable.img_5_1\"," +
                        "\"img_unclick\":\"R.drawable.img_5_0\"," +
                        "\"function\":\"com.fastapputil.ui.fragment.Fragment_5\"," +
                        "\"params\":[]}]";
    }

}
