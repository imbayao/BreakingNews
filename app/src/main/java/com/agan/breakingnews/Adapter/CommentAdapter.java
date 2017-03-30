package com.agan.breakingnews.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.agan.breakingnews.Bean.Comment;
import com.agan.breakingnews.R;

import java.util.List;

/**
 * Created by elso on 17-3-30.
 * 评论适配器
 */

public class CommentAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<Comment> commentsData;

    public CommentAdapter(Context context, List<Comment> commentsData){
        this.layoutInflater = LayoutInflater.from(context);
        this.commentsData = commentsData;
    }

    @Override
    public int getCount() {
        return commentsData.size();
    }

    @Override
    public Object getItem(int position) {
        return commentsData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Comment data = commentsData.get(position);
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.comment_item, null);
            holder.commentUsername = (TextView) convertView.findViewById(R.id.commentUsername_tv);
            holder.commentContent = (TextView) convertView.findViewById(R.id.commentContent_tv);
            holder.commentTime = (TextView) convertView.findViewById(R.id.commentTime_tv);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.commentUsername.setText(data.getCommentUsername());
        holder.commentContent.setText(data.getCommentContent());
        holder.commentTime.setText(data.getCommentTime());
        return convertView;
    }

    class ViewHolder{
        TextView commentUsername;
        TextView commentContent;
        TextView commentTime;
    }
}
