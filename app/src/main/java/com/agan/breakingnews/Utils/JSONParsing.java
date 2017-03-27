package com.agan.breakingnews.Utils;

import android.util.Log;

import com.agan.breakingnews.Bean.News;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elso on 17-3-24.
 * JSON解析类
 */

public class JSONParsing {

    /**
     * 新闻JSON解析
     * @param response  获取的请求数据
     * @return          解析后的List<News>
     */
    public static List<News> jsonParsingWithNews(String response){
        List<News> newsData = new ArrayList<>();
        try {
            JSONArray result = new JSONArray(response);
            for (int i = 0; i < result.length(); i++) {
                JSONObject jsonObject = (JSONObject) result.get(i);
                String newsTitle = jsonObject.getString("newstitle");
                String newsTime = jsonObject.getString("newstime");
                String newsPic = jsonObject.getString("newspic");
                String newsDetail = jsonObject.getString("newsdetail");
                News news = new News();
                news.setNewsTitle(newsTitle);
                news.setNewsTime(newsTime);
                news.setNewsPic(newsPic);
                news.setNewsDetail(newsDetail);
                newsData.add(news);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return newsData;
    }
}
