package com.example.xiaoshixun_mvpchouqu_1.mvp.base;

public interface IBaseView<T> {
    void onSuccess(T t);
    void onError(String msg);
}
