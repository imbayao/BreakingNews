package com.agan.breakingnews;

import com.agan.breakingnews.Bean.News;

import java.util.List;

/**
 * Created by elso on 17-3-24
 * Fragment跳转接口类
 */

public interface FragmentTrans {

    /**
     * 跳转LoginFragment接口
     */
    void toLoginFragment();

    void toNewsDetailFragment(String newsTitle, String newsDetail, String newsPic);
}
