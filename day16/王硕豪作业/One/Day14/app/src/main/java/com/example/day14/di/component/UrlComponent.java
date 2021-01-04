package com.example.day14.di.component;


import com.example.day14.di.model.UrlManager;
import com.example.day14.mvp.model.Model;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 注射器，用于连接@Module和@Inject
 */
@Singleton
@Component(modules = UrlManager.class)
public interface UrlComponent {

    void inject(Model homeModel);
}
