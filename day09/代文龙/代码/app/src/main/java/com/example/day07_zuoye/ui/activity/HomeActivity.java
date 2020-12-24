package com.example.day07_zuoye.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.day07_zuoye.R;
import com.example.day07_zuoye.adapter.HomeVpAdapter;
import com.example.day07_zuoye.base.BaseActivity;
import com.example.day07_zuoye.base.BasePresenter;
import com.example.day07_zuoye.ui.fragment.HomeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.vp_home_activity)
    ViewPager vpHomeActivity;
    @BindView(R.id.tab_home_activity)
    TabLayout tabHomeActivity;
    @BindView(R.id.tv_home_activity)
    TextView tvHomeActivity;
    private HomeVpAdapter homeVpAdapter;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("首页");
        strings.add("发现");
        strings.add("");
        strings.add("商城");
        strings.add("我的");
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());

        homeVpAdapter = new HomeVpAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments, strings);
        vpHomeActivity.setAdapter(homeVpAdapter);
        tabHomeActivity.setupWithViewPager(vpHomeActivity);
        for (int i = 0; i < tabHomeActivity.getTabCount(); i++) {
            tabHomeActivity.getTabAt(i).setIcon(R.drawable.select_tab);
        }

        tabHomeActivity.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tvHomeActivity.setText(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }
}
