package com.example.day05_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_main1;
    private RecyclerView rv_main2;
    private RecyclerView rv_main3;
    private RecyclerView rv_main4;
    private MainAdapter1 mainAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData1();
        initData2();
    }

    private void initData2() {
        Rv2Bean b1 = new Rv2Bean(R.drawable.b1, "写给秋天的诗", "秋风细雨，说一声，你好！一天的诗。从....", "作者：墨梅", "20人已读");
        Rv2Bean b2 = new Rv2Bean(R.drawable.b2, "写给秋天的诗", "秋风细雨，说一声，你好！一天的诗。从....", "作者：墨梅", "8人已读");
        Rv2Bean b3 = new Rv2Bean(R.drawable.b3, "写给秋天的诗", "秋风细雨，说一声，你好！一天的诗。从....", "作者：墨梅", "1人已读");
        ArrayList<Rv2Bean> list2 = new ArrayList<>();
        list2.add(b1);
        list2.add(b2);
        list2.add(b3);
        MainAdapter2 mainAdapter2 = new MainAdapter2(list2,this);
    }

    private void initData1() {
        Rv1Bean a1 = new Rv1Bean(R.drawable.a1, "seastar");
        Rv1Bean a2 = new Rv1Bean(R.drawable.a2, "风柒");
        Rv1Bean a3 = new Rv1Bean(R.drawable.a3, "青芷");
        Rv1Bean a4 = new Rv1Bean(R.drawable.a4, "花花娘子");
        Rv1Bean a5 = new Rv1Bean(R.drawable.a5, "斜日未冷");
        ArrayList<Rv1Bean> list1 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            list1.add(a1);
            list1.add(a2);
            list1.add(a3);
            list1.add(a4);
            list1.add(a5);
        }
        mainAdapter1 = new MainAdapter1(list1,this);
        rv_main1.setLayoutManager(new GridLayoutManager(this,5));
        rv_main1.setAdapter(mainAdapter1);
    }

    private void initView() {
        rv_main1 = (RecyclerView) findViewById(R.id.rv_main1);
        rv_main2 = (RecyclerView) findViewById(R.id.rv_main2);
        rv_main3 = (RecyclerView) findViewById(R.id.rv_main3);
        rv_main4 = (RecyclerView) findViewById(R.id.rv_main4);
    }
}
