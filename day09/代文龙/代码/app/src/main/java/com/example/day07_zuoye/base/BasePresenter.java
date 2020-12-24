package com.example.day07_zuoye.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends BaseView<T>, T> implements IPresenter<T> {

    //用弱引用修饰V层
    private WeakReference<V> mView;
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    //方便GC回收  P层关联V层
    protected void attachView(V view) {
        mView = new WeakReference<V>(view);
    }

    protected void addDisposable(Disposable disposable) {
        if (mCompositeDisposable != null) mCompositeDisposable.add(disposable);
    }

    protected void detachView() {
        //释放资源
        if (mView != null) {
            mView.clear();
            mView = null;
        }
        //断开网络请求
        disposable();
    }

    private void disposable() {
        if (mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
            mCompositeDisposable.clear();
            mCompositeDisposable = null;
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void start(T... t) {

    }

}
