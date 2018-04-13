package com.example.wsh666.homework.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wsh666.homework.R;

public class MenuFragment extends Fragment {

    public int r;
    private String menu_fragment_title;


    //添加参数  第一个是这个Fragment调用的布局文件id，第二个是设置该fragment的标题
    public MenuFragment(int r,String menu_fragment_title) {
        // Required empty public constructor
        this.r=r;
        this.menu_fragment_title=menu_fragment_title;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(r,container,false);
//        Log.e("xxx","xxx");
        TextView title_text=(TextView)view.findViewById(R.id.title_text_fragment);
        title_text.setText(menu_fragment_title);
//        Log.e(title_text.getText().toString(),"qqq");
        return view;
    }

}
