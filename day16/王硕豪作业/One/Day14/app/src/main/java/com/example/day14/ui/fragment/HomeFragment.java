package com.example.day14.ui.fragment;

import android.content.Context;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day14.R;
import com.example.day14.adapter.Home1Adapter;
import com.example.day14.adapter.Home2Adapter;
import com.example.day14.base.BaseFragment;
import com.example.day14.base.BasePresenter;
import com.example.day14.bean.Rv2Bean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {
    @BindView(R.id.banner_home)
    Banner bannerHome;
    @BindView(R.id.rv_home1)
    RecyclerView rvHome1;
    @BindView(R.id.rv_home2)
    RecyclerView rvHome2;
    @BindView(R.id.rv_home3)
    RecyclerView rvHome3;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        initData1();
        initData2();
    }

    private void initData2() {
        ArrayList<Rv2Bean> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(new Rv2Bean(R.drawable.fengmian,
                    "股权投资基金基础知识（至尊VIP密训班）",
                    "备考导学，基础学习，系统精讲",
                    "6800 6800",
                    R.drawable.xiaofang,
                    "免费试学",
                    "5132人已购买"));
        }
        Home2Adapter home2Adapter = new Home2Adapter(list,getActivity());
        rvHome2.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvHome2.setAdapter(home2Adapter);
    }

    private void initData1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.bannera);
        list.add(R.drawable.bannerb);
        Home1Adapter home1Adapter = new Home1Adapter(getActivity(), list);
        rvHome1.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        rvHome1.setAdapter(home1Adapter);
    }

    @Override
    protected void init() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(R.drawable.itmap);
        }
        bannerHome.setImages(list)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(path).into(imageView);
                    }
                }).start();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}
