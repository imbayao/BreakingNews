package com.agan.breakingnews.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agan.breakingnews.Adapter.FragmentAdapter;
import com.agan.breakingnews.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elso on 17-3-17.
 * 主界面Fragment
 */

public class MainFragment extends Fragment{

    private View view;
    private Toolbar title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        initView();
        initData();
        return view;
    }

    /**
     * 初始化界面
     */
    private void initView(){
        title = (Toolbar) view.findViewById(R.id.title_tb);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.switch_tl);
        ViewPager content = (ViewPager) view.findViewById(R.id.content_vp);

        title.setTitle("这里是title");

        List<Fragment> fragmentList = new ArrayList<Fragment>();
        SchoolNewsFragment schoolNewsFragment = new SchoolNewsFragment();
        DomesticNewsFragment domesticNewsFragment = new DomesticNewsFragment();
        InternationalNewsFragment internationalNewsFragment = new InternationalNewsFragment();
        SeeSomethingFragment seeSomethingFragment = new SeeSomethingFragment();
        fragmentList.add(schoolNewsFragment);
        fragmentList.add(domesticNewsFragment);
        fragmentList.add(internationalNewsFragment);
        fragmentList.add(seeSomethingFragment);
        FragmentAdapter adapter = new FragmentAdapter(getActivity().getSupportFragmentManager(), fragmentList);
        content.setAdapter(adapter);
        tabLayout.setupWithViewPager(content);
    }

    /**
     * 初始化数据
     */
    private void initData(){
    }

    private void initFragment(){

    }

}
