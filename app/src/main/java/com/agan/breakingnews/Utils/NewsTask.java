package com.agan.breakingnews.Utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.agan.breakingnews.Activity.ControlActivity;
import com.agan.breakingnews.Adapter.NewsAdapter;
import com.agan.breakingnews.Bean.News;
import com.agan.breakingnews.FragmentTrans;

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
    private SwipeRefreshLayout swipeRefreshLayout;
    private int isRefresh;

    public NewsTask(Context context, RecyclerView newsList, SwipeRefreshLayout swipeRefreshLayout, int isRefresh){
        this.context = context;
        this.newsList = newsList;
        this.swipeRefreshLayout = swipeRefreshLayout;
        this.isRefresh = isRefresh;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        return HttpRequest.httpURLConnectionWithGet(params[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if (s != null){
            if (swipeRefreshLayout != null && isRefresh == 1){
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(context, "刷新完成", Toast.LENGTH_SHORT).show();
            }
            newsData = JSONParsing.jsonParsingWithNews(s);
            newsList.setLayoutManager(new LinearLayoutManager(context));
            NewsAdapter newsAdapter = new NewsAdapter(context, newsData);
            newsAdapter.notifyDataSetChanged();
            newsAdapter.setOnRecyclerItemClickListener(new NewsAdapter.OnRecyclerItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    if (context instanceof FragmentTrans){
                         ((FragmentTrans) context).toNewsDetailFragment(newsData.get(position).getNewsTitle(),
                                 newsData.get(position).getNewsDetail(), newsData.get(position).getNewsPic());
                    }
                }

                @Override
                public void onItemLongClick(View view, int position) {

                }
            });
            newsList.setAdapter(newsAdapter);
        }
    }
}
