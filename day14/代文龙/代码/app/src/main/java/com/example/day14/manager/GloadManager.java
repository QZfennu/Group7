package com.example.day14.manager;

import android.content.SharedPreferences;

import com.example.day14.base.App;

public class GloadManager {
    private static GloadManager mManager;
    private SharedPreferences mSp;

    public GloadManager() {
        if (mSp == null) mSp = App.getContext().getSharedPreferences("config", App.MODE_PRIVATE);
    }


    public synchronized static GloadManager getmManager() {
        if (mManager == null) {
            synchronized (GloadManager.class) {
                if (mManager == null) {
                    mManager = new GloadManager();
                }
            }
        }
        return mManager;
    }

    public void save_str(String key, String value) {
        mSp.edit().putString(key, value).commit();
    }

    public String getStr(String key) {
        return mSp.getString(key, "");
    }

    public void save_boolean(String key, Boolean value) {
        mSp.edit().putBoolean(key, value).commit();
    }

    public Boolean getBoolean(String key) {
        return mSp.getBoolean(key, false);
    }

    public void save_int(String key, int value) {
        mSp.edit().putInt(key, value).commit();
    }

    public int getInt(String key) {
        return mSp.getInt(key, 0);
    }
}
