package com.example.wsh666.homework.Util;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.wsh666.homework.R;

/**
 * Created by wsh666 on 2018/4/1.
 */

public class Title extends LinearLayout{
    public Title (Context context, AttributeSet attr){
        super(context,attr);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        ImageView titleBack=(ImageView) findViewById(R.id.return_image);
        titleBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //获取到活动 然后调用活动的按下返回键效果
                ((Activity)getContext()).onBackPressed();
            }
        });
    }
}
