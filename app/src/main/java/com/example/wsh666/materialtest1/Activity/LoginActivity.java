package com.example.wsh666.materialtest1.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.wsh666.materialtest1.R;
import com.example.wsh666.materialtest1.Util.EditTextWithDel;
import com.example.wsh666.materialtest1.Util.LoadBingPic;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    EditTextWithDel name_edit;
    EditTextWithDel password_edit;
    CheckBox rememberPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        //背景图设置
        ImageView login_backgroud=(ImageView)findViewById(R.id.login_backgroud);
        //从服务器获取最新的图片
        LoadBingPic a=new LoadBingPic();
        a.loadBingPic(LoginActivity.this,login_backgroud);

        //按钮下文字点击监听器
        TextView register_text=(TextView)findViewById(R.id.register_text);
        TextView lost_password_text=(TextView)findViewById(R.id.lost_password_text);
        TextView service_text=(TextView)findViewById(R.id.text2);
        Button loginButton=(Button)findViewById(R.id.login_button);
        register_text.setOnClickListener(this);
        lost_password_text.setOnClickListener(this);
        service_text.setOnClickListener(this);
        loginButton.setOnClickListener(this);

        //记住密码功能
        pref= PreferenceManager.getDefaultSharedPreferences(this);
        name_edit=(EditTextWithDel)findViewById(R.id.username);
        password_edit=(EditTextWithDel)findViewById(R.id.password);
        rememberPass=(CheckBox)findViewById(R.id.remember_password);
        boolean isRemember = pref.getBoolean("remember_password",false);
        if(isRemember){
            //将账号和密码都设置到文本框中
            String name=pref.getString("name","");
            String password=pref.getString("password","");
            name_edit.setText(name);
            password_edit.setText(password);
            rememberPass.setChecked(true);
        }
    }

    //设置文字和按钮的点击事件
    public void onClick(View view){
        Intent intent=null;
        switch (view.getId()){
            case R.id.register_text:
                Toast.makeText(LoginActivity.this,"register",Toast.LENGTH_SHORT).show();
                intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.lost_password_text:
                Toast.makeText(LoginActivity.this,"findPassword",Toast.LENGTH_SHORT).show();
//                intent =new Intent(LoginActivity.this,FindPasswordActivity.class);
//                startActivity(intent);
                break;
            case R.id.text2:
                Toast.makeText(LoginActivity.this,"service_html",Toast.LENGTH_SHORT).show();
//                intent = new Intent(LoginActivity.this,RegisterActivity.class);
//                startActivity(intent);
                break;
            case R.id.login_button:
                String name=name_edit.getText().toString();
                String password=password_edit.getText().toString();
                //如果账号和密码是wsh  123456就认为登陆成功
                if(name.equals("wsh")&&password.equals("123456")){
                    editor=pref.edit();
                    if(rememberPass.isChecked()){//检查复选框是否被选中，选中存入信息
                        editor.putBoolean("remember_password",true);
                        editor.putString("name",name);
                        editor.putString("password",password);
                    }else{
                        editor.clear();
                    }
                    editor.apply();
                }
                intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                this.finish();
                break;
        }
    }


}
