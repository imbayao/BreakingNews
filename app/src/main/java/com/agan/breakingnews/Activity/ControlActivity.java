package com.agan.breakingnews.Activity;


import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.agan.breakingnews.Fragment.AboutFragment;
import com.agan.breakingnews.Fragment.CommentFragment;
import com.agan.breakingnews.Fragment.LoginFragment;
import com.agan.breakingnews.Fragment.MainFragment;
import com.agan.breakingnews.Fragment.NewsDetailFragment;
import com.agan.breakingnews.Fragment.RegisterFragment;
import com.agan.breakingnews.Fragment.SuggestFragment;
import com.agan.breakingnews.Fragment.UserInfoFragment;
import com.agan.breakingnews.FragmentTrans;
import com.agan.breakingnews.R;
import com.agan.breakingnews.Utils.NightModeHelper;

public class ControlActivity extends AppCompatActivity implements FragmentTrans{

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        init();
    }

    /**
     * 初始化Fragment
     */
    private void init(){
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        MainFragment mainFragment = new MainFragment();
        transaction.replace(R.id.content, mainFragment);
        transaction.commit();
    }

    /**
     * 跳转登录页面
     */
    @Override
    public void toLoginFragment() {
        LoginFragment loginFragment = new LoginFragment();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.content, loginFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void toRegisterFragment() {
        RegisterFragment registerFragment = new RegisterFragment();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.content, registerFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /**
     * 跳转新闻详细页面
     * @param newsTitle     新闻标题
     * @param newsDetail    新闻正文
     * @param newsPic       新闻图片URL
     */
    @Override
    public void toNewsDetailFragment(String newsTitle, String newsDetail, String newsPic, int id) {
        NewsDetailFragment newsDetailFragment = new NewsDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", newsTitle);
        bundle.putString("detail", newsDetail);
        bundle.putString("pic", newsPic);
        bundle.putInt("newsid", id);
        newsDetailFragment.setArguments(bundle);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.content, newsDetailFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void toCommentFragment(int newsId) {
        CommentFragment commentFragment = new CommentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("newsid", newsId);
        commentFragment.setArguments(bundle);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.content, commentFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void toUserInfoFragment() {
        UserInfoFragment userInfoFragment = new UserInfoFragment();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.content, userInfoFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void toSuggestFragment() {
        SuggestFragment suggestFragment = new SuggestFragment();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.content, suggestFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void toAboutFragment() {
        AboutFragment aboutFragment = new AboutFragment();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.content, aboutFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
