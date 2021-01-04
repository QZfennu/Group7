package com.example.day14.utils;

import com.google.gson.Gson;

public class GsonUtils {

    private static Gson gson;

    static {
        gson = new Gson();
    }

    public static <T> T strgson(String strjson,Class<T> bean){
        return gson.fromJson(strjson,bean);
    }

}
