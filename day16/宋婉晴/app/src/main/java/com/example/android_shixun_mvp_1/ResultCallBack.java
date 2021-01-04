package com.example.android_shixun_mvp_1;

public interface ResultCallBack<T> {
    void onSuccess(T t);
    void onFail(String file);
}
