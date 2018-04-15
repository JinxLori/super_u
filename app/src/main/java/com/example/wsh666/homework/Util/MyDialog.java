package com.example.wsh666.homework.Util;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wsh666.homework.R;

/**
 * Created by wsh666 on 2018/4/14.
 * 自定义的Dialog，显示课程详细信息
 */


public class MyDialog extends Dialog {

    private String c_info;

    public MyDialog(Context context,String c_info) {
        super(context,R.style.MyDialog);
        this.c_info=c_info;
    }

    public MyDialog(Context context,int thremId){
        super(context,R.style.MyDialog);
    }

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dialog);
        TextView c_name = (TextView)findViewById(R.id.c_name);
        c_name.setText(c_info);
        TextView c_teacher = (TextView)findViewById(R.id.c_teacher);
        c_teacher.setText("111");
        Button edit_button = (Button) findViewById(R.id.c_m_edit);
        edit_button.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dismiss();
            }
        });
    }
    //called when this dialog is dismissed
    protected void onStop() {
        Log.d("TAG","+++++++++++++++++++++++++++");
    }

}
