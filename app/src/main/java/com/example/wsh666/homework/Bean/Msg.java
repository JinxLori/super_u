package com.example.wsh666.homework.Bean;

/**
 * Created by wsh666 on 2018/4/8.
 * 消息界面列表的实体类
 */

public class Msg {
    public static final int TYPE_RECEIVED=0;
    public static final int TYPE_SENT=1;
    private String content;
    private int type;
    private int left_image;
    private int right_image;
    //信息内容；类型是左还是右；左边的头像；右边的头像
    public Msg(String content,int type,int left_image,int right_image){
        this.content=content;
        this.type=type;
        this.left_image=left_image;
        this.right_image=right_image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLeft_image() {
        return left_image;
    }

    public void setLeft_image(int left_image) {
        this.left_image = left_image;
    }

    public int getRight_image() {
        return right_image;
    }

    public void setRight_image(int right_image) {
        this.right_image = right_image;
    }
}
