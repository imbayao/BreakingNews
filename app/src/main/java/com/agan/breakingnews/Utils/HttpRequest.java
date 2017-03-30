package com.agan.breakingnews.Utils;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;



/**
 * Created by elso on 17-3-24.
 * 网络请求工具类
 */

public class HttpRequest {

    /**
     * 用户网络请求
     * @param address   请求地址
     * @param username  用户名
     * @param password  密码
     * @return          JSON
     */
    public static String httpURLConnectionWithUser(String address, String username, String password){
        HttpURLConnection connection = null;
        String postMessage = "username=" + username + "&password=" + password;
        StringBuffer response = new StringBuffer("");
        try {
            URL url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(20000);
            connection.setReadTimeout(20000);
            connection.setDoInput(true);
            OutputStream out = connection.getOutputStream();
            out.write(postMessage.getBytes());
            out.flush();
            out.close();
            InputStreamReader in = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(in);
            response = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null){
                response.append(line);
            }
            Log.i("----------->", response.toString());
            return response.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return response.toString();
    }


    /**
     * GET请求数据
     * @param address   请求地址
     * @return          获取json
     */
    public static String httpURLConnectionWithNewsGet(String address){
        HttpURLConnection connection = null;
        StringBuffer response = new StringBuffer("");
        try {
            URL url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(20000);
            connection.setReadTimeout(20000);
            InputStream in = connection.getInputStream();
            String line = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            response = new StringBuffer("");
            while ((line = reader.readLine()) != null){
                response.append(line);
            }
            Log.i("----------->", response.toString());
            return response.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return response.toString();
    }

    /**
     * 图片请求
     * @param address   图片地址
     * @return          Bitmap
     */
    public static Bitmap httpURLConnectionWithBitmap(String address){
        HttpURLConnection connection = null;
        Bitmap bitmap = null;
        try {
            URL url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();
            BufferedInputStream buf = new BufferedInputStream(in);
            bitmap = BitmapFactory.decodeStream(buf);
            in.close();
            buf.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (connection != null){
                connection.disconnect();
            }
        }
        return bitmap;
    }

    public static String httpURLConnectionWithCommentSend(String address, int newsId, int userId, String comment){
        HttpURLConnection connection = null;
        String postMessage = "newsid=" + newsId + "&userid=" + userId + "&comment=" + comment;
        StringBuffer response = new StringBuffer("");
        try {
            URL url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(20000);
            connection.setReadTimeout(20000);
            connection.setDoInput(true);
            OutputStream out = connection.getOutputStream();
            out.write(postMessage.getBytes());
            out.flush();
            out.close();
            InputStreamReader in = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(in);
            response = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null){
                response.append(line);
            }
            Log.i("----------->", response.toString());
            return response.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return response.toString();
    }

    public static String httpURLConnectionWithCommentGet(String address, int newsId){
        HttpURLConnection connection = null;
        String addres = address + "?newsid=" + newsId;
        StringBuffer response = new StringBuffer("");
        try {
            URL url = new URL(addres);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(20000);
            connection.setReadTimeout(20000);
            InputStream in = connection.getInputStream();
            String line = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            response = new StringBuffer("");
            while ((line = reader.readLine()) != null){
                response.append(line);
            }
            Log.i("----------->", response.toString());
            return response.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return response.toString();
    }

}
