package com.example.myapplication.Api;

import com.example.myapplication.Bean.HDBean;
import com.example.myapplication.Bean.RDBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String Url="http://cdwan.cn:7000/tongpao//";
    @GET("discover/hot_activity.json")
    Observable<HDBean> getData();
    @GET("discover/news_1.json")
    Observable<RDBean>getData2();
}
