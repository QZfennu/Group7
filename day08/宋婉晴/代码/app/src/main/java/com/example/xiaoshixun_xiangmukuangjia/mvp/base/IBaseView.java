package com.example.xiaoshixun_xiangmukuangjia.mvp.base;

public interface IBaseView<T> {
    void onScuccess(T t);
    void onError(String msg);
}