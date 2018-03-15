package com.win.fragmentslip;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by Administrator on 2017/12/20 0020.
 * Fragment 视图管理适配器
 */

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public MyViewPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
        Log.e("TAG",list.size()+"");
    }
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
