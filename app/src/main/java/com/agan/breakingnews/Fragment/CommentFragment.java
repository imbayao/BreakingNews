package com.agan.breakingnews.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.agan.breakingnews.App;
import com.agan.breakingnews.R;
import com.agan.breakingnews.Utils.CommentTask;

/**
 * Created by elso on 17-3-31.
 */

public class CommentFragment extends Fragment {

    private View view;
    private ListView commentList;
    private int newsId;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_comment, container, false);
        init();
        return view;
    }

    private void init(){
        newsId = getArguments().getInt("newsid");
        commentList = (ListView) view.findViewById(R.id.newsDetailComment_lv);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.show();
        loadComment();
    }

    private void loadComment(){
        new CommentTask(getActivity(), commentList, progressDialog, newsId).execute(App.getBaseUrl() + App.getUrlCommentGet());
    }
}
