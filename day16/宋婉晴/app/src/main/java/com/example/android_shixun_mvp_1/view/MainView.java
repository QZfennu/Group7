package com.example.android_shixun_mvp_1.view;

import com.example.android_shixun_mvp_1.bean.TabBean;

public interface MainView {
    void onSuccess(TabBean tabBean);
    void onFail(String file);
}
