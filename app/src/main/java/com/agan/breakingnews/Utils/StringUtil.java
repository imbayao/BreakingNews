package com.agan.breakingnews.Utils;

/**
 * Created by elso on 17-3-30.
 */

public class StringUtil {

    public static String newsTimeToMonthDay(String newsTime){
        String monthDay = newsTime.replace("2017-", "").substring(0, 5);
        return monthDay;
    }
}
