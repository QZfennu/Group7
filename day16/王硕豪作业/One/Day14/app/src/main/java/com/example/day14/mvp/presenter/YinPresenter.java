package com.example.day14.mvp.presenter;

import com.example.day14.base.BasePresenter;
import com.example.day14.bean.ApiBean;
import com.example.day14.callback.RxCallback;
import com.example.day14.mvp.model.Model;
import com.example.day14.ui.activity.YinActivity;
import com.example.day14.utils.GsonUtils;

import java.util.HashMap;
import java.util.Map;

public class YinPresenter extends BasePresenter {
    private final Model mModel;
    private YinActivity view;

    public YinPresenter(YinActivity view) {
        this.view = view;
        mModel = new Model();
    }

    @Override
    public void start() {
        super.start();
        String url = "index";
        Map<String, String> map = new HashMap<>();
        map.put("device", "ios");
        mModel.resultpostData(url, map, new RxCallback() {
            @Override
            public void onSuccess(Object o) {
                String json = (String) o;
                ApiBean apiBean = GsonUtils.strgson(json, ApiBean.class);
                view.onSuccess(apiBean);
            }

            @Override
            public void onFiled(String msg) {
                view.onFiled(msg);
            }
        });
    }
}
