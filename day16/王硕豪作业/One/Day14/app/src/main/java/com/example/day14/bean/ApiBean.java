package com.example.day14.bean;

import com.google.gson.annotations.SerializedName;

public class ApiBean {
    /**
     * code : 200
     * message : 成功
     * data : 251adca7f6e5b89f0efc43711c0ba249
     */

    @SerializedName("code")
    private String code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private String data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
