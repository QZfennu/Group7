package com.example.day05_2;

public class Rv2Bean {
    private Integer image;
    private String title;
    private String desc;
    private String zuo;
    private String du;

    public Rv2Bean(Integer image, String title, String desc, String zuo, String du) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.zuo = zuo;
        this.du = du;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getZuo() {
        return zuo;
    }

    public void setZuo(String zuo) {
        this.zuo = zuo;
    }

    public String getDu() {
        return du;
    }

    public void setDu(String du) {
        this.du = du;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
