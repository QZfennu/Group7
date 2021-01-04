package com.example.day14.base;

public interface BaseView<T> {
    void onSuccess(T t);
    void onFiled(String msg);
}
