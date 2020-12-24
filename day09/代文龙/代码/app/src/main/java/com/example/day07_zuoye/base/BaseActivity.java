package com.example.day07_zuoye.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter,T> extends AppCompatActivity implements BaseView<T>{

    private Unbinder bind;
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        if (layoutId != 0) setContentView(layoutId);
        bind = ButterKnife.bind(this);
        mPresenter = createPresenter();
        if (mPresenter != null) mPresenter.attachView(this);
        init();
        initData();
    }

    protected abstract P createPresenter();

    //负责处理一些数据的方法
    protected void initData() {
    }

    public P getmPresenter() {
        if (mPresenter != null) return mPresenter;
        return null;
    }

    //初始化界面的方法
    protected abstract void init();

    //加载布局的方法
    protected abstract int getLayoutId();

    //返回的数据
    @Override
    public void onSuccess(T t) {

    }

    //返回的错误信息
    @Override
    public void onFiled(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) bind.unbind();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}
