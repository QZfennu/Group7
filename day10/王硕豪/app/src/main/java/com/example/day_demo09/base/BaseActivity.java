package com.example.day_demo09.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter,T> extends AppCompatActivity implements IBaseView<T> {


    private Unbinder bind;
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        if (layoutId != 0)
            setContentView(layoutId);
        bind = ButterKnife.bind(this);
        //1.创建P层对象并且关联V层
        mPresenter = createPresenter();
        if (mPresenter != null)
            mPresenter.attachView(this);
        initData();
    }

    protected abstract P createPresenter();

    protected abstract void initData();

    protected abstract int getLayoutId();

    @Override
    public abstract void getData(T t) ;
}
