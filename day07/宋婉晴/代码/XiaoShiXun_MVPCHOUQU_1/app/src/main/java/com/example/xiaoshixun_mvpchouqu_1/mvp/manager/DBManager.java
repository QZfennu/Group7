package com.example.xiaoshixun_mvpchouqu_1.mvp.manager;

public class DBManager {
    private volatile static DBManager mManager;

    private DBManager(){

    }

    public static synchronized DBManager getmManger(){
        if (mManager == null){
            synchronized (DBManager.class){
                if (mManager == null){
                    mManager = new DBManager();
                }
            }
        }
        return mManager;
    }
}
