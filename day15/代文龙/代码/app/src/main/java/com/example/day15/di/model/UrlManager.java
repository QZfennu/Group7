package com.example.day15.di.model;


import com.example.day15.mvp.net.ApiConstants;
import com.example.day15.mvp.net.ApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * 向外提供对象
 */
@Module     //向外提供对象的注解
public class UrlManager {

    @Singleton
    @Provides
    public OkHttpClient.Builder providesOkBuilder(){
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    public OkHttpClient providesOkHttp(){
        return providesOkBuilder().build();
    }

    @Singleton
    @Provides
    public Retrofit.Builder providesretorfitBuilder(){
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    public Retrofit providesRetrofit(){
        return providesretorfitBuilder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiConstants.BASE_URL)
                .build();
    }

    @Singleton
    @Provides
    public ApiService providesApiService(){
        return providesRetrofit().create(ApiService.class);
    }
}
