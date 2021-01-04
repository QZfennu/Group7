package com.example.day14.callback;

public interface RxCallback<T> {
    void onSuccess(T t);
    void onFiled(String msg);
}
