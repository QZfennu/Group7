package com.example.mvptwo.di.component;


import com.example.mvptwo.di.module.OKManager;
import com.example.mvptwo.mvp.model.RxOpretorImpl;

import javax.inject.Singleton;

import dagger.Component;

//注射器
@Singleton
@Component(modules = OKManager.class)
public interface OkComponent {
    //自定义的方法
    void getSingleApiService(RxOpretorImpl impl);
}