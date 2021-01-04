package com.example.day15.utils;

import com.google.gson.Gson;

public class GsonUtils {
    private static Gson gson;

    static {
        gson = new Gson();
    }

    public static  <T> T strgson(String jsonstr,Class<T> bean) {
        return gson.fromJson(jsonstr,bean);
    }
}
