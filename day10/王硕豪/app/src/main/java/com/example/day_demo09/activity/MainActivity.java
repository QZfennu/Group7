package com.example.day_demo09.activity;

import android.widget.FrameLayout;

import com.example.day_demo09.R;
import com.example.day_demo09.base.BaseActivity;
import com.example.day_demo09.base.BasePresenter;
import com.example.day_demo09.presenter.MainPresenter;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tab_main)
    TabLayout tabMain;
    @BindView(R.id.fl_main)
    FrameLayout flMain;

    @Override
    protected BasePresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void initData() {
        createPresenter().start(tabMain,flMain);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void getData(Object o) {

    }
}