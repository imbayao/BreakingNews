package com.agan.breakingnews.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.agan.breakingnews.Bean.News;
import com.agan.breakingnews.FragmentTrans;
import com.agan.breakingnews.R;
import com.agan.breakingnews.Utils.HttpRequest;

import java.util.List;

/**
 * Created by elso on 17-3-24.
 * 登录页面
 */

public class LoginFragment extends Fragment implements View.OnClickListener{

    private View view;
    private EditText username;
    private EditText password;
    private Button login;
    private TextView register;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        initView();
        return view;
    }

    private void initView(){
        username = (EditText) view.findViewById(R.id.username_et);
        password = (EditText) view.findViewById(R.id.password_et);
        register = (TextView) view.findViewById(R.id.register_tv);
        login = (Button) view.findViewById(R.id.login_bt);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_bt:

                break;
            case R.id.register_tv:
                if (getActivity() instanceof FragmentTrans){
                    ((FragmentTrans) getActivity()).toRegisterFragment();
                }
                break;
        }
    }
}
