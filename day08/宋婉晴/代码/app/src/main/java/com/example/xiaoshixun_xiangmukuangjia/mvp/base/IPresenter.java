package com.example.xiaoshixun_xiangmukuangjia.mvp.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}