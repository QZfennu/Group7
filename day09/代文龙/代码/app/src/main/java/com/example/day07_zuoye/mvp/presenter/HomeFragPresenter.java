package com.example.day07_zuoye.mvp.presenter;

import android.util.Log;

import com.example.day07_zuoye.base.BasePresenter;
import com.example.day07_zuoye.callback.RxCallBack;
import com.example.day07_zuoye.mvp.model.HomeFragModel;
import com.example.day07_zuoye.ui.fragment.HomeFragment;

public class HomeFragPresenter extends BasePresenter {

    private final HomeFragModel homeFragModel;
    private HomeFragment homeFragment;

    public HomeFragPresenter(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
        homeFragModel = new HomeFragModel();
    }

    @Override
    public void start(Object[] t) {
        if (t[0] instanceof String){
            Log.i("TAG", "start: "+"开始请求数据");
            homeFragModel.resultgetData((String) t[0], new RxCallBack() {
                @Override
                public void onSuccess(Object o) {
                    homeFragment.onSuccess(o);
                }

                @Override
                public void onFiled(String msg) {
                    homeFragment.onFiled(msg);
                }
            });
        }
    }
}
