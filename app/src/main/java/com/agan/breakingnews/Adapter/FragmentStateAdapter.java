package com.agan.breakingnews.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by elso on 17-3-27.
 * viewpager适配器
 */

public class FragmentStateAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;

    public FragmentStateAdapter(FragmentManager fm, List<Fragment> fragmentList) {
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

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    /**
     * 显示标题
     * @param position  标题位置
     * @return          nil
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
