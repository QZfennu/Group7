package com.example.baidumap.mvp.callback;

public interface RxObserverCallBack<T> {
    void onSuccessData(T t);
    void onErrorMsg(String msg);
}