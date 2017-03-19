package com.agan.breakingnews.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.agan.breakingnews.R;

import java.util.List;

/**
 * Created by elso on 17-3-18.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    private List<String> testData;

    public NewsAdapter(Context context, List<String> testData){
        this.layoutInflater = LayoutInflater.from(context);
        this.testData = testData;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NewsViewHolder holder = new NewsViewHolder(layoutInflater.inflate(R.layout.schoolnews_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.textView.setText(testData.get(position));
    }

    @Override
    public int getItemCount() {
        return testData.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public NewsViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.id_num);
        }
    }
}
