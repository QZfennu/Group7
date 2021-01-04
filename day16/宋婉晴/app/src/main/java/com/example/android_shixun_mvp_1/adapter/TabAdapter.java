package com.example.android_shixun_mvp_1.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.android_shixun_mvp_1.bean.TabBean;
import com.example.android_shixun_mvp_1.fragment.ShouFragment;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentStatePagerAdapter {
    private List<TabBean.DataBean> data;
    private ArrayList<ShouFragment> fragments;

    public TabAdapter(@NonNull FragmentManager fm, List<TabBean.DataBean> data, ArrayList<ShouFragment> fragments) {
        super(fm);
        this.data = data;
        this.fragments = fragments;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position).getName();
    }
}
