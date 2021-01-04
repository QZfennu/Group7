package com.example.day15.ui.fragment;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day15.R;
import com.example.day15.base.BaseFragment;
import com.example.day15.base.BasePresenter;
import com.example.day15.bean.HomeBannerBean;
import com.example.day15.bean.HomeRemenBean;
import com.example.day15.mvp.adapter.HomeReMenAdapter;
import com.example.day15.mvp.presenter.TuiPresenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TuiFragment extends BaseFragment {
    @BindView(R.id.banner_tui)
    Banner bannerTui;
    @BindView(R.id.rv_tui1)
    RecyclerView rvTui1;

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(Object o) {
        super.onSuccess(o);
        if (o instanceof HomeBannerBean) {
            HomeBannerBean homeBannerBean = (HomeBannerBean) o;
            bannerTui.setImages(homeBannerBean.getData().getList())
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            HomeBannerBean.DataDTO.ListDTO listDTO = (HomeBannerBean.DataDTO.ListDTO) path;
                            Glide.with(context).load(listDTO.getBanner()).into(imageView);
                        }
                    }).start();
        }else if (o instanceof HomeRemenBean){
            HomeRemenBean homeRemenBean = (HomeRemenBean) o;
            List<HomeRemenBean.DataDTO> data = homeRemenBean.getData();
            HomeReMenAdapter homeReMenAdapter = new HomeReMenAdapter(getActivity(),data);
            rvTui1.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
            rvTui1.setAdapter(homeReMenAdapter);
        }
    }


    @Override
    public void onFiled(String msg) {
        super.onFiled(msg);
        Log.i("TAG", "onFiled: " + msg);
    }

    @Override
    protected void initView() {
        getmPresenter().start();
    }

    @Override
    protected BasePresenter createPresenter() {
        return new TuiPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tui;
    }
}
