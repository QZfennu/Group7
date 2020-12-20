package com.example.mengshiyun2;

public class Bean {
    private int pic;
    private String title;

    public Bean(int pic, String title) {
        this.pic = pic;
        this.title = title;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "pic=" + pic +
                ", title='" + title + '\'' +
                '}';
    }
}
