package com.example.zhao.geeknewss.adapters.gankadapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class V_Adapter extends FragmentStatePagerAdapter {
    private List<Fragment> fs;
    private List<String> title;
    public V_Adapter(FragmentManager fm, List<Fragment> fs, List<String> title) {
        super(fm);
        this.fs = fs;
        this.title = title;
    }


    @Override
    public Fragment getItem(int position) {
        return fs.get(position);
    }

    @Override
    public int getCount() {
        return fs.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
