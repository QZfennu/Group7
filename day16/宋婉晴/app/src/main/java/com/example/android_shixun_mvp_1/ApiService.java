package com.example.android_shixun_mvp_1;

import com.example.android_shixun_mvp_1.bean.BannerBean;
import com.example.android_shixun_mvp_1.bean.ItemBean;
import com.example.android_shixun_mvp_1.bean.TabBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    //https://www.wanandroid.com/project/tree/json
    //https://www.wanandroid.com/banner/json
    //https://www.wanandroid.com/project/list/1/json?cid=294

    String sUlr = "https://www.wanandroid.com/";

    @GET("project/tree/json")
    Observable<TabBean> getTab();

    @GET("banner/json")
    Observable<BannerBean> getBann();

    @GET("project/list/1/json?cid=294")
    Observable<ItemBean> getItem();


}
