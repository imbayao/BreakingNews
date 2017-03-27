package com.agan.breakingnews.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
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

public class DomesticNewsFragment extends Fragment {
    private View view;
    private RecyclerView domesticList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_domesticnews, container, false);
        initView();
        return view;
    }

    private void initView(){
        domesticList = (RecyclerView) view.findViewById(R.id.domesticList_rv);
//        new NewsTask(getActivity(), domesticList).execute(App.getBaseUrl()+App.getUrlNews());
    }
}
