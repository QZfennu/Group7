package com.example.day15.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.day15.R;
import com.example.day15.base.BaseActivity;
import com.example.day15.base.BasePresenter;
import com.example.day15.ui.fragment.GuanFragment;
import com.example.day15.ui.fragment.HomeFragment;
import com.example.day15.ui.fragment.TuiFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.sv_activity_home)
    SearchView svActivityHome;
    @BindView(R.id.iv_activity_home)
    ImageView ivActivityHome;
    @BindView(R.id.fl_activity_home)
    FrameLayout flActivityHome;
    @BindView(R.id.bn_activity_home)
    BottomNavigationView bnActivityHome;
    private FragmentManager supportFragmentManager;
    private HomeFragment homeFragment;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        bnActivityHome.setItemIconTintList(null);
        homeFragment = new HomeFragment();
        supportFragmentManager = getSupportFragmentManager();
        switchFragment(homeFragment);
        initListener();
    }

    private void initListener() {
        bnActivityHome.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_home_home:
                        switchFragment(homeFragment);
                        break;
                    case R.id.item_home_comrade:
                        switchFragment(homeFragment);
                        break;
                    case R.id.item_home_add:
                        switchFragment(homeFragment);
                        break;
                    case R.id.item_home_mine:
                        switchFragment(homeFragment);
                        break;
                    case R.id.item_home_interact:
                        switchFragment(homeFragment);
                        break;
                }
                return true;
            }
        });
    }

    private void switchFragment(Fragment fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fl_activity_home,fragment)
                .commit();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }
}
