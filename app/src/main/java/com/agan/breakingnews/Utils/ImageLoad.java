package com.agan.breakingnews.Utils;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

/**
 * Created by elso on 17-3-30.
 * 图片加载类
 */

public class ImageLoad {

    private LruCache<String, Bitmap> lruCache;

    public ImageLoad(){
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 2;
        lruCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };
    }

    public void loadImageByTask(ImageView imageView, String url, boolean isDetail){
        if (isDetail){
            new ImageLoadTask(imageView, url, isDetail).execute(url);
        }else {
            Bitmap bitmap = getBitmapFromCache(url);
            if (bitmap == null){
                new ImageLoadTask(imageView, url, isDetail).execute(url);
            }else {
                imageView.setImageBitmap(bitmap);
            }
        }

    }


    public void addBitmapToCache(String url, Bitmap bitmap){
        if (getBitmapFromCache(url) == null){
            lruCache.put(url, bitmap);
        }

    }

    public Bitmap getBitmapFromCache(String url){
        return lruCache.get(url);
    }


    private class ImageLoadTask extends AsyncTask<String, Void, Bitmap>{

        private ImageView imageView;
        private String url;
        private boolean isDetail;

        public ImageLoadTask(ImageView imageView, String url, boolean isDetail){
            this.imageView = imageView;
            this.url = url;
            this.isDetail = isDetail;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = HttpRequest.httpURLConnectionWithBitmap(params[0]);
            if (bitmap != null){
                addBitmapToCache(params[0], bitmap);
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (isDetail){
                imageView.setImageBitmap(bitmap);
            }else {
                if (imageView.getTag().equals(url)){
                    Log.i("------------>", url);
                    imageView.setImageBitmap(bitmap);
                }
            }
        }
    }
}
