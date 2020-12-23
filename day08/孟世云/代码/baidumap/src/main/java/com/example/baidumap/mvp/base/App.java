package com.example.baidumap.mvp.base;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;

public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        mContext=this;
        SDKInitializer.initialize(this);
        SDKInitializer.setCoordType(CoordType.BD09LL);
    }
    public static Context context(){
        return mContext;
    }
    public static String getStr(int p){
        return App.context().getString(p);
    }
}
