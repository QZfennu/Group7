package com.example.day15.mvp.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class HomeFragmentAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> listFragment;
    private ArrayList<String> listString;

    public HomeFragmentAdapter(FragmentManager supportFragmentManager, int behaviorResumeOnlyCurrentFragment, ArrayList<Fragment> listFragment, ArrayList<String> listString) {
        super(supportFragmentManager, behaviorResumeOnlyCurrentFragment);
        this.listFragment = listFragment;
        this.listString = listString;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listString.get(position);
    }
}
