package com.example.mapbaidu.map.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}