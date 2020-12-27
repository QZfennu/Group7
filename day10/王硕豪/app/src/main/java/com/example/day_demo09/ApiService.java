package com.example.day_demo09;

import com.example.day_demo09.bean.HotBean;
import com.example.day_demo09.bean.ItemBean;
import com.example.day_demo09.bean.TitleBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    String Url = "http://cdwan.cn:7000/tongpao/";


    @GET("discover/hot_activity.json")
    Flowable<HotBean> getHot();

    @GET("discover/navigation.json")
    Flowable<TitleBean> getTitle();

    @GET("discover/news_{type}.json")
    Flowable<ItemBean> getItem(@Path("type") int type);
}
