package com.example.day07_zuoye.ui.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day07_zuoye.R;
import com.example.day07_zuoye.adapter.HomeFragRvAdapter;
import com.example.day07_zuoye.base.BaseFragment;
import com.example.day07_zuoye.base.BasePresenter;
import com.example.day07_zuoye.bean.PopularBean;
import com.example.day07_zuoye.mvp.net.Constants;
import com.example.day07_zuoye.mvp.presenter.HomeFragPresenter;
import com.example.day07_zuoye.ui.activity.LocationActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.tab_home_frag)
    LinearLayout tabHomeFrag;
    @BindView(R.id.tv_home_frag)
    TextView tvHomeFrag;
    @BindView(R.id.rv_home_frag)
    RecyclerView rvHomeFrag;
    @BindView(R.id.ll_home_frag1)
    LinearLayout llHomeFrag1;
    @BindView(R.id.ll_home_frag2)
    LinearLayout llHomeFrag2;
    @BindView(R.id.ll_home_frag3)
    LinearLayout llHomeFrag3;
    @BindView(R.id.ll_home_frag4)
    LinearLayout llHomeFrag4;
    @BindView(R.id.ll_home_frag5)
    LinearLayout llHomeFrag5;
    private HomeFragRvAdapter homeFragRvAdapter;

    @Override
    protected BasePresenter createPresenter() {
        return new HomeFragPresenter(this);
    }

    @Override
    protected void initData() {
        getmPresenter().start(Constants.POPULAR_URL);
    }

    @OnClick({R.id.ll_home_frag1,R.id.ll_home_frag2,R.id.ll_home_frag3,R.id.ll_home_frag4,R.id.ll_home_frag5})
    public void Click(View view){
        switch (view.getId()){
            case R.id.ll_home_frag1:
                break;
            case R.id.ll_home_frag2:
                break;
            case R.id.ll_home_frag3:
                break;
            case R.id.ll_home_frag4:
                    startActivity(new Intent(getActivity(), LocationActivity.class));
                break;
            case R.id.ll_home_frag5:
                break;
        }
    }

    @Override
    protected void init() {
        ArrayList<PopularBean.DataDTO> list = new ArrayList<>();
        homeFragRvAdapter = new HomeFragRvAdapter(list, getActivity());
        rvHomeFrag.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        rvHomeFrag.setAdapter(homeFragRvAdapter);
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof String) {
            String json = (String)o;

            PopularBean popularBean = new Gson().fromJson(json, PopularBean.class);
            List<PopularBean.DataDTO> data = popularBean.getData();
            homeFragRvAdapter.addData(data);
        }
    }

    @Override
    public void onFiled(String msg) {
        Log.i("TAG", "onFiled: " + msg);
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}
