package com.example.wsh666.homework.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wsh666.homework.Activity.MainActivity;
import com.example.wsh666.homework.Adapter.CommentAdepter;
import com.example.wsh666.homework.Adapter.MyAdapter;
import com.example.wsh666.homework.Bean.Comment;
import com.example.wsh666.homework.Bean.List4;
import com.example.wsh666.homework.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MyFragment4 extends Fragment {

    private List<List4> mData = null;
    private MyAdapter myAdapter1 = null;
    private ListView listView = null;

    private CommentAdepter adapterComment;
    private List<Comment> data;

    private Context mContext;

    private SwipeRefreshLayout swipeRefreshLayout;



    public MyFragment4() {
    }

    int userImageId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment4, container, false);
        mContext = getContext();
        listView = (ListView) view.findViewById(R.id.list_4);
        mData = new ArrayList<List4>();
        init();

         //初始化评论列表
        View pinglunView=inflater.inflate(R.layout.list_4, container, false);
        ListView comment_list = (ListView) pinglunView.findViewById(R.id.comment_list);
        // 初始化评论数据
        data = new ArrayList<>();
        // 初始化适配器
        adapterComment = new CommentAdepter(data);
        // 为评论列表设置适配器
        if (comment_list != null) {
            comment_list.setAdapter(adapterComment);
        }

        //刷新
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.list1_refrash);
        swipeRefreshLayout.setColorSchemeResources(R.color.pink);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });

        myAdapter1 = new MyAdapter<List4>((ArrayList) mData, R.layout.list_4) {
            @Override
            public void bindView(ViewHolder holder, List4 obj) {
                holder.setImageResource(R.id.user_image, obj.getImageId());
                holder.setText(R.id.username_page1, obj.getText1());
                holder.setText(R.id.content, obj.getText2());
                final TextView textView = (TextView) holder.getView(R.id.username_page1);
                ImageView zhuanfa = (ImageView) holder.getView(R.id.zhuan_fa);
                if (zhuanfa != null) {
//                    zhuanfa.setImageResource(R.drawable.header_image);
                    zhuanfa.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // 调用MainActivity的方法
                            MainActivity activity=(MainActivity)getActivity();
                            activity.showPinglun(1);
                            Toast.makeText(getActivity(), textView.getText(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Log.e("MyFragment4", "null");
                }

//                ListView comment_list = (ListView) holder.getView(R.id.comment_list);
//                // 初始化评论数据
//                data = new ArrayList<>();
//                // 初始化适配器
//                adapterComment = new CommentAdepter(data);
//                // 为评论列表设置适配器
//                if (comment_list != null) {
//                    comment_list.setAdapter(adapterComment);
//                }
            }
        };

        listView.setAdapter(myAdapter1);
        Log.e("HEHE", "1日狗");
        return view;
    }

    //点击评论按钮之后的操作
    public void sendPinglun(String s ){
        if(s.equals("")){
            Toast.makeText(mContext, "评论不能为空！", Toast.LENGTH_SHORT).show();
        }else{
            // 生成评论数据
            Comment comment = new Comment();
            comment.setName("评论者"+(data.size()+1)+"：");
            comment.setContent(s);
            Log.e(comment.getName(),comment.getContent());
            adapterComment.addComment(comment);
            Toast.makeText(mContext, "评论成功！", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    ////
    public void init() {
        userImageId = R.drawable.header_image;
//        mData.add(new List4(userImageId,"username1","content1"));
//        mData.add(new List4(userImageId,"username2","content2"));
//        mData.add(new List4(userImageId,"username3","content3"));
//        mData.add(new List4(userImageId,"username4","content4"));
//        mData.add(new List4(userImageId,"username5","content5"));
//        mData.add(new List4(userImageId,"username6","content6"));
//        mData.add(new List4(userImageId,"username7","content7"));
        List4 list4[] = {
            new List4(R.drawable.background, "username1", "content1"),
                    new List4(R.drawable.header_image, "username2", "content2"),
                    new List4(R.drawable.return_image, "username3", "content3"),
                    new List4(R.drawable.delete, "username4", "content4"),
                    new List4(R.drawable.dianzan, "username5", "content5"),
                    new List4(R.drawable.zhuanfa, "username6", "content6"),
                    new List4(R.drawable.tuijian, "username7", "content7")
        };
        mData.clear();
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int index = random.nextInt(list4.length);
            mData.add(list4[index]);
        }
    }

    //刷新事件
    public void refresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                init();
                myAdapter1.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 2000);
    }

}
