package com.example.text_demoto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rey;
    private ImageView img;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        rey = (RecyclerView) findViewById(R.id.rey);
        img = (ImageView) findViewById(R.id.img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
            }
        });
        tab = (TabLayout) findViewById(R.id.tab);
        rey.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Bean> list = new ArrayList<>();
        list.add(new Bean("",R.drawable.c));
        list.add(new Bean("",R.drawable.c));
        list.add(new Bean("",R.drawable.c));
        list.add(new Bean("",R.drawable.c));
        ArrayList<Bean> beans = new ArrayList<>();
        beans.add(new Bean("大理",R.drawable.d));
        beans.add(new Bean("成都",R.drawable.d));
        beans.add(new Bean("杭州",R.drawable.d));
        beans.add(new Bean("上海",R.drawable.d));
        beans.add(new Bean("北京",R.drawable.d));
        HomeAdapter homeAdapter = new HomeAdapter(this, list, beans);
        rey.setAdapter(homeAdapter);
        tab.addTab(tab.newTab().setText("首页").setIcon(R.drawable.icon_home_pager_selected));
        tab.addTab(tab.newTab().setText("攻略").setIcon(R.drawable.icon_navigation_selected));
        tab.addTab(tab.newTab().setText("我的").setIcon(R.drawable.icon_me_selected));
    }


}