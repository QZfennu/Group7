package com.example.day14.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}
