package com.agan.breakingnews.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agan.breakingnews.App;
import com.agan.breakingnews.R;
import com.agan.breakingnews.Utils.NewsTask;

/**
 * Created by elso on 17-3-17.
 * 国际新闻页面
 */

public class WorldNewsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener
{

    private View view;
    private RecyclerView worldList;
    private SwipeRefreshLayout worldSwipeRefresh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_worldnews, container, false);
        initView();
        return view;
    }

    /**
     * 初始化页面
     */
    private void initView(){
        worldSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.worldSwipeRefresh_srl);
        worldList = (RecyclerView) view.findViewById(R.id.worldList_rv);
        worldSwipeRefresh.setOnRefreshListener(this);
        new NewsTask(getActivity(), worldList, worldSwipeRefresh, 0).execute(App.getBaseUrl()+App.getUrlWorldNews());
    }

    /**
     * SwipeRefreshLayout刷新事件
     */
    @Override
    public void onRefresh() {
        new NewsTask(getActivity(), worldList, worldSwipeRefresh, 1).execute(App.getBaseUrl()+App.getUrlWorldNews());
    }
}
