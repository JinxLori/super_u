package com.example.wsh666.homework.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.wsh666.homework.R;
import com.example.wsh666.homework.Util.LoadBingPic;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //背景图设置
        ImageView register_backgroud=(ImageView)findViewById(R.id.register_backgroud);
        //从服务器获取最新的图片
        LoadBingPic a=new LoadBingPic();
        a.loadBingPic(RegisterActivity.this,register_backgroud);

        Button register_button = (Button)findViewById(R.id.register_button);
        register_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
        case R.id.register_button:
            intent=new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(intent);
            this.finish();
        }
    }
}
