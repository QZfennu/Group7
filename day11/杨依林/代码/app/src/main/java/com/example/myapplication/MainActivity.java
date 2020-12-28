package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_hai;
    private RecyclerView rv_guo;
    private HaiAdapter haiAdapter;
    private List<Integer> list;
    private Banner banner_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        list.add(R.drawable.hw);
        list.add(R.drawable.hw);
        list.add(R.drawable.hw);
        list.add(R.drawable.hw);
    }

    private void initView() {
        rv_hai = (RecyclerView) findViewById(R.id.rv_hai);
        rv_hai.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        list = new ArrayList<>();
        haiAdapter = new HaiAdapter(this, list);
        rv_hai.setAdapter(haiAdapter);
        rv_guo = (RecyclerView) findViewById(R.id.rv_guo);
        rv_guo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_guo.setAdapter(haiAdapter);
        banner_main = (Banner) findViewById(R.id.banner_main);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(R.drawable.lbt);
        }
        banner_main.setImages(list)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(path).into(imageView);
                    }
                }).start();
    }
}