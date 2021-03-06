package com.example.mvptwo.mvp.model;

import com.example.mvptwo.callback.RxObserverCallBack;
import com.example.mvptwo.di.component.DaggerOkComponent;
import com.example.mvptwo.mvp.model.api.ApiService;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class RxOpretorImpl {
    @Inject
    ApiService mApiService;

    public RxOpretorImpl() {
        DaggerOkComponent.create().
                getSingleApiService(this);
    }

    //没有参数也没有请求头的get请求
    public <T> void rxGetRequest(String url, RxObserverCallBack<T> callBack) {
        RxOperator.threadtransformer(mApiService.requestGetData(url)).
                subscribe(new RxObserver(callBack));
    }



    //有参数没有请求头的get请求
    public <T> void rxGetRequest(String url, Map<String, T> params,
                                 RxObserverCallBack<T> callBack) {
        if (params != null && params.size() > 0) { //有参数的请求
            RxOperator.threadtransformer(mApiService.requestGetData(url, params)).
                    subscribe(new RxObserver(callBack));
        } else {  //没有参数的请求
            rxGetRequest(url, callBack);
        }
    }


    //有请求头但是没有参数的get请求
    public <T> void rxGetRequest(String url, HashMap<String, T> headers,
                                 RxObserverCallBack<T> callBack) {
        if (headers != null && headers.size() > 0) {
            RxOperator.threadtransformer(mApiService.requestGetData(url, headers)).
                    subscribe(new RxObserver(callBack));
        } else {
            rxGetRequest(url, callBack);
        }
    }



    //没有参数也没有请求头的post请求
    public <T> void rxPostRequest(String url, RxObserverCallBack<T> callBack) {
        RxOperator.threadtransformer(mApiService.requestPostData(url)).
                subscribe(new RxObserver(callBack));
    }


}