package com.agan.breakingnews.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.agan.breakingnews.App;
import com.agan.breakingnews.R;
import com.agan.breakingnews.Utils.CommentTask;
import com.agan.breakingnews.Utils.HttpRequest;
import com.agan.breakingnews.Utils.ImageLoad;
import com.agan.breakingnews.Utils.JSONParsing;

import java.util.Map;

/**
 * Created by elso on 17-3-20.
 * 新闻详细页面
 */

public class NewsDetailFragment extends Fragment implements View.OnClickListener{

    private View view;
    private TextView newsDetailTitle;
    private TextView newsDetailContent;
    private ImageView newsDetailPic;
    private ImageLoad imageLoad;
    private EditText comment;
    private ListView commentList;
    private Button sendComment;
    private int newsId;
    private int userId;
    private ProgressDialog progressDialog;
    private ProgressDialog sendCommentProgress;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    sendCommentProgress.dismiss();
                    Toast.makeText(getActivity(), msg.obj.toString(), Toast.LENGTH_SHORT).show();
                    break;
                case 0:
                    sendCommentProgress.dismiss();
                    Toast.makeText(getActivity(), msg.obj.toString(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_newsdetail, container, false);
        initView();
        initData();
        return view;
    }

    /**
     * 初始化页面
     */
    private void initView(){
        newsDetailTitle = (TextView) view.findViewById(R.id.newsDetailTitle_tv);
        newsDetailContent = (TextView) view.findViewById(R.id.newsDetailContent_tv);
        newsDetailPic = (ImageView) view.findViewById(R.id.newsDetailPic_iv);
        comment = (EditText) view.findViewById(R.id.comment_et);
        commentList = (ListView) view.findViewById(R.id.comment_lv);
        sendComment = (Button) view.findViewById(R.id.sendComment_bt);
        sendComment.setOnClickListener(this);
        progressDialog = new ProgressDialog(getActivity());
        sendCommentProgress = new ProgressDialog(getActivity());
        progressDialog.show();
    }

    /**
     * 初始化数据
     */
    private void initData(){
        newsId = getArguments().getInt("newsId");
        newsDetailTitle.setText(getArguments().getString("title"));
        newsDetailContent.setText(getArguments().getString("detail"));
        String pic = getArguments().getString("pic");
        assert pic != null;
        if (!pic.equals("nil")){
            imageLoad = new ImageLoad();
            imageLoad.loadImageByTask(newsDetailPic, pic, true);
        }else {
            newsDetailPic.setImageResource(R.mipmap.agan);
        }
        loadComment();
    }

    private void loadComment(){
        new CommentTask(getActivity(), commentList, progressDialog, newsId)
                .execute(App.getBaseUrl() + App.getUrlCommentGet());
    }

    private void sendToComment(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                String response = HttpRequest.httpURLConnectionWithCommentSend(App.getBaseUrl() + App.getUrlCommentSend(),
                        newsId, userId, comment.getText().toString());
                Map<String, String> status = JSONParsing.jsonParsingWithCommentSend(response);
                if (status.get("biu").equals("1")){
                    message.what = 1;
                    message.obj = status.get("message");
                }else {
                    message.what = 0;
                    message.obj = status.get("message");
                }
                handler.sendMessage(message);
            }
        }).start();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sendComment_bt:
                sendCommentProgress.show();
                sendToComment();
                break;
        }
    }
}
