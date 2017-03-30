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
import com.agan.breakingnews.Utils.ImageLoad;
import com.agan.breakingnews.Utils.StringUtil;

import java.util.List;

/**
 * Created by elso on 17-3-18.
 * 新闻适配器
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{

    private LayoutInflater layoutInflater;
    private List<News> newsData;
    private OnRecyclerItemClickListener onRecyclerItemClickListener;
    private ImageLoad imageLoad;

    public NewsAdapter(Context context, List<News> newsData){
        this.layoutInflater = LayoutInflater.from(context);
        this.newsData = newsData;
        imageLoad = new ImageLoad();
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NewsViewHolder holder = new NewsViewHolder(layoutInflater.inflate(R.layout.news_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final NewsViewHolder holder, int position) {

        holder.newsPic.setTag(newsData.get(position).getNewsPic());
        if (!isSchoolPic(newsData.get(position).getNewsKindId())){
            imageLoad.loadImageByTask(holder.newsPic, newsData.get(position).getNewsPic(), false);
        }
//        if (!isPicNil(newsData.get(position).getNewsPic())){
//            showImageByTask(holder.newsPic, newsData.get(position).getNewsPic());
//        }
        holder.newsTitle.setText(newsData.get(position).getNewsTitle());
        holder.newsTime.setText(StringUtil.newsTimeToMonthDay(newsData.get(position).getNewsTime()));

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

    /**
     * RecyclerView点击接口
     */
    public interface OnRecyclerItemClickListener{
        void onItemClick(View view, int position);      //单次点击
        void onItemLongClick(View view, int position);  //长按点击
    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener onRecyclerItemClickListener){
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    /**
     * 判断图片地址是否为空
     * @param url   图片地址
     * @return      true 为空
     *              false 不为空
     */
    private boolean isPicNil(String url){
        if (url.equals("nil")){
            return true;
        }else {
            return false;
        }
    }

    private boolean isSchoolPic(int newsKindId){
        if (newsKindId == 1){
            return true;
        }else {
            return false;
        }
    }
}
