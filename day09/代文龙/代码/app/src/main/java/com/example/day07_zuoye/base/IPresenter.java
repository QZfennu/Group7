package com.example.day07_zuoye.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}
