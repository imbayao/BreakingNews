package com.agan.breakingnews.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agan.breakingnews.R;

/**
 * Created by elso on 17-3-17.
 * 随便看看页面
 */

public class SeeSomethingFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_seesomething, container, false);
        initView();
        return view;
    }

    private void initView(){

    }
}
