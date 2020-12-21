package com.example.chaojiduodetu.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chaojiduodetu.R;
import com.google.android.material.tabs.TabLayout;

public class OneFragment extends Fragment {

    private TabLayout tAb;
    private TabLayout twotAb;
    private TabLayout rtAb;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {
        tAb = view.findViewById(R.id.tAb);
        twotAb = view.findViewById(R.id.twotAb);
        rtAb = view.findViewById(R.id.rtAb);
        tAb.addTab(tAb.newTab().setText("每日推荐").setIcon(R.mipmap.a));
        tAb.addTab(tAb.newTab().setText("飞花令").setIcon(R.mipmap.e));
        tAb.addTab(tAb.newTab().setText("诗歌社群").setIcon(R.mipmap.d));
        tAb.addTab(tAb.newTab().setText("排行榜").setIcon(R.mipmap.c));
        tAb.addTab(tAb.newTab().setText("会员专区").setIcon(R.mipmap.b));


        twotAb.addTab(twotAb.newTab().setText("每日推荐").setIcon(R.drawable.twoa));
        twotAb.addTab(twotAb.newTab().setText("飞花令").setIcon(R.drawable.twob));
        twotAb.addTab(twotAb.newTab().setText("诗歌社群").setIcon(R.drawable.twoc));
        twotAb.addTab(twotAb.newTab().setText("排行榜").setIcon(R.drawable.twod));
        twotAb.addTab(twotAb.newTab().setText("会员专区").setIcon(R.drawable.twoe));

        rtAb.addTab(rtAb.newTab().setText("每日推荐").setIcon(R.drawable.twoa));
        rtAb.addTab(rtAb.newTab().setText("飞花令").setIcon(R.drawable.twob));
        rtAb.addTab(rtAb.newTab().setText("诗歌社群").setIcon(R.drawable.twoc));
        rtAb.addTab(rtAb.newTab().setText("排行榜").setIcon(R.drawable.twod));
        rtAb.addTab(rtAb.newTab().setText("会员专区").setIcon(R.drawable.twoe));
    }
}