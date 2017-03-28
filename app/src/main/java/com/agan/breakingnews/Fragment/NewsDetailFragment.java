package com.agan.breakingnews.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.agan.breakingnews.R;
import com.agan.breakingnews.Utils.ImageLoadTask;

/**
 * Created by elso on 17-3-20.
 * 新闻详细页面
 */

public class NewsDetailFragment extends Fragment {

    private View view;
    private TextView newsDetailTitle;
    private TextView newsDetailContent;
    private ImageView newsDetailPic;

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
    }

    /**
     * 初始化数据
     */
    private void initData(){
        newsDetailTitle.setText(getArguments().getString("title"));
        newsDetailContent.setText(getArguments().getString("detail"));
        String pic = getArguments().getString("pic");
        assert pic != null;
        if (!pic.equals("nil")){
            new ImageLoadTask(newsDetailPic).execute(pic);
        }else {
            newsDetailPic.setImageResource(R.mipmap.agan);
        }
    }

}
