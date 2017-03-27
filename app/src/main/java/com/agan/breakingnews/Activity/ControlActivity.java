package com.agan.breakingnews.Activity;

import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.agan.breakingnews.Fragment.LoginFragment;
import com.agan.breakingnews.Fragment.MainFragment;
import com.agan.breakingnews.Fragment.NewsDetailFragment;
import com.agan.breakingnews.FragmentTrans;
import com.agan.breakingnews.R;

public class ControlActivity extends AppCompatActivity implements FragmentTrans{

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        init();

    }

    private void init(){
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        MainFragment mainFragment = new MainFragment();
        transaction.replace(R.id.content, mainFragment);
        transaction.commit();
    }

    @Override
    public void toLoginFragment() {
        LoginFragment loginFragment = new LoginFragment();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.content, loginFragment, "login");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void toNewsDetailFragment(String newsTitle, String newsDetail, String newsPic) {
        NewsDetailFragment newsDetailFragment = new NewsDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", newsTitle);
        bundle.putString("detail", newsDetail);
        bundle.putString("pic", newsPic);
        newsDetailFragment.setArguments(bundle);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.content, newsDetailFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
