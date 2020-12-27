package com.example.day_demo09.fragment;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day_demo09.R;
import com.example.day_demo09.activity.MyActivity;
import com.example.day_demo09.activity.PaiActivity;
import com.example.day_demo09.activity.PaoActivity;
import com.example.day_demo09.activity.PoiSugSearchDemo;
import com.example.day_demo09.activity.SheActivity;
import com.example.day_demo09.adapter.HomeAdapter;
import com.example.day_demo09.base.BaseFragment;
import com.example.day_demo09.base.BasePresenter;
import com.example.day_demo09.bean.HotBean;
import com.example.day_demo09.bean.TitleBean;
import com.example.day_demo09.presenter.HomePresenter;

import java.util.ArrayList;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {


    @BindView(R.id.rec_home)
    RecyclerView recHome;
    private ArrayList<TitleBean.DataBean> titleList;
    private ArrayList<HotBean.DataBean> hotList;
    private HomeAdapter adapter;

    @Override
    protected void init() {
        createPresenter().start(recHome);
    }

    @Override
    protected void initData() {
        hotList = new ArrayList<>();
        titleList = new ArrayList<>();

        recHome.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new HomeAdapter(getContext(), hotList, titleList,getActivity().getSupportFragmentManager());

        recHome.setAdapter(adapter);


        adapter.setOnClick(new HomeAdapter.OnClick() {
            @Override
            public void OnClickListener(int pos) {
                switch (pos) {
                    case 1:
                        startActivity(new Intent(getActivity(), PaoActivity.class));
                        Toast.makeText(getContext(), "袍子", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        startActivity(new Intent(getActivity(), SheActivity.class));
                        Toast.makeText(getContext(), "社区", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        startActivity(new Intent(getActivity(), PaiActivity.class));
                        Toast.makeText(getContext(), "排行榜", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        startActivity(new Intent(getActivity(), PoiSugSearchDemo.class));
                        Toast.makeText(getContext(), "搜索位置", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        startActivity(new Intent(getActivity(), MyActivity.class));
                        Toast.makeText(getContext(), "我的位置", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    protected BasePresenter createPresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    int ok = 0;

    @Override
    public void getData(Object o) {
        if (ok==0){
            HotBean hotBean = (HotBean) o;
            hotList.addAll(hotBean.getData());
            Log.e("TAG","hotBean:"+hotBean.toString());
            ok++;
        }else {
            TitleBean titleBean = (TitleBean) o;
            titleList.addAll(titleBean.getData());
            Log.e("TAG","titleBean:"+titleBean.toString());
        }
        adapter.notifyDataSetChanged();
    }
}