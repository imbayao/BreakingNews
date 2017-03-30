package com.agan.breakingnews;



/**
 * Created by elso on 17-3-24.
 * 全局类
 */

public class App{
    private final static String BASE_URL = "http://10.0.3.2:3000/api";
    private final static String URL_LOGIN = "/login";
    private final static String URL_REGISTER = "/register";
    private final static String URL_SCHOOL_NEWS = "/school";
    private final static String URL_DOMESTIC_NEWS = "/domestic";
    private final static String URL_WORLD_NEWS = "/world";
    private final static String URL_COMMENT_GET = "/getcomment";
    private final static String URL_COMMENT_SEND = "/sendcomment";
    private static String TOKEN;

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

    public static String getUrlRegister() {
        return URL_REGISTER;
    }

    public static String getUrlCommentGet() {
        return URL_COMMENT_GET;
    }

    public static String getUrlCommentSend() {
        return URL_COMMENT_SEND;
    }

    public static String getTOKEN() {
        return TOKEN;
    }

    public static void setTOKEN(String TOKEN) {
        App.TOKEN = TOKEN;
    }


}
