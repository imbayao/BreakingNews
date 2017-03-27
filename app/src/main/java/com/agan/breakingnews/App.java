package com.agan.breakingnews;



/**
 * Created by elso on 17-3-24.
 *
 */

public class App{
    private final static String BASE_URL = "http://10.0.3.2:3000/api";
    private final static String URL_LOGIN = "/login";
    private final static String URL_NEWS = "/news";

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getUrlLogin() {
        return URL_LOGIN;
    }

    public static String getUrlNews() {
        return URL_NEWS;
    }
}
