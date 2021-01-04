package com.example.day15.mvp.presenter;

import com.example.day15.base.BasePresenter;
import com.example.day15.bean.HomeBannerBean;
import com.example.day15.bean.HomeRemenBean;
import com.example.day15.callback.RxCallback;
import com.example.day15.mvp.model.Model;
import com.example.day15.mvp.net.ApiConstants;
import com.example.day15.ui.fragment.TuiFragment;
import com.example.day15.utils.GsonUtils;

public class TuiPresenter extends BasePresenter {
    private final Model model;
    private TuiFragment tuiFragment;

    public TuiPresenter(TuiFragment tuiFragment) {
        this.tuiFragment = tuiFragment;
        model = new Model();
    }

    @Override
    public void start() {
        super.start();
        model.resultgetData(ApiConstants.HOME_TUI_BANNER, new RxCallback() {
            @Override
            public void onSuccess(Object o) {
                String json = (String) o;
                HomeBannerBean strgson = GsonUtils.strgson(json, HomeBannerBean.class);
                tuiFragment.onSuccess(strgson);
            }

            @Override
            public void onFiled(String msg) {
                tuiFragment.onFiled(msg);
            }
        });

        model.resultgetData(ApiConstants.HOME_TUI_REMEN, new RxCallback() {
            @Override
            public void onSuccess(Object o) {
                String json = (String) o;
                HomeRemenBean strgson = GsonUtils.strgson(json, HomeRemenBean.class);
                tuiFragment.onSuccess(strgson);
            }

            @Override
            public void onFiled(String msg) {
                tuiFragment.onFiled(msg);
            }
        });
    }
}
