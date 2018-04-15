package com.example.wsh666.homework.Util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by wsh666 on 2018/3/30.
 */

public class LoadBingPic extends Activity {

    //    从服务器加载背景图
    public void loadBingPic(final Context context, final ImageView view){
        String requestBingPic = "http://guolin.tech/api/bing_pic";
        HttpUtil.sendOkHttpRequest(requestBingPic, new Callback() {
            @Override
            //从服务器加载失败
            public void onFailure(Call call, IOException e) {
                SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(context);
                final String bingPic=pref.getString("bing_pic",null);
                if(bingPic!=null){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Glide.with(context).load(bingPic).into(view);
                        }
                    });
                }
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String bingPic = response.body().string();
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
                editor.putString("bing_pic",bingPic);
                editor.apply();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(context).load(bingPic).into(view);
                    }
                });
            }
        });
    }
}
