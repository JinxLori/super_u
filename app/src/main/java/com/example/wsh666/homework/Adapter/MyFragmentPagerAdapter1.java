package com.example.wsh666.homework.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.example.wsh666.homework.Fragment.MyFragment2;
import com.example.wsh666.homework.Fragment.MyFragment2_1;
import com.example.wsh666.homework.Fragment.MyFragment2_2;
import com.example.wsh666.homework.Fragment.MyFragment2_3;
import com.example.wsh666.homework.Fragment.MyFragment3;

/**
 * Created by wsh666 on 2018/4/6.
 * 嵌套的三个页面的适配器
 */

public class MyFragmentPagerAdapter1 extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 3;
    private MyFragment2_1 myFragment2_1=null;
    private MyFragment2_2 myFragment2_2 = null;
    private MyFragment2_3 myFragment2_3 = null;

    public MyFragmentPagerAdapter1(FragmentManager fm) {
        super(fm);

        myFragment2_2 = new MyFragment2_2();
        myFragment2_3 = new MyFragment2_3();
        myFragment2_1=new MyFragment2_1();
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case MyFragment2.PAGE_o:
                fragment=myFragment2_1;
                break;
            case MyFragment2.PAGE_t:
                fragment = myFragment2_2;
                break;
            case MyFragment2.PAGE_th:
                fragment = myFragment2_3;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }


}
