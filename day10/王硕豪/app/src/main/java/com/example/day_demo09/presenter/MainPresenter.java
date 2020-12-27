package com.example.day_demo09.presenter;

import android.widget.FrameLayout;

import androidx.fragment.app.FragmentManager;

import com.example.day_demo09.R;
import com.example.day_demo09.activity.MainActivity;
import com.example.day_demo09.base.BasePresenter;
import com.example.day_demo09.fragment.BlankFragment;
import com.example.day_demo09.fragment.BlankFragment2;
import com.example.day_demo09.fragment.BlankFragment3;
import com.example.day_demo09.fragment.BlankFragment4;
import com.example.day_demo09.fragment.HomeFragment;
import com.google.android.material.tabs.TabLayout;

public class MainPresenter extends BasePresenter {
    private final MainActivity mainActivity;
    private BlankFragment blankFragment;
    private HomeFragment homeFragment;
    private BlankFragment2 blankFragment2;
    private BlankFragment3 blankFragment3;
    private BlankFragment4 blankFragment4;
    private FragmentManager fragmentManager;

    public MainPresenter(MainActivity mainActivity) {

        this.mainActivity = mainActivity;

    }

    @Override
    public void start(Object[] t) {
        super.start(t);
        TabLayout tabLayout = (TabLayout) t[0];
        FrameLayout frameLayout = (FrameLayout) t[1];


        blankFragment = new BlankFragment();
        homeFragment = new HomeFragment();
        blankFragment2 = new BlankFragment2();
        blankFragment3 = new BlankFragment3();
        blankFragment4 = new BlankFragment4();

        fragmentManager = mainActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fl_main, blankFragment)
                .add(R.id.fl_main, homeFragment)
                .add(R.id.fl_main, blankFragment2)
                .add(R.id.fl_main, blankFragment3)
                .add(R.id.fl_main, blankFragment4)
                .hide(blankFragment)
                .hide(homeFragment)
                .hide(blankFragment3)
                .hide(blankFragment4)
                .commit();

        tabLayout.addTab(tabLayout.newTab().setText("首页"));
        tabLayout.addTab(tabLayout.newTab().setText("发现"));
        tabLayout.addTab(tabLayout.newTab().setText("假装是图片"));
        tabLayout.addTab(tabLayout.newTab().setText("商城"));
        tabLayout.addTab(tabLayout.newTab().setText("我的"));

        tabLayout.getTabAt(2).select();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        fragmentManager.beginTransaction()
                                .show(blankFragment)
                                .hide(homeFragment)
                                .hide(blankFragment2)
                                .hide(blankFragment3)
                                .hide(blankFragment4)
                                .commit();
                        break;
                    case 1:
                        fragmentManager.beginTransaction()
                                .show(homeFragment)
                                .hide(blankFragment)
                                .hide(blankFragment2)
                                .hide(blankFragment3)
                                .hide(blankFragment4)
                                .commit();
                        break;
                    case 2:
                        fragmentManager.beginTransaction()
                                .show(blankFragment2)
                                .hide(homeFragment)
                                .hide(blankFragment)
                                .hide(blankFragment3)
                                .hide(blankFragment4)
                                .commit();
                        break;
                    case 3:
                        fragmentManager.beginTransaction()
                                .show(blankFragment3)
                                .hide(homeFragment)
                                .hide(blankFragment2)
                                .hide(blankFragment)
                                .hide(blankFragment4)
                                .commit();
                        break;
                    case 4:
                        fragmentManager.beginTransaction()
                                .show(blankFragment4)
                                .hide(homeFragment)
                                .hide(blankFragment2)
                                .hide(blankFragment3)
                                .hide(blankFragment)
                                .commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
