package com.example.day14.mvp.model;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class UrlOpertor {

    public static Flowable<ResponseBody> threadTransfo(Flowable<ResponseBody> flowable){
        return flowable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }



}
