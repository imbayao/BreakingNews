package com.agan.breakingnews.Utils;

import android.os.Bundle;
import android.util.Log;

import com.agan.breakingnews.App;
import com.agan.breakingnews.Bean.Comment;
import com.agan.breakingnews.Bean.News;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by elso on 17-3-24.
 * JSON解析类
 */

public class JSONParsing {

    public static Map<String, String> jsonParsingWithUser(String response){
        Map<String, String> status = new HashMap<String, String>();
        try {
            JSONObject object = new JSONObject(response);
            String biu = object.getString("biu");
            String message = object.getString("message");
            if(biu.equals("1")){
                String token = object.getString("token");
                App.setTOKEN(token);
                status.put("biu", biu);
                status.put("message", message);
            }else if (biu.equals("2")){
                status.put("biu", biu);
                status.put("message", message);
            }else {
                status.put("biu", biu);
                status.put("message", message);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

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
                int id = jsonObject.getInt("id");
                int newsKindId = jsonObject.getInt("news_kind_id");
                News news = new News();
                news.setNewsTitle(newsTitle);
                news.setNewsTime(newsTime);
                news.setNewsPic(newsPic);
                news.setNewsDetail(newsDetail);
                news.setNewsKindId(newsKindId);
                news.setId(id);
                newsData.add(news);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return newsData;
    }

    public static List<Comment> jsonParsingWithCommentGet(String response){
        List<Comment> commentData = new ArrayList<>();
        try {
            JSONArray result = new JSONArray(response);
            for (int i = 0; i < result.length(); i++) {
                JSONObject jsonObject = (JSONObject) result.get(i);
                String commentUsername = jsonObject.getString("newstitle");
                String commentContent = jsonObject.getString("content");
                String commentTime = jsonObject.getString("created_at");
                Comment comment = new Comment();
                comment.setCommentUsername(commentUsername);
                comment.setCommentContent(commentContent);
                comment.setCommentTime(commentTime);
                commentData.add(comment);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return commentData;
    }

    public static Map<String, String> jsonParsingWithCommentSend(String response){
        Map<String, String> status = new HashMap<String, String>();
        try {
            JSONObject object = new JSONObject(response);
            String biu = object.getString("biu");
            String message = object.getString("message");
            if(biu.equals("1")){
                status.put("biu", biu);
                status.put("message", message);
            }else {
                status.put("biu", biu);
                status.put("message", message);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }
}
