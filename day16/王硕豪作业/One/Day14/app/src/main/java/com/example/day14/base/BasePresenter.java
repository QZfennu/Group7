package com.example.day14.base;

import android.view.View;

import java.lang.ref.WeakReference;

public class BasePresenter<V extends BaseView<T>, T> implements IPresenter {

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
    public void start(Object[] t) {

    }
}
