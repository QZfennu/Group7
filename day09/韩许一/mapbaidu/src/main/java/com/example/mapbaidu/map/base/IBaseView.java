package com.example.mapbaidu.map.base;

public interface IBaseView<T> {
    void onScuccess(T t);
    void onError(String msg);
}