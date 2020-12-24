package com.example.day07_zuoye.base;

public interface BaseView<T> {
    void onSuccess(T t);
    void onFiled(String msg);
}
