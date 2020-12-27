package com.example.day_demo09.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IBaseView<T>,T> implements IBasePresenter<T> {

    private WeakReference<V> mView;

    // 1.用弱引用修饰V层 方便GC回收  2.P层关联V层
    protected void attachView(V view) {
        mView = new WeakReference<V>(view);
    }

    @Override
    public void start() {

    }

    @Override
    public void start(T... t) {

    }
}
