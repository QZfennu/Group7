package com.example.day15.base;

import java.lang.ref.WeakReference;

public class BasePresenter<V extends BaseView, T> implements IPresenter<T> {

    private WeakReference<V> mView;

    protected void attachView(V view) {
        mView = new WeakReference<V>(view);
    }

    protected void detachView() {
        if (mView != null) {
            mView.clear();
            mView = null;
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void start(T... t) {

    }
}
