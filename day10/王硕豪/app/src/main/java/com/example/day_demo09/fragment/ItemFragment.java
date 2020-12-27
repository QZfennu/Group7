package com.example.day_demo09.fragment;

import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.day_demo09.R;
import com.example.day_demo09.adapter.BeanAdapter;
import com.example.day_demo09.base.BaseFragment;
import com.example.day_demo09.base.BasePresenter;
import com.example.day_demo09.bean.ItemBean;
import com.example.day_demo09.presenter.ItemPresenter;

import java.util.ArrayList;

import butterknife.BindView;


public class ItemFragment extends BaseFragment {


    @BindView(R.id.rec_item)
    RecyclerView recItem;
    private ArrayList<ItemBean.DataBean.ListBean> list;
    private BeanAdapter adapter;
    private int id ;


    @Override
    protected void init() {
        Bundle arguments = getArguments();
        id = arguments.getInt("id");

        createPresenter().start(id);
        Log.e("TAG","run:"+id);
    }

    @Override
    protected void initData() {
        recItem.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();
        adapter = new BeanAdapter(getContext(), list);

        recItem.setAdapter(adapter);
    }

    @Override
    protected BasePresenter createPresenter() {
        return new ItemPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_item;
    }

    @Override
    public void getData(Object o) {
        ItemBean itemBean = (ItemBean) o;
        list.addAll(itemBean.getData().getList());
        Log.e("TAG","run:"+list.size());
        adapter.notifyDataSetChanged();
    }
}