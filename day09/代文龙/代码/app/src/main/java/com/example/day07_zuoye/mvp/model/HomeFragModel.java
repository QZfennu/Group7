package com.example.day07_zuoye.mvp.model;

import com.example.day07_zuoye.callback.RxCallBack;
import com.example.day07_zuoye.di.component.DaggerUrlComponent;
import com.example.day07_zuoye.mvp.net.ApiService;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

public class HomeFragModel {
    @Inject
    ApiService apiService;

    public HomeFragModel() {
        DaggerUrlComponent.create().inject(this);
    }

    //封装get请求的方法
    public <T> void resultgetData(String url, RxCallBack callBack) {
        UrlOpertor.threadTransfo(apiService.resultgetData(url))
                .subscribeWith(new UrlFlower(callBack));
    }

    public <T> void resultgetData(String url, Map<String, Object> parms, RxCallBack callBack) {
        if (parms != null && parms.size() > 0) {
            UrlOpertor.threadTransfo(apiService.resultgetData(url, parms))
                    .subscribeWith(new UrlFlower(callBack));
        } else {
            resultgetData(url, callBack);
        }
    }

    public <T> void resultgetData(String url, HashMap<String, T> header, RxCallBack callBack) {
        if (header != null && header.size() > 0) {
            UrlOpertor.threadTransfo(apiService.resultgetData(url, header))
                    .subscribeWith(new UrlFlower(callBack));
        } else {
            resultgetData(url, callBack);
        }
    }

    public <T> void resultgetData(String url, HashMap<String, T> header, Map<String, T> parms, RxCallBack callBack) {
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
}
