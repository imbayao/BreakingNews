package com.agan.breakingnews.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agan.breakingnews.App;
import com.agan.breakingnews.R;
import com.agan.breakingnews.Utils.NewsTask;

/**
 * Created by elso on 17-3-17.
 * 国内新闻页面
 */

public class DomesticNewsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    private View view;
    private RecyclerView domesticList;
    private SwipeRefreshLayout domesticSwipeRefresh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_domesticnews, container, false);
        initView();
        return view;
    }

    /**
     * 初始化页面
     */
    private void initView(){
        domesticList = (RecyclerView) view.findViewById(R.id.domesticList_rv);
        domesticSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.domesticSwipeRefresh_srl);
        domesticSwipeRefresh.setOnRefreshListener(this);
        new NewsTask(getActivity(), domesticList, domesticSwipeRefresh, 0).execute(App.getBaseUrl()+App.getUrlDomesticNews());
    }

    /**
     * SwipeRefreshLayout刷新事件
     */
    @Override
    public void onRefresh() {
        new NewsTask(getActivity(), domesticList, domesticSwipeRefresh, 1).execute(App.getBaseUrl()+App.getUrlDomesticNews());
    }
}
