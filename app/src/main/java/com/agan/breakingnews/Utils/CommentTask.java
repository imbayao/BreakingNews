package com.agan.breakingnews.Utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import com.agan.breakingnews.Adapter.CommentAdapter;
import com.agan.breakingnews.Bean.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elso on 17-3-30.
 * 评论加载类
 */

public class CommentTask extends AsyncTask<String, Void, String> {

    private Context context;
    private ListView commentList;
    private ProgressDialog progressDialog;
    private int newsId;
    private List<Comment> commentData = new ArrayList<Comment>();


    public CommentTask(Context context, ListView commentList, ProgressDialog progressDialog, int newsId){
        this.context = context;
        this.commentList = commentList;
        this.progressDialog = progressDialog;
        this.newsId = newsId;
    }

    @Override
    protected String doInBackground(String... params) {
        return HttpRequest.httpURLConnectionWithCommentGet(params[0], newsId);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        commentData = JSONParsing.jsonParsingWithCommentGet(s);
        CommentAdapter adapter = new CommentAdapter(context, commentData);
        commentList.setAdapter(adapter);
        progressDialog.dismiss();
    }
}
