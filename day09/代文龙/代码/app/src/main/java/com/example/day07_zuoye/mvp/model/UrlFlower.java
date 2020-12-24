package com.example.day07_zuoye.mvp.model;

import com.example.day07_zuoye.callback.RxCallBack;

import java.io.IOException;

import io.reactivex.subscribers.ResourceSubscriber;
import okhttp3.ResponseBody;

public class UrlFlower extends ResourceSubscriber<ResponseBody> {


    private RxCallBack callBack;

    public UrlFlower(RxCallBack callBack){
        this.callBack = callBack;
    }

    @Override
    public void onNext(ResponseBody responseBody) {
        try {
            callBack.onSuccess(responseBody.string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable t) {
        callBack.onFiled(t.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
