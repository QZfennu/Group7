package com.example.day15.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}
