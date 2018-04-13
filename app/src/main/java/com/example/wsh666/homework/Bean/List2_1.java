package com.example.wsh666.homework.Bean;

/**
 * Created by wsh666 on 2018/4/6.
 * 消息界面list实体类
 */

public class List2_1 {
    private int imageId;
    private String text2;
    private String text3;

    public List2_1(int imageId,String text2,String text3){
        this.imageId=imageId;
        this.text2=text2;
        this.text3=text3;
    }


    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
}
