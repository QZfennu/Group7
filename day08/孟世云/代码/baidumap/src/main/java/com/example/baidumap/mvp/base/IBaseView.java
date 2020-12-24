package com.example.baidumap.mvp.base;

public interface IBaseView<T> {
    void onScuccess(T t);
    void onError(String msg);
}
