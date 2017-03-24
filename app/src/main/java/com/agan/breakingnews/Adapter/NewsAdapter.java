package com.agan.breakingnews.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.agan.breakingnews.Bean.News;
import com.agan.breakingnews.R;
import com.agan.breakingnews.Utils.ImageLoadTask;

import java.util.List;

/**
 * Created by elso on 17-3-18.
 * 新闻适配器
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private LayoutInflater layoutInflater;
    private List<News> newsData;

    private OnRecyclerItemClickListener onRecyclerItemClickListener;

    public NewsAdapter(Context context, List<News> newsData){
        this.layoutInflater = LayoutInflater.from(context);
        this.newsData = newsData;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NewsViewHolder holder = new NewsViewHolder(layoutInflater.inflate(R.layout.news_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final NewsViewHolder holder, int position) {
        new ImageLoadTask(holder.newsPic).execute(newsData.get(position).getNewsPic());
        holder.newsTitle.setText(newsData.get(position).getNewsTitle());
        holder.newsTime.setText(newsData.get(position).getNewsTime());

        if (onRecyclerItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    onRecyclerItemClickListener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    onRecyclerItemClickListener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return newsData.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{

        ImageView newsPic;
        TextView newsTitle;
        TextView newsTime;

        public NewsViewHolder(View itemView) {
            super(itemView);
            newsPic = (ImageView) itemView.findViewById(R.id.newsPic_iv);
            newsTitle = (TextView) itemView.findViewById(R.id.newsTitle_tv);
            newsTime = (TextView) itemView.findViewById(R.id.newsTime_tv);
        }
    }

    public interface OnRecyclerItemClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener onRecyclerItemClickListener){
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    }
}
