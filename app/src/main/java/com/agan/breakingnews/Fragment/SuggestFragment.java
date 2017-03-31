package com.agan.breakingnews.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.agan.breakingnews.R;

/**
 * Created by elso on 17-3-31.
 * 意见反馈页面
 */

public class SuggestFragment extends Fragment implements View.OnClickListener{
    private View view;
    private Button sendSuggest;
    private EditText suggestContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_suggest, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        init();
        return view;
    }

    private void init(){
        sendSuggest = (Button) view.findViewById(R.id.sendSuggest_bt);
        suggestContent = (EditText) view.findViewById(R.id.suggestContent_et);
        sendSuggest.setOnClickListener(this);
    }

    private void sendEmail(){
        Intent data=new Intent(Intent.ACTION_SENDTO);
        data.setData(Uri.parse("mailto:284141786@qq.com"));
        data.putExtra(Intent.EXTRA_SUBJECT, "意见反馈");
        data.putExtra(Intent.EXTRA_TEXT, suggestContent.getText().toString());
        startActivity(data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sendSuggest_bt:
                sendEmail();
                break;
        }
    }
}
