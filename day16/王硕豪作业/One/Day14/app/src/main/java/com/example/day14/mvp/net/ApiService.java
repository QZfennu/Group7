package com.example.day14.mvp.net;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;


public interface ApiService {

    //GET请求

    @GET
    Flowable<ResponseBody> resultgetData(@Url String url);

    @GET
    <T>
    Flowable<ResponseBody> resultgetData(@Url String url, @QueryMap Map<String, Object> value);

    @GET
    <T>
    Flowable<ResponseBody> resultgetData(@Url String url, @HeaderMap HashMap<String, Object> header);

    @GET
    <T>
    Flowable<ResponseBody> resultgetData(@Url String url, @HeaderMap HashMap<String, Object> header, @QueryMap Map<String, Object> value);

    @GET
    Flowable<ResponseBody> resultgetData(@Url String url, @Body ResponseBody body);

    @GET
    <T>
    Flowable<ResponseBody> resultgetData(@Url String url, @HeaderMap HashMap<String, Object> header, @Body ResponseBody body);

    //POST 请求

    @POST
    @FormUrlEncoded
    Flowable<ResponseBody> resultpostData(@Url String url);

    @POST
    @FormUrlEncoded
    <T>
    Flowable<ResponseBody> resultpostData(@Url String url, @HeaderMap HashMap<String, Object> header);

    @POST
    @FormUrlEncoded
    <T>
    Flowable<ResponseBody> resultpostData(@Url String url, @FieldMap Map<String, String > value);

    @POST
    @FormUrlEncoded
    <T>
    Flowable<ResponseBody> resultpostData(@Url String url, @HeaderMap HashMap<String, Object> header, @FieldMap Map<String, String > value);

    @POST
    @FormUrlEncoded
    Flowable<ResponseBody> resultpostData(@Url String url, @Body ResponseBody body);

    @POST
    @FormUrlEncoded
    <T>
    Flowable<ResponseBody> resultpostData(@Url String url, @HeaderMap HashMap<String, Object> header, @Body ResponseBody body);

    //下载
    @GET
    @Streaming
    Flowable<ResponseBody> resultdownload(@Url String url);
}
