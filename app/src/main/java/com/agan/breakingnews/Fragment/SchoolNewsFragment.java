package com.agan.breakingnews.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.agan.breakingnews.Adapter.NewsAdapter;
import com.agan.breakingnews.App;
import com.agan.breakingnews.R;
import com.agan.breakingnews.Utils.NewsTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elso on 17-3-17.
 * 校内新闻页面
 */

public class SchoolNewsFragment extends Fragment implements  SwipeRefreshLayout.OnRefreshListener{

    private View view;
    private RecyclerView schoolList;
    private SwipeRefreshLayout schoolSwipeRefresh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_schoolnews, container, false);
        init();


        return view;
    }

    /**
     * 初始化
     */
    private void init(){
        schoolSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.schoolSwipeRefresh_srl);
        schoolList = (RecyclerView) view.findViewById(R.id.schoolList_rv);
        schoolSwipeRefresh.setOnRefreshListener(this);
        new NewsTask(getActivity(), schoolList, schoolSwipeRefresh, 0).execute(App.getBaseUrl()+App.getUrlNews());
    }

    @Override
    public void onRefresh() {
        new NewsTask(getActivity(), schoolList, schoolSwipeRefresh, 1).execute(App.getBaseUrl()+App.getUrlNews());
    }

}
