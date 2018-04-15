package com.example.wsh666.homework.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.wsh666.homework.Adapter.MsgAdapter;
import com.example.wsh666.homework.Bean.Msg;
import com.example.wsh666.homework.R;
import java.util.ArrayList;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;


public class MsgFragment extends Fragment implements View.OnClickListener {


    private List<Msg> msgList=new ArrayList<>();
    EditText inputText;
    Button send;
    MsgAdapter adapter;
    RecyclerView msgRecylerView;
    private String titleText;
    int left_image_id;
    int right_image_id;

    public MsgFragment(String titleText,int left_image_id,int right_image_id) {
        // Required empty public constructor
        this.titleText=titleText;
        this.left_image_id=left_image_id;
        this.right_image_id=right_image_id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.msg_fragment, container, false);
//        View view_msgItem=inflater.inflate(R.layout.msg_item,container,false);
        Context context=getContext();
        //设置标题
        TextView title_text=(TextView)view.findViewById(R.id.title_text_fragment);
        title_text.setText(titleText);

        initMsgs();
        inputText=(EditText)view.findViewById(R.id.input_text);
        send=(Button)view.findViewById(R.id.send);
        msgRecylerView=(RecyclerView)view.findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(context);//活动中这里的参数是this
        msgRecylerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecylerView.setAdapter(adapter);
        send.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void initMsgs(){
        Msg msg1=new Msg("Hello A.",Msg.TYPE_RECEIVED,left_image_id,right_image_id);
        msgList.add(msg1);
        Msg msg2=new Msg("Hello.Who are you?",Msg.TYPE_SENT,left_image_id,right_image_id);
        msgList.add(msg2);
        Msg msg3 =new Msg("I'm Tom,Nice to meet you.",Msg.TYPE_RECEIVED,left_image_id,right_image_id);
        msgList.add(msg3);
        Msg msg4 =new Msg("Nice to meet you too.",Msg.TYPE_SENT,left_image_id,right_image_id);
        msgList.add(msg4);
    }

    @Override
    public void onClick(View v) {
        String content =inputText.getText().toString();
        if(!"".equals(content)){
            Msg msg= new Msg(content,Msg.TYPE_SENT,left_image_id,right_image_id);
            msgList.add(msg);
            adapter.notifyItemInserted(msgList.size()-1);//当有新消息时，刷新
            msgRecylerView.scrollToPosition(msgList.size()-1);//将RecyclerView定位到最后一行
            inputText.setText("");//清空输入框
        }
    }


}

