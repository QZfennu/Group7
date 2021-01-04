package com.example.day14.mvp.model;

import com.example.day14.callback.RxCallback;
import com.example.day14.di.component.DaggerUrlComponent;
import com.example.day14.mvp.net.ApiService;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

public class Model {
    @Inject
    ApiService apiService;

    public Model() {
        DaggerUrlComponent.create().inject(this);
    }

    //封装get请求的方法
    public <T> void resultgetData(String url, RxCallback callBack) {
        UrlOpertor.threadTransfo(apiService.resultgetData(url))
                .subscribeWith(new UrlFlower(callBack));
    }

    public <T> void resultgetData(String url, Map<String, Object> parms, RxCallback callBack) {
        if (parms != null && parms.size() > 0) {
            UrlOpertor.threadTransfo(apiService.resultgetData(url, parms))
                    .subscribeWith(new UrlFlower(callBack));
        } else {
            resultgetData(url, callBack);
        }
    }

    public <T> void resultgetData(String url, HashMap<String, Object> header, RxCallback callBack) {
        if (header != null && header.size() > 0) {
            UrlOpertor.threadTransfo(apiService.resultgetData(url, header))
                    .subscribeWith(new UrlFlower(callBack));
        } else {
            resultgetData(url, callBack);
        }
    }

    public <T> void resultgetData(String url, HashMap<String, Object> header, Map<String, Object> parms, RxCallback callBack) {
        if (header != null && header.size() > 0 && parms != null && parms.size() > 0) {
            UrlOpertor.threadTransfo(apiService.resultgetData(url, header, parms))
                    .subscribeWith(new UrlFlower(callBack));
        } else if (header != null && header.size() > 0) {
            resultgetData(url, header, callBack);
        } else if (parms != null && parms.size() > 0) {
//            resultgetData(url,parms,callBack);
        } else {
            resultgetData(url, callBack);
        }
    }


    //封装POST请求
    public <T> void resultpostData(String url,RxCallback callback){
        UrlOpertor.threadTransfo(apiService.resultpostData(url))
                .subscribeWith(new UrlFlower(callback));
    }

    public <T> void resultpostData(String url,HashMap<String ,Object> header,RxCallback callback){
        if (header != null && header.size() > 0) {
            UrlOpertor.threadTransfo(apiService.resultpostData(url,header))
                    .subscribeWith(new UrlFlower(callback));
        } else {
            resultgetData(url, callback);
        }
    }

    public <T> void resultpostData(String url,Map<String ,String > value,RxCallback callback){
        if (value != null && value.size() > 0) {
            UrlOpertor.threadTransfo(apiService.resultpostData(url,value))
                    .subscribeWith(new UrlFlower(callback));
        } else {
            resultgetData(url, callback);
        }
    }

    public <T> void resultpostData(String url, HashMap<String, Object> header, Map<String, String > value, RxCallback callBack) {
        if (header != null && header.size() > 0 && value != null && value.size() > 0) {
            UrlOpertor.threadTransfo(apiService.resultpostData(url, header, value))
                    .subscribeWith(new UrlFlower(callBack));
        } else if (header != null && header.size() > 0) {
            resultpostData(url, header, callBack);
        } else if (value != null && value.size() > 0) {
            resultpostData(url,value,callBack);
        } else {
            resultpostData(url, callBack);
        }
    }

}
