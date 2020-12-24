package com.example.xiaoshixun_xiangmukuangjia.mvp.mvp.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.baidu.mapapi.map.MapView;
import com.example.xiaoshixun_xiangmukuangjia.R;

public class BaiDuActivity extends AppCompatActivity {

    private MapView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_du);
        initView();
    }

    private void initView() {
        map = (MapView) findViewById(R.id.map);
    }
}
