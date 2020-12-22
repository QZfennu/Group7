package com.example.xiaoshixun_mvpchouqu_1.mvp.base;

public interface IPresenter<T> {
    void start();
    void start(T...t);
}
