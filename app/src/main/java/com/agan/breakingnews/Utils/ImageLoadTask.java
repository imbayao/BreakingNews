package com.agan.breakingnews.Utils;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.agan.breakingnews.R;

/**
 * Created by elso on 17-3-25.
 * 图片加载类
 */

public class ImageLoadTask extends AsyncTask<String, Void, Bitmap> {

    private ImageView imageView;


    public ImageLoadTask(ImageView imageView){
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        return HttpRequest.httpURLConnectionWithBitmap(params[0]);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);

    }
}
