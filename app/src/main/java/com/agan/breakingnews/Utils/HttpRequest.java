package com.agan.breakingnews.Utils;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



/**
 * Created by elso on 17-3-24.
 * 网络请求工具类
 */

public class HttpRequest {

    /**
     * GET请求数据
     * @param address   请求地址
     * @return          获取json
     */
    public static String httpURLConnectionWithGet(String address){
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
}
