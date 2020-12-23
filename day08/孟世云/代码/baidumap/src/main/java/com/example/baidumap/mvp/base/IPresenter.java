package com.example.baidumap.mvp.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}