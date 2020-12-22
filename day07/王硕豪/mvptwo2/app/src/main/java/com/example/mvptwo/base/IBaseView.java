package com.example.mvptwo.base;

public interface IBaseView<T> {
    void onScuccess(T t);
    void onError(String msg);
}