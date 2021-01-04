package com.example.day15.base;

public interface BaseView<T> {
    void onSuccess(T t);
    void onFiled(String msg);
}
