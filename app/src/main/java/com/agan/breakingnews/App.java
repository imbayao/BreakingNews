package com.agan.breakingnews;



/**
 * Created by elso on 17-3-24.
 * 全局类
 */

public class App{
    private final static String BASE_URL = "http://10.0.3.2:3000/api";
    private final static String URL_LOGIN = "/login";
    private final static String URL_SCHOOL_NEWS = "/school";
    private final static String URL_DOMESTIC_NEWS = "/domestic";
    private final static String URL_WORLD_NEWS = "/world";

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getUrlLogin() {
        return URL_LOGIN;
    }

    public static String getUrlSchoolNews() {
        return URL_SCHOOL_NEWS;
    }

    public static String getUrlDomesticNews() {
        return URL_DOMESTIC_NEWS;
    }

    public static String getUrlWorldNews() {
        return URL_WORLD_NEWS;
    }
}
