package com.example.day07_zuoye.callback;

public interface RxCallBack<T> {
    void onSuccess(T t);
    void onFiled(String msg);
}
