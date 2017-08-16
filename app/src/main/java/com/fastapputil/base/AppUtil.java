package com.fastapputil.base;

/**
 * Created by oyty on 12/20/16.
 */

public class AppUtil {

    private static final int SERVER_TYPE = SERVER_ADDR.PRODUCT;

    private static final String API_DEV = "http://120.77.215.77:3000";
    private static final String API_BETA = "http://119.29.76.232:3000";
    private static final String API_PRODUCT = "https://gogobids.com/api";

    private static final String IMAGE_DEV = "http://oimopldhg.bkt.clouddn.com";
    private static final String IMAGE_BETA = "http://oimopldhg.bkt.clouddn.com";
    private static final String IMAGE_PRODUCT = "https://qnimg.gogobids.com";

    private static final String BID_DEV = "http://120.77.215.77:7089";
    private static final String BID_BETA = "http://120.77.215.77:7089";
    private static final String BID_PRODUCT = "https://gogobids.com";

    private static final String PAY_DEV = "http://120.77.215.77:7090";
    private static final String PAY_BETA = "http://120.77.215.77:7090";
    private static final String PAY_PRODUCT = "https://gogobids.com";

    private static final String ACTIVE_DEV = "http://120.77.215.77:4000";
    private static final String ACTIVE_BETA = "http://120.77.215.77:4000";
    private static final String ACTIVE_PRODUCT = "https://ad.gogobids.com";

    private static final String RECORD_DEV = "https://10.0.0.108:8443/spjl/UserActionLog";
    private static final String RECORD_BETA = "http://120.77.215.77:4000";
    private static final String RECORD_PRODUCT = "https://log.gogobids.com/spjl/UserActionLog";


    public static String getApiHost() {
        String url = null;
        switch (SERVER_TYPE) {
            case SERVER_ADDR.DEV:
                url = API_DEV;
                break;
            case SERVER_ADDR.BETA:
                url = API_BETA;
                break;
            case SERVER_ADDR.PRODUCT:
                url = API_PRODUCT;
        }
        return url;
    }

    public static String getBidHost() {
        String url = null;
        switch (SERVER_TYPE) {
            case SERVER_ADDR.DEV:
                url = BID_DEV;
                break;
            case SERVER_ADDR.BETA:
                url = BID_BETA;
                break;
            case SERVER_ADDR.PRODUCT:
                url = BID_PRODUCT;
        }
        return url;
    }

    public static String getImageHost() {
        String url = null;
        switch (SERVER_TYPE) {
            case SERVER_ADDR.DEV:
                url = IMAGE_DEV;
                break;
            case SERVER_ADDR.BETA:
                url = IMAGE_BETA;
                break;
            case SERVER_ADDR.PRODUCT:
                url = IMAGE_PRODUCT;
        }
        return url;
    }

    public static String getPayHost() {
        String url = null;
        switch (SERVER_TYPE) {
            case SERVER_ADDR.DEV:
                url = PAY_DEV;
                break;
            case SERVER_ADDR.BETA:
                url = PAY_BETA;
                break;
            case SERVER_ADDR.PRODUCT:
                url = PAY_PRODUCT;
        }
        return url;
    }

    public static String getActiveHost() {
        String url = null;
        switch (SERVER_TYPE) {
            case SERVER_ADDR.DEV:
                url = ACTIVE_DEV;
                break;
            case SERVER_ADDR.BETA:
                url = ACTIVE_BETA;
                break;
            case SERVER_ADDR.PRODUCT:
                url = ACTIVE_PRODUCT;
        }
        return url;
    }

    public static String getRecordAddress() {
        String url = null;
        switch (SERVER_TYPE) {
            case SERVER_ADDR.DEV:
                url = RECORD_DEV;
                break;
            case SERVER_ADDR.BETA:
                url = RECORD_BETA;
                break;
            case SERVER_ADDR.PRODUCT:
                url = RECORD_PRODUCT;
        }
        return url;
    }

    public static int getServerType() {
        return SERVER_TYPE;
    }


    private interface SERVER_ADDR {
        int DEV = 1;
        int BETA = 2;
        int PRODUCT = 3;
    }
}
