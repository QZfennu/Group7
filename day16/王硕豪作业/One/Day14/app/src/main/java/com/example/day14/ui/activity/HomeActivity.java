package com.example.day14.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.day14.R;
import com.example.day14.base.BaseActivity;
import com.example.day14.base.BasePresenter;
import com.example.day14.manager.GloadManager;
import com.example.day14.ui.fragment.ChooseFragment;
import com.example.day14.ui.fragment.HomeFragment;
import com.example.day14.ui.fragment.WoDeFragment;
import com.example.day14.ui.fragment.XueXiFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.tv_home_toolbar)
    TextView tvHomeToolbar;
    @BindView(R.id.toolbar_home)
    Toolbar toolbarHome;
    @BindView(R.id.fl_home)
    FrameLayout flHome;
    @BindView(R.id.bn)
    BottomNavigationView bn;
    @BindView(R.id.iv_home2)
    ImageView iv_home2;
    @BindView(R.id.iv_home3)
    ImageView iv_home3;
    private FragmentManager fragmentManager;
    private HomeFragment homeFragment;
    private ChooseFragment chooseFragment;
    private XueXiFragment xueXiFragment;
    private WoDeFragment woDeFragment;
    private boolean isMenuShow = true;
    private boolean isMenuShow2 = false;
    private String isTitle;

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG", "onResume: "+GloadManager.getmManager().getStr("data"));
        isTitle = GloadManager.getmManager().getStr("isTitle");
        tvHomeToolbar.setText(isTitle);
        String trim = tvHomeToolbar.getText().toString().trim();
        if (trim.isEmpty()) {
            Intent intent = new Intent(HomeActivity.this, XuanKeActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        toolbarHome.setTitle(" ");
        setSupportActionBar(toolbarHome);
        homeFragment = new HomeFragment();
        chooseFragment = new ChooseFragment();
        xueXiFragment = new XueXiFragment();
        woDeFragment = new WoDeFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_home, homeFragment).commit();
        bn.setItemIconTintList(null);
        initListener();
    }

    private void initListener() {
        bn.setOnNavigationItemSelectedListener(NavigationItemlistener);
    }

    @OnClick({R.id.iv_home2, R.id.iv_home3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_home2:
                bn.setSelectedItemId(R.id.item_layout_item2);
                break;
            case R.id.iv_home3:
                Toast.makeText(this, "资助", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public BottomNavigationView.OnNavigationItemSelectedListener NavigationItemlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            iv_home3.setImageResource(R.drawable.services);
            isMenuShow2 = false;
            switch (item.getItemId()) {
                case R.id.item_layout_item1:
                    initZhuang(Color.WHITE, View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    switchFragment(true, isTitle, homeFragment, View.VISIBLE, View.VISIBLE);
                    break;
                case R.id.item_layout_item2:
                    initZhuang(Color.WHITE, View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    switchFragment(false, item.getTitle().toString(), chooseFragment, View.GONE, View.GONE);
                    break;
                case R.id.item_layout_item3:
                    initZhuang(Color.WHITE, View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    switchFragment(true, "我的学习", xueXiFragment, View.GONE, View.VISIBLE);
                    break;
                case R.id.item_layout_item4:
                    initZhuang(Color.GRAY, View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    iv_home3.setImageResource(R.drawable.fenzu4);
                    isMenuShow2 = true;
                    switchFragment(true, item.getTitle().toString(), woDeFragment, View.GONE, View.VISIBLE);
                    break;
            }
            return true;
        }
    };

    private void initZhuang(int color1, int color2) {
        //添加状态栏的背景色
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏的背景色
        getWindow().setStatusBarColor(color1);
        //设置状态栏的文字为黑色
        getWindow().getDecorView().setSystemUiVisibility(color2);

        toolbarHome.setBackgroundColor(color1);
    }

    private void switchFragment(boolean isShow, String text, Fragment fragment, int isIv, int ShowIv) {
        iv_home2.setVisibility(isIv);
        iv_home3.setVisibility(ShowIv);
        isMenuShow = isShow;
        tvHomeToolbar.setText(text);
        fragmentManager.beginTransaction().replace(R.id.fl_home, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.select_options, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (isMenuShow && isMenuShow2) {
            menu.findItem(R.id.item_options2).setIcon(R.drawable.message_white_icon).setVisible(true);
            menu.findItem(R.id.item_options1).setVisible(false);
            menu.findItem(R.id.item_options3).setVisible(true);
        } else if (isMenuShow) {
            menu.findItem(R.id.item_options1).setVisible(isMenuShow);
            menu.findItem(R.id.item_options2).setVisible(isMenuShow);
            menu.findItem(R.id.item_options3).setVisible(false);
        } else {
            menu.findItem(R.id.item_options1).setVisible(isMenuShow);
            menu.findItem(R.id.item_options2).setVisible(isMenuShow);
            menu.findItem(R.id.item_options3).setVisible(false);
        }
        invalidateOptionsMenu();
        return super.onPrepareOptionsMenu(menu);
    }
}
