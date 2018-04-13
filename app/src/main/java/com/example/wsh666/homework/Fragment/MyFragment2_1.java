package com.example.wsh666.homework.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.wsh666.homework.Activity.MainActivity;
import com.example.wsh666.homework.Adapter.MyAdapter;
import com.example.wsh666.homework.Bean.List2_1;
import com.example.wsh666.homework.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MyFragment2_1 extends Fragment {

    private List<List2_1> mData=null;
    private MyAdapter myAdapter=null;
    private ListView listView=null;

    private Context mContext;

    MsgFragment msgFragment;

    private SwipeRefreshLayout swipeRefreshLayout;


    public MyFragment2_1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.my_fragment2_1, container, false);
        mContext = getContext();
        listView=(ListView)view.findViewById(R.id.message_list1);
        mData=new ArrayList<List2_1>();
        init();

        //刷新
        swipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.list2_1_refrash);
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
                //实例化集合
                List2_1 list2_1 = mData.get(position);
                //这里应该从主活动获取到本用户的头像,暂时直接弄一个
                int right_image_id=R.drawable.header_image;
                //实例化消息界面碎片，首先通过参数获取到所点击的消息选项来
                // 设置消息界面的标题，以及右边的头像，自己的头像
                msgFragment=new MsgFragment(list2_1.getText2(),list2_1.getImageId(),right_image_id);
                Toast.makeText(mContext, list2_1.getText2()+list2_1.getImageId(), Toast.LENGTH_SHORT).show();
//                调用MainActivity的方法
                MainActivity activity=(MainActivity)getActivity();
                activity.replaceFragment(msgFragment);
            }
        });
    }

    public void init(){
//        mData.add(new List2_1(R.drawable.header_image,"username1","content1"));
//        mData.add(new List2_1(R.drawable.header_image,"username2","content2"));
//        mData.add(new List2_1(R.drawable.background,"username3","content3"));
//        mData.add(new List2_1(R.drawable.header_image,"username4","content4"));
//        mData.add(new List2_1(R.drawable.header_image,"username5","content5"));
//        mData.add(new List2_1(R.drawable.header_image,"username6","content6"));
//        mData.add(new List2_1(R.drawable.header_image,"username7","content7"));
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
