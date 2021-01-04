package com.example.day15.base;

import android.app.Application;
import android.content.Context;

public class BaseApp extends Application {

    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        context = this;
    }

    public Context getContext() {
        return context;
    }
}
