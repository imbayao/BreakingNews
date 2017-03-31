package com.agan.breakingnews;

/**
 * Created by elso on 17-3-24
 * Fragment跳转接口类
 */

public interface FragmentTrans {

    /**
     * 跳转LoginFragment接口
     */
    void toLoginFragment();

    void toRegisterFragment();

    /**
     * 跳转NewsDetailFragment接口
     * @param newsTitle     新闻标题
     * @param newsDetail    新闻正文
     * @param newsPic       新闻图片URL
     */
    void toNewsDetailFragment(String newsTitle, String newsDetail, String newsPic, int id);

    void toCommentFragment(int newsId);

    void toUserInfoFragment();

    void toSuggestFragment();

    void toAboutFragment();
}
