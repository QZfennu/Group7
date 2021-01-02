package com.example.day14.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.day14.R;
import com.example.day14.base.BaseActivity;
import com.example.day14.ui.fragment.ChooseFragment;
import com.example.day14.ui.fragment.ChooseFragment_ViewBinding;
import com.example.day14.ui.fragment.HomeFragment;
import com.example.day14.ui.fragment.WoDeFragment;
import com.example.day14.ui.fragment.XueXiFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.tv_home_toolbar)
    TextView tvHomeToolbar;
    @BindView(R.id.toolbar_home)
    Toolbar toolbarHome;
    @BindView(R.id.vp_home)
    ViewPager vpHome;
    @BindView(R.id.tab_home)
    TabLayout tabHome;
    private static String text;

    public static void setText(String msg) {
        text = msg;
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvHomeToolbar.setText(text);
        String trim = tvHomeToolbar.getText().toString().trim();
        Log.i("TAG", "onResume: " + trim);
        if (trim.isEmpty()) {
            Intent intent = new Intent(HomeActivity.this, XuanKeActivity.class);
            startActivity(intent);
            tvHomeToolbar.setText("基金从业");
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        toolbarHome.setTitle(" ");
        setSupportActionBar(toolbarHome);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new ChooseFragment());
        fragments.add(new XueXiFragment());
        fragments.add(new WoDeFragment());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("首页");
        strings.add("选课");
        strings.add("学习");
        strings.add("我的");

        HomeAdapter homeAdapter = new HomeAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments, strings);
        vpHome.setAdapter(homeAdapter);
        tabHome.setupWithViewPager(vpHome);
        tabHome.getTabAt(0).setIcon(R.drawable.select_shouye);
        tabHome.getTabAt(1).setIcon(R.drawable.select_xuanke);
        tabHome.getTabAt(2).setIcon(R.drawable.select_xuexi);
        tabHome.getTabAt(3).setIcon(R.drawable.select_wode);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.select_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
