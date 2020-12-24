package com.example.baidumap.mvp.manager;

public class DBManager {
    private volatile static DBManager mManager;
    private DBManager(){}
    public static synchronized DBManager getmManager(){
        if (mManager==null){
            synchronized (DBManager.class){
                if (mManager==null){
                    mManager=new DBManager();
                }
            }
        }
        return mManager;
    }
}
