package com.example.day_demo09.base;

public interface IBasePresenter<T> {
    void start();
    void start(T... t);
}
