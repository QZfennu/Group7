package com.example.day14.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter, T> extends AppCompatActivity implements BaseView<T> {

    private Unbinder bind;
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //添加状态栏的背景色
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏的背景色
            getWindow().setStatusBarColor(Color.WHITE);
            //设置状态栏的文字为黑色
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        int layoutId = getLayoutId();
        if (layoutId != 0) setContentView(layoutId);
        bind = ButterKnife.bind(this);
        mPresenter = createPresenter();
        if (mPresenter != null) mPresenter.attachView(this);
        initView();
        initData();
    }

    public P getmPresenter() {
        if (mPresenter != null) return mPresenter;
        return null;
    }

    protected abstract P createPresenter();

    protected abstract int getLayoutId();

    protected void initData() {
    }

    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) bind.unbind();
    }

    @Override
    public void onSuccess(T t) {
    }

    @Override
    public void onFiled(String msg) {
    }
}
