package com.agan.breakingnews.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class SchoolNewsFragment extends Fragment implements NewsAdapter.OnRecyclerItemClickListener{

    private View view;

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
        RecyclerView newsList = (RecyclerView) view.findViewById(R.id.testList_lv);
        new NewsTask(getActivity(), newsList).execute(App.getBaseUrl()+App.getUrlNews());
    }


    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}
