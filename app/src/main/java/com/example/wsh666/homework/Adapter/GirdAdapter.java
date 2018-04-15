package com.example.wsh666.homework.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wsh666.homework.Activity.MainActivity;
import com.example.wsh666.homework.Fragment.MyFragment3;
import com.example.wsh666.homework.R;
import com.example.wsh666.homework.Util.MyDialog;

/**
 * Created by wsh666 on 2018/4/12.
 * GirdView的适配器
 * 包含课程信息显示的Dialog
 */

public class GirdAdapter extends BaseAdapter {


    private Context mContext;

    private String[][] contents;

    private int rowTotal;

    private int columnTotal;

    private int positionTotal;
    private MyDialog myDialog;


    public GirdAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return positionTotal;
    }

    @Override
    public Object getItem(int position) {
        //求余得到二维索引
        int column = position % columnTotal;
        //求商得到二维索引
        int row = position / columnTotal;
        return contents[row][column];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_item, null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.text);
        //如果有课,那么添加数据
        if (!getItem(position).equals("")) {
            textView.setText((String) getItem(position));
            textView.setTextColor(Color.WHITE);
            //变换颜色
            int rand = position % columnTotal;
            switch (rand) {
                case 0:
                    textView.setBackground(mContext.getResources().getDrawable(R.drawable.grid_item_bg));
                    break;
                case 1:
                    textView.setBackground(mContext.getResources().getDrawable(R.drawable.bg_12));
                    break;
                case 2:
                    textView.setBackground(mContext.getResources().getDrawable(R.drawable.bg_13));
                    break;
                case 3:
                    textView.setBackground(mContext.getResources().getDrawable(R.drawable.bg_14));
                    break;
                case 4:
                    textView.setBackground(mContext.getResources().getDrawable(R.drawable.bg_15));
                    break;
                case 5:
                    textView.setBackground(mContext.getResources().getDrawable(R.drawable.bg_16));
                    break;
                case 6:
                    textView.setBackground(mContext.getResources().getDrawable(R.drawable.bg_17));
                    break;
                case 7:
                    textView.setBackground(mContext.getResources().getDrawable(R.drawable.bg_18));
                    break;
            }
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int row = position / columnTotal;
                    int column = position % columnTotal;
                    //显示课程信息的Dialog
                    myDialog=new MyDialog(mContext,contents[row][column]);
                    myDialog.setCancelable(true);//用户可以点击手机Back键取消对话框显示
                    //myDialog.setCanceledOnTouchOutside(false);//用户不能通过点击对话框之外的地方取消对话框显示
                    myDialog.show();
                    String con = "当前选中的是" + contents[row][column] + "课";
                    Toast.makeText(mContext, con, Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "+++++", Toast.LENGTH_SHORT).show();
                }
            });
        }
        return convertView;
    }

    /**
     * 设置内容、行数、列数
     */
    public void setContent(String[][] contents, int row, int column) {
        this.contents = contents;
        this.rowTotal = row;
        this.columnTotal = column;
        positionTotal = rowTotal * columnTotal;
    }
}
