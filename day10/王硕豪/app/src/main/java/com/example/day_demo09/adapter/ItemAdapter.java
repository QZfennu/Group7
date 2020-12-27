package com.example.day_demo09.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ItemAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> list;
    private ArrayList<String> title;

    public ItemAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> list, ArrayList<String> title) {
        super(fm);
        this.list = list;
        this.title = title;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
