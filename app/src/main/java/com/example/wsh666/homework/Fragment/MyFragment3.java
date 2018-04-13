package com.example.wsh666.homework.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.wsh666.homework.Adapter.GirdAdapter;
import com.example.wsh666.homework.R;

import java.util.ArrayList;
import java.util.List;


public class MyFragment3 extends Fragment {


    private Spinner spinner;

    private GridView detailCource;


    private String[][] contents;

    private GirdAdapter girdAdapter;

    private List<String> dataList;

    private Context mContext;

    private ArrayAdapter<String> spinnerAdapter;

    public MyFragment3() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment3,container,false);
        mContext=getContext();

        spinner = (Spinner)view.findViewById(R.id.switchWeek);
        detailCource = (GridView)view.findViewById(R.id.courceDetail);

        //创建Adapter
        fillStringArray();
        girdAdapter = new GirdAdapter(mContext);
        girdAdapter.setContent(contents, 6, 7);
        detailCource.setAdapter(girdAdapter);
        //////////////创建Spinner数据
        fillDataList();
        spinnerAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_dropdown_item, dataList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        Log.e("HEHE", "3日狗");
        return view;
    }


    public void fillStringArray() {
        contents = new String[6][7];
        contents[0][0] = "XXXXX\n11111";
        contents[1][0] = "XXXXXXXX\n2222";
        contents[2][0] = "XXXXXXXX\nA212";
        contents[3][0] = "AAAAAAAAaaa\nC309";
        contents[4][0] = "";
        contents[5][0] = "";
        contents[0][1] = "EEEEEEEEEE\nB211";
        contents[1][1] = "";
        contents[2][1] = "%%%%%%%%%%\nA309";
        contents[3][1] = "TTTTTTTTTTTT\nA309";
        contents[4][1] = "";
        contents[5][1] = "";
        contents[0][2] = "GGGGGGGGGGGGGG\nE203";
        contents[1][2] = "BBBBBBBBBBBB\nA212";
        contents[2][2] = "FFFFFFFFFFFF\nB211";
        contents[3][2] = "";
        contents[4][2] = "";
        contents[5][2] = "";
        contents[0][3] = "TTTTTTTTTTT\nA309";
        contents[1][3] = "TTTTTTTTTT\nC309";
        contents[2][3] = "";
        contents[3][3] = "";
        contents[4][3] = "";
        contents[5][3] = "";
        contents[0][4] = "YYYYYYYYYYYYY\nB211";
        contents[1][4] = "UUUUUUUUUUUUU\nE203";
        contents[2][4] = "";
        contents[3][4] = "";
        contents[4][4] = "";
        contents[5][4] = "";
        contents[0][5] = "";
        contents[1][5] = "";
        contents[2][5] = "";
        contents[3][5] = "";
        contents[4][5] = "";
        contents[5][5] = "";
        contents[0][6] = "";
        contents[1][6] = "";
        contents[2][6] = "";
        contents[3][6] = "";
        contents[4][6] = "";
        contents[5][6] = "测试";
    }

    public void fillDataList() {
        dataList = new ArrayList<>();
        for(int i = 1; i < 21; i++) {
            dataList.add("第" + i + "周");
        }
    }
}
