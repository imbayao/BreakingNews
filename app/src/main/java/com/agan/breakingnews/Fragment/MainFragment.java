package com.agan.breakingnews.Fragment;

import android.app.UiModeManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.agan.breakingnews.Activity.ControlActivity;
import com.agan.breakingnews.Adapter.FragmentStateAdapter;
import com.agan.breakingnews.App;
import com.agan.breakingnews.FragmentTrans;
import com.agan.breakingnews.R;
import com.agan.breakingnews.Utils.NightModeHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elso on 17-3-17.
 * 主页面
 */

public class MainFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    private View view;
    private Toolbar title;
    private NavigationView navView;
    private DrawerLayout drawerlayout;
    private TabLayout tabLayout;
    private ViewPager content;
    private FloatingActionButton floatingActionButton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        initView();
        return view;
    }

    /**
     * 初始化界面
     */
    private void initView(){
        navView = (NavigationView) view.findViewById(R.id.nav_view);
        title = (Toolbar) view.findViewById(R.id.title_tb);
        drawerlayout = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        tabLayout = (TabLayout) view.findViewById(R.id.switch_tl);
        content = (ViewPager) view.findViewById(R.id.content_vp);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(this);
        navView.setNavigationItemSelectedListener(this);
        titleSetting();
        viewPagerSetting();
    }

    /**
     * toolbar的设置
     */
    private void titleSetting(){
        title.setTitle("新闻客户端");
        title.setNavigationIcon(R.mipmap.toobar_menu);
        title.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerlayout.openDrawer(GravityCompat.START);
            }
        });
    }

    /**
     * viewpager的设置
     */
    private void viewPagerSetting(){
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        SchoolNewsFragment schoolNewsFragment = new SchoolNewsFragment();
        DomesticNewsFragment domesticNewsFragment = new DomesticNewsFragment();
        WorldNewsFragment internationalNewsFragment = new WorldNewsFragment();
        SeeSomethingFragment seeSomethingFragment = new SeeSomethingFragment();
        fragmentList.add(schoolNewsFragment);
        fragmentList.add(domesticNewsFragment);
        fragmentList.add(internationalNewsFragment);
        fragmentList.add(seeSomethingFragment);
        FragmentStateAdapter adapter = new FragmentStateAdapter(getChildFragmentManager(), fragmentList);
        content.setAdapter(adapter);
        tabLayout.setupWithViewPager(content);
    }

    /**
     * 侧滑栏Item的点击事件
     * @param item  各个Item的ID
     * @return      false
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_userInfo:
                if (App.getUserName() == null || App.getUserName().equals("")){
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                    if (getActivity() instanceof FragmentTrans){
                        ((ControlActivity) getActivity()).toLoginFragment();
                    }
                }else {
                    if (getActivity() instanceof FragmentTrans) {
                        ((ControlActivity) getActivity()).toUserInfoFragment();
                    }
                }
                break;
            case R.id.nav_night:
                NightModeHelper nightModeHelper = new NightModeHelper(getActivity(), R.style.AppTheme);
                nightModeHelper.toggle();
                break;
            case R.id.nav_suggest:
                if(getActivity() instanceof FragmentTrans){
                    ((FragmentTrans) getActivity()).toSuggestFragment();
                }
                break;
            case R.id.nav_about:
                if(getActivity() instanceof FragmentTrans){
                    ((FragmentTrans) getActivity()).toAboutFragment();
                }
                break;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.floatingActionButton:
                Toast.makeText(getActivity(), "lalalala", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
