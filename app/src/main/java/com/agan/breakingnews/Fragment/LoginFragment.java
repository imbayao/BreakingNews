package com.agan.breakingnews.Fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.agan.breakingnews.App;
import com.agan.breakingnews.FragmentTrans;
import com.agan.breakingnews.R;
import com.agan.breakingnews.Utils.HttpRequest;
import com.agan.breakingnews.Utils.JSONParsing;

import java.util.Map;

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
    private ProgressDialog progressDialog;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    progressDialog.dismiss();
                    Toast.makeText(getActivity(), msg.obj.toString(), Toast.LENGTH_SHORT).show();
                    break;
                case 0:
                    progressDialog.dismiss();
                    Toast.makeText(getActivity(), msg.obj.toString(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

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
        progressDialog = new ProgressDialog(getActivity());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_bt:
                loginState();
                break;
            case R.id.register_tv:
                if (getActivity() instanceof FragmentTrans){
                    ((FragmentTrans) getActivity()).toRegisterFragment();
                }
                break;
        }
    }

    private void loginState(){
        if (username.getText().toString().equals("")){
            Toast.makeText(getActivity(), "请输入用户名", Toast.LENGTH_SHORT).show();
        }else if (password.getText().toString().equals("")){
            Toast.makeText(getActivity(), "请输入密码", Toast.LENGTH_SHORT).show();
        }else {
            progressDialog.show();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Message message = new Message();
                    String response = HttpRequest.httpURLConnectionWithUser(App.getBaseUrl() + App.getUrlLogin(),
                            username.getText().toString(), password.getText().toString());
                    Map<String, String> status = JSONParsing.jsonParsingWithUser(response);
                    if (status.get("biu").equals("1")){
                        message.what = 1;
                        message.obj = status.get("message");
                    }else {
                        message.what = 0;
                        message.obj = status.get("message");
                    }
                    handler.sendMessage(message);

                }
            }).start();
        }
    }
}
