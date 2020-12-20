package com.example.mengshiyun2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcy;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        rcy = (RecyclerView) findViewById(R.id.rcy);
        rcy.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Bean> beans = new ArrayList<>();
        beans.add(new Bean(R.drawable.aa,"张三"));
        beans.add(new Bean(R.drawable.bb,"张三"));
        beans.add(new Bean(R.drawable.cc,"张三"));
        beans.add(new Bean(R.drawable.dd,"张三"));
        beans.add(new Bean(R.drawable.ee,"张三"));
        beans.add(new Bean(R.drawable.aa,"张三"));
        beans.add(new Bean(R.drawable.bb,"张三"));
        beans.add(new Bean(R.drawable.cc,"张三"));
        beans.add(new Bean(R.drawable.dd,"张三"));
        beans.add(new Bean(R.drawable.ee,"张三"));
        MyAdapter myAdapter = new MyAdapter(this,beans);
        rcy.setAdapter(myAdapter);
        tab = (TabLayout) findViewById(R.id.tab);

    }
}
