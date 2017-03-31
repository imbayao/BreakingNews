package com.agan.breakingnews.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.agan.breakingnews.App;
import com.agan.breakingnews.R;
import com.agan.breakingnews.Utils.HttpRequest;
import com.agan.breakingnews.Utils.JSONParsing;

import java.util.Map;


/**
 * Created by elso on 17-3-29.
 * 注册页面
 */

public class RegisterFragment extends Fragment implements View.OnClickListener{

    private View view;
    private Button register;
    private EditText username;
    private EditText password;
    private ProgressDialog progressDialog;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    if (progressDialog != null){
                        progressDialog.dismiss();
                    }
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
        view = inflater.inflate(R.layout.fragment_register, container, false);
        init();
        return view;
    }

    private void init(){
        register = (Button) view.findViewById(R.id.register_bt);
        username = (EditText) view.findViewById(R.id.username_register_et);
        password = (EditText) view.findViewById(R.id.password_register_et);
        progressDialog = new ProgressDialog(getActivity());
        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_bt:
                //progressDialog.show();
                registerState();
                break;
        }
    }

    private void registerState(){
        if (username.getText().toString().equals("")){
            Toast.makeText(getActivity(), "请输入用户名", Toast.LENGTH_SHORT).show();
        }else if (password.getText().toString().equals("")){
            Toast.makeText(getActivity(), "请输入密码", Toast.LENGTH_SHORT).show();
        }else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Message message = new Message();
                    String response = HttpRequest.httpURLConnectionWithUser(App.getBaseUrl() + App.getUrlRegister(),
                            username.getText().toString(), password.getText().toString());
                    Map<String, String> status = JSONParsing.jsonParsingWithUser(response);
                    if (status.get("biu").equals("2")){
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
