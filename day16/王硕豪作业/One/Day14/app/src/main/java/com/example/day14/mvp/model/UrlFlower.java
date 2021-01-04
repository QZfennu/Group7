package com.example.day14.mvp.model;


import com.example.day14.callback.RxCallback;

import java.io.IOException;

import io.reactivex.subscribers.ResourceSubscriber;
import okhttp3.ResponseBody;

public class UrlFlower extends ResourceSubscriber<ResponseBody> {


    private RxCallback callBack;

    public UrlFlower(RxCallback callBack){
        this.callBack = callBack;
    }

    @Override
    public void onNext(ResponseBody responseBody) {
        try {
            callBack.onSuccess(responseBody.string());
        } catch (IOException e) {
            callBack.onFiled(e.getMessage());
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
