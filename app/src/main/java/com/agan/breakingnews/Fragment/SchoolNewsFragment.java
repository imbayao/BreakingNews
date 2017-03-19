package com.agan.breakingnews.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.agan.breakingnews.Adapter.NewsAdapter;
import com.agan.breakingnews.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elso on 17-3-17.
 * 校内新闻页面
 */

public class SchoolNewsFragment extends Fragment {

    private View view;
    private List<String> testData = new ArrayList<String>();
    private NewsAdapter newsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_schoolnews, container, false);
        initData();
        initView();
        return view;
    }

    private void initView(){
        RecyclerView testList = (RecyclerView) view.findViewById(R.id.testList_lv);
        testList.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsAdapter = new NewsAdapter(getActivity(), testData);
        testList.setAdapter(newsAdapter);

    }

    private void initData(){
        getData();
    }

    private void getData(){
        for (int i = 0; i < 20; i++) {
            testData.add("第" + i + "项");
        }
    }

}
