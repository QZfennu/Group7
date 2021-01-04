package com.example.day14.ui.fragment;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day14.R;
import com.example.day14.adapter.XueXiAdapter;
import com.example.day14.base.BaseFragment;
import com.example.day14.base.BasePresenter;
import com.example.day14.bean.XueXiBean;

import java.util.ArrayList;

import butterknife.BindView;

public class XueXiFragment extends BaseFragment {

    @BindView(R.id.rv_xue)
    RecyclerView rvXue;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void init() {
        XueXiAdapter xueXiAdapter = new XueXiAdapter(getList(),getActivity());
        rvXue.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvXue.setAdapter(xueXiAdapter);
        rvXue.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }

    private ArrayList<XueXiBean> getList() {
        ArrayList<XueXiBean> list = new ArrayList<>();
        list.add(new XueXiBean("我的课程",R.drawable.kecheng));
        list.add(new XueXiBean("我的直播",R.drawable.zhibo));
        list.add(new XueXiBean("学习记录",R.drawable.learn_nor));
        list.add(new XueXiBean("我的收藏",R.drawable.collection_icon));
        return list;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_xuexi;
    }
}
