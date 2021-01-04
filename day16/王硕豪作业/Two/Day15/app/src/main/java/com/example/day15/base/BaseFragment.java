package com.example.day15.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresenter, T> extends Fragment implements BaseView<T> {
    private P mPresenter;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = getLayoutId();
        View view = null;
        if (layoutId != 0) {
            view = inflater.inflate(layoutId, null);
            bind = ButterKnife.bind(this, view);
        }
        mPresenter = createPresenter();
        if (mPresenter != null) mPresenter.attachView(this);
        return view;
    }

    public P getmPresenter() {
        return mPresenter;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P createPresenter();

    protected abstract int getLayoutId();

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onFiled(String msg) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bind!= null) bind.unbind();
    }
}
