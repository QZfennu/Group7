package com.example.day07_zuoye.di.component;

import com.example.day07_zuoye.di.model.UrlManager;
import com.example.day07_zuoye.mvp.model.HomeFragModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 注射器，用于连接@Module和@Inject
 */
@Singleton
@Component(modules = UrlManager.class)
public interface UrlComponent {

    void inject(HomeFragModel homeFragModel);
}
