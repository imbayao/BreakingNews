package com.agan.breakingnews.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.agan.breakingnews.App;
import com.agan.breakingnews.R;

/**
 * Created by elso on 17-3-31.
 * 用户信息页面
 */

public class UserInfoFragment extends Fragment implements View.OnClickListener{

    private View view;
    private Button exit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_userinfo, container, false);
        init();
        return view;
    }

    private void init(){
        exit = (Button) view.findViewById(R.id.exit_bt);
        exit.setOnClickListener(this);
    }

    private void userExit(){
        App.setUserName("");
        FragmentManager fm = getFragmentManager();
        fm.popBackStack();
        Toast.makeText(getActivity(), "已退出", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exit_bt:
                userExit();
                break;
        }
    }
}
