package com.example.day11_zuoye;

public class GuoBean {
    private Integer image;
    private String address;

    public GuoBean(Integer image, String address) {
        this.image = image;
        this.address = address;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
