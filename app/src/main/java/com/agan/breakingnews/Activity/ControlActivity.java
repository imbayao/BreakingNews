package com.agan.breakingnews.Activity;

import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.agan.breakingnews.Fragment.MainFragment;
import com.agan.breakingnews.R;

public class ControlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        init();

    }

    private void init(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        MainFragment mainFragment = new MainFragment();
        transaction.replace(R.id.content, mainFragment);
        transaction.commit();
    }
}
