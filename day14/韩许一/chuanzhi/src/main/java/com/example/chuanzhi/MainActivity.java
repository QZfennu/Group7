package com.example.chuanzhi;

import android.os.Bundle;
import android.view.Menu;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbarMain;
    private RecyclerView mRecyMain;
    private TabLayout mTableMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mToolbarMain = findViewById(R.id.toolbar_main);
        mRecyMain = findViewById(R.id.recy_main);
        mTableMain = findViewById(R.id.table_main);
        setSupportActionBar(mToolbarMain);
        initToolbar();
        initRecy();
        initTable();
    }

    private void initTable() {
        mTableMain.addTab(mTableMain.newTab().setText("首页").setIcon(R.drawable.main_home));
        mTableMain.addTab(mTableMain.newTab().setText("选课").setIcon(R.drawable.main_home));
        mTableMain.addTab(mTableMain.newTab().setText("学习").setIcon(R.drawable.main_home));
        mTableMain.addTab(mTableMain.newTab().setText("我的").setIcon(R.drawable.main_home));
        mTableMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initRecy() {
        mRecyMain.setLayoutManager(new LinearLayoutManager(this));
        RecyAdapter recyAdapter = new RecyAdapter(this);
        mRecyMain.setAdapter(recyAdapter);
    }

    private void initToolbar() {
        mToolbarMain.setLogo(R.drawable.email);
        mToolbarMain.setTitle("基金从业");
        mToolbarMain.setTitleMargin(0,0,280,0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

}