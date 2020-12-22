package com.example.mvptwo.base;

public interface IPresenter<T> {
    void start();
    void start(T... t);
}