package com.example.wsh666.homework.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.wsh666.homework.Adapter.MyAdapter;
import com.example.wsh666.homework.Bean.List2_1;
import com.example.wsh666.homework.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wsh666 on 2018/4/6.
 * 群聊列表
 */

public class MyFragment2_3 extends Fragment {


    private List<List2_1> mData=null;
    private MyAdapter myAdapter=null;
    private ListView listView=null;

    private Context mContext;

    private SwipeRefreshLayout swipeRefreshLayout;


    public MyFragment2_3() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.my_fragment2_3, container, false);
        mContext = getContext();
        listView=(ListView)view.findViewById(R.id.message_list3);
        mData=new ArrayList<List2_1>();
        init();

        //刷新
        swipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.list2_3_refrash);
        swipeRefreshLayout.setColorSchemeResources(R.color.pink);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });

        myAdapter=new MyAdapter<List2_1>((ArrayList)mData, R.layout.list2_1) {
            @Override
            public void bindView(ViewHolder holder, List2_1 obj) {
                holder.setImageResource(R.id.message_header,obj.getImageId());
                holder.setText(R.id.message_username,obj.getText2());
                holder.setText(R.id.message_content,obj.getText3());
            }
        };
        listView.setAdapter(myAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List2_1 list2_3=mData.get(position);
                Toast.makeText(mContext,list2_3.getText2(),Toast.LENGTH_SHORT).show();
            }
        });

    }





    public void init(){
        List2_1 list2_1[]={
                new List2_1(R.drawable.background,"username1","content1"),
                new List2_1(R.drawable.header_image,"username2","content2"),
                new List2_1(R.drawable.return_image,"username3","content3"),
                new List2_1(R.drawable.delete,"username4","content4"),
                new List2_1(R.drawable.dianzan,"username5","content5"),
                new List2_1(R.drawable.zhuanfa,"username6","content6"),
                new List2_1(R.drawable.tuijian,"username7","content7")
        };
        mData.clear();
        for(int i=0;i<20;i++){
            Random random=new Random();
            int index=random.nextInt(list2_1.length);
            mData.add(list2_1[index]);
        }
    }

    public void refresh(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                init();
                myAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        },2000);
    }
}
