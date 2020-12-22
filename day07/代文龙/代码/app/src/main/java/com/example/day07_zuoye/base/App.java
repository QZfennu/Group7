package com.example.day07_zuoye.base;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        mContext = this;
    }

    public static Context getmContext() {
        return mContext;
    }

}
