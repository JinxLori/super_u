package com.example.wsh666.homework.Bean;

/**
 * Created by wsh666 on 2018/4/4.
 */

public class List4 {
    private String Text1;
    private int ImageId;
    private String Text2;


    public List4(int ImageId, String Text1, String Text2){
        this.ImageId=ImageId;
        this.Text1=Text1;
        this.Text2=Text2;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getText1() {
        return Text1;
    }

    public void setText1(String text1) {
        Text1 = text1;
    }

    public String getText2() {
        return Text2;
    }

    public void setText2(String text2) {
        Text2 = text2;
    }
}
