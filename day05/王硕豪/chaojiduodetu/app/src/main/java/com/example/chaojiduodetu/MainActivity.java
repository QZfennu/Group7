package com.example.chaojiduodetu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.chaojiduodetu.fragment.FiveFragment;
import com.example.chaojiduodetu.fragment.FreeFragment;
import com.example.chaojiduodetu.fragment.OneFragment;
import com.example.chaojiduodetu.fragment.ThreeFragment;
import com.example.chaojiduodetu.fragment.TwoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTab;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.mVp);
        mTab = (TabLayout) findViewById(R.id.mTab);

        fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());
        fragments.add(new FiveFragment());
        fragments.add(new FreeFragment());
        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("首页").setIcon(R.mipmap.icon_tab_home);
        mTab.getTabAt(1).setText("写诗").setIcon(R.mipmap.icon_tab_sofa);
        mTab.getTabAt(2).setText("传图").setIcon(R.mipmap.icon_tab_publish);
        mTab.getTabAt(3).setText("作品").setIcon(R.mipmap.icon_tab_movie);
        mTab.getTabAt(4).setText("我的").setIcon(R.mipmap.icon_tab_mine);
    }
}