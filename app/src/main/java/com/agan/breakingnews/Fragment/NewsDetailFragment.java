package com.agan.breakingnews.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.agan.breakingnews.App;
import com.agan.breakingnews.FragmentTrans;
import com.agan.breakingnews.R;
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
    private Button sendComment;
    private ImageView commentPic;
    private int newsId;
    private String userName;
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
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
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
        sendComment = (Button) view.findViewById(R.id.sendComment_bt);
        commentPic = (ImageView) view.findViewById(R.id.commentPic);
        sendComment.setOnClickListener(this);
        commentPic.setOnClickListener(this);
        sendCommentProgress = new ProgressDialog(getActivity());
    }

    /**
     * 初始化数据
     */
    private void initData(){
        newsId = getArguments().getInt("newsid");
        newsDetailTitle.setText(getArguments().getString("title"));
        newsDetailContent.setText(getArguments().getString("detail"));
        String pic = getArguments().getString("pic");
        userName = App.getUserName();
        assert pic != null;
        if (!pic.equals("nil")){
            imageLoad = new ImageLoad();
            imageLoad.loadImageByTask(newsDetailPic, pic, true);
        }else {
            newsDetailPic.setImageResource(R.mipmap.agan);
        }
    }



    private void sendToComment(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                String response = HttpRequest.httpURLConnectionWithCommentSend(App.getBaseUrl() + App.getUrlCommentSend(),
                        newsId, userName, comment.getText().toString());
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
            case R.id.commentPic:
                if (getActivity() instanceof FragmentTrans){
                   ((FragmentTrans) getActivity()).toCommentFragment(newsId);
                }
                break;
        }
    }
}
