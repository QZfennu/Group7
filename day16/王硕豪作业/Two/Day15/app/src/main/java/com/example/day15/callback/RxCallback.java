package com.example.day15.callback;

public interface RxCallback<T> {
    void onSuccess(T t);
    void onFiled(String msg);
}
