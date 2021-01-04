package com.example.android_shixun_mvp_1.presenter;

import com.example.android_shixun_mvp_1.ResultCallBack;
import com.example.android_shixun_mvp_1.bean.TabBean;
import com.example.android_shixun_mvp_1.fragment.TabFragment;
import com.example.android_shixun_mvp_1.model.MainModel;
import com.example.android_shixun_mvp_1.view.MainView;

public class MainPresenter {
    private MainView view;
    private final MainModel model;

    public MainPresenter(MainView view) {
        this.view = view;
        model = new MainModel();
    }


    public void getData() {
        model.setData(new ResultCallBack<TabBean>() {
            @Override
            public void onSuccess(TabBean tabBean) {
                view.onSuccess(tabBean);
            }

            @Override
            public void onFail(String file) {
                view.onFail(file);
            }
        });
    }
}
