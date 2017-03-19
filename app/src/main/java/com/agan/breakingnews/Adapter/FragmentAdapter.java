package com.agan.breakingnews.Adapter;





import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by elso on 17-3-17.
 * fragment适配器
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    /**
     * 显示标题
     * @param position  标题位置
     * @return  nil
     */
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "校内新闻";
            case 1:
                return "国内新闻";
            case 2:
                return "国际新闻";
            case 3:
                return "随便看看";
        }
        return "nil";
    }
}
