package com.example.day_demo09.model;


import com.example.day_demo09.ApiService;
import com.example.day_demo09.bean.HotBean;
import com.example.day_demo09.bean.ItemBean;
import com.example.day_demo09.bean.TitleBean;
import com.example.day_demo09.presenter.HomePre;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel {
    public void getData(HomePre homePre) {

        new Retrofit.Builder()
                .baseUrl(ApiService.Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getHot()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new ResourceSubscriber<HotBean>() {
                    @Override
                    public void onNext(HotBean hotBean) {
                        homePre.getData(hotBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {
                        initOk(homePre);
                    }
                });

    }

    private void initOk(HomePre homePre) {
        new Retrofit.Builder()
                .baseUrl(ApiService.Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getTitle()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new ResourceSubscriber<TitleBean>() {
                    @Override
                    public void onNext(TitleBean titleBean) {
                        homePre.getData(titleBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getItem(int id, HomePre homePre) {
        new Retrofit.Builder()
                .baseUrl(ApiService.Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getItem(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new ResourceSubscriber<ItemBean>() {
                    @Override
                    public void onNext(ItemBean itemBean) {
                        homePre.getData(itemBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
