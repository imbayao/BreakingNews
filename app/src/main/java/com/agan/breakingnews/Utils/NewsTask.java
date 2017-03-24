package com.agan.breakingnews.Utils;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.agan.breakingnews.Adapter.NewsAdapter;
import com.agan.breakingnews.Bean.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elso on 17-3-24.
 * 新闻加载类
 */

public class NewsTask extends AsyncTask<String, Void, String> {

    private Context context;
    private List<News> newsData = new ArrayList<News>();
    private RecyclerView newsList;

    public NewsTask(Context context, RecyclerView newsList){
        this.context = context;
        this.newsList = newsList;
    }


    @Override
    protected String doInBackground(String... params) {

        return HttpRequest.httpURLConnectionWithGet(params[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s != null){
            newsData = JSONParsing.jsonParsingWithNews(s);
            newsList.addItemDecoration(new DividerItemDecoration(context, 1));
            newsList.setLayoutManager(new LinearLayoutManager(context));
            NewsAdapter newsAdapter = new NewsAdapter(context, newsData);
            newsList.setAdapter(newsAdapter);
        }
    }
}
