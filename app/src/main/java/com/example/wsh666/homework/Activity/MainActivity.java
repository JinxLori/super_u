package com.example.wsh666.homework.Activity;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wsh666.homework.Adapter.MyFragmentPagerAdapter;
import com.example.wsh666.homework.Fragment.MenuFragment;
import com.example.wsh666.homework.Fragment.MyFragment4;
import com.example.wsh666.homework.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener, View.OnClickListener {

    //UI Objects
    private RadioGroup rg_tab_bar;
    private RadioButton rb_channel;
    private RadioButton rb_message;
    private RadioButton rb_better;
    private RadioButton rb_setting;

    private ViewPager vpager;
    private CircleImageView hdmenu_image;
    private TextView title_text;
    private ImageView menu_image;
    private ImageView hd_h_background;

    private MyFragmentPagerAdapter mAdapter;

    private DrawerLayout mDrawerLayout;

    private RelativeLayout r1_content;


    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;


    private MenuFragment menuFragment;
    private ImageView hide_down;
    private EditText comment_content;
    private Button comment_send;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context mContext=getApplicationContext();
        hdmenu_image = (CircleImageView) findViewById(R.id.hdmenu_image);
        menu_image = (ImageView) findViewById(R.id.menu_image);
        title_text = (TextView) findViewById(R.id.title_text);
        hdmenu_image.setImageResource(R.drawable.header_image);
        menu_image.setImageResource(R.drawable.menu);
        hdmenu_image.setOnClickListener(this);
        menu_image.setOnClickListener(this);
        //获取DrawerLayout的实例
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //给四个碎片设置适配器
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        rb_channel.setChecked(true);

        //初始化评论框中的控件
        r1_content = (RelativeLayout) findViewById(R.id.rl_comment);
        hide_down = (ImageView) findViewById(R.id.hide_down);
        comment_content = (EditText) findViewById(R.id.comment_content_edittext);
        comment_send = (Button) findViewById(R.id.comment_send);
        comment_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyFragment4 myFragment4=(MyFragment4)mAdapter.getItem(MainActivity.PAGE_FOUR);
                myFragment4.sendPinglun(comment_content.getText().toString());
            }
        });
        //判断输入框焦点变化
        comment_content.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    Log.e("foucs","has");
                }else {
                    Log.e("foucs","nohas");
                    // 隐藏评论框
                    rg_tab_bar.setVisibility(View.VISIBLE);
                    r1_content.setVisibility(View.GONE);
                    // 隐藏输入法，然后暂存当前输入框的内容，方便下次使用
                    InputMethodManager im = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    im.hideSoftInputFromWindow(comment_content.getWindowToken(), 0);
                }
            }
        });
        hide_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 隐藏评论框
                showPinglun(2);
            }
        });

        //获取Navigation的实例，设置滑动菜单中的子项点击事件
        final NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        navView.setCheckedItem(R.id.nav_1);//将第一个菜单项设为默认选中
//        菜单事件监听器
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
//            滑动菜单按钮项逻辑事件
            public boolean onNavigationItemSelected(MenuItem item) {
                String text;
//                Toast.makeText(MainActivity.this,"Exit menu",Toast.LENGTH_SHORT).show();
//                mDrawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.nav_1:
                        text = item.getTitle().toString();
//                         Log.e(text," ");
                        //第一个参数表示该碎片调用的是menu_1布局文件，第二个文件表示该碎片的标题是text
                        menuFragment = new MenuFragment(R.layout.menu_1, text);
                        replaceFragment(menuFragment);
                        break;
                    case R.id.nav_2:
                        text = item.getTitle().toString();
                        menuFragment = new MenuFragment(R.layout.menu_2, text);
                        replaceFragment(menuFragment);
                        break;
                    case R.id.nav_3:
                        text = item.getTitle().toString();
                        menuFragment = new MenuFragment(R.layout.menu_3, text);
                        replaceFragment(menuFragment);
                        break;
                    case R.id.nav_4:
                        text = item.getTitle().toString();
                        menuFragment = new MenuFragment(R.layout.menu_4, text);
                        replaceFragment(menuFragment);
                        break;
                    case R.id.nav_5:
                        text = item.getTitle().toString();
                        menuFragment = new MenuFragment(R.layout.menu_5, text);
                        replaceFragment(menuFragment);
                        break;

                    case R.id.action_person:
                        text = item.getTitle().toString();
                        menuFragment = new MenuFragment(R.layout.menu_person, text);
                        replaceFragment(menuFragment);
                        break;
                }
                return true;
            }
        });


    }

    private void bindViews() {
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_channel = (RadioButton) findViewById(R.id.rb_channel);
        rb_message = (RadioButton) findViewById(R.id.rb_message);
        rb_better = (RadioButton) findViewById(R.id.rb_better);
        rb_setting = (RadioButton) findViewById(R.id.rb_setting);
        rg_tab_bar.setOnCheckedChangeListener(this);

        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_channel:
                //根据底部选项设置标题栏
                title_text.setText(rb_channel.getText());
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_message:
                title_text.setText(rb_message.getText());
                vpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_better:
                title_text.setText(rb_better.getText());
                vpager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.rb_setting:
                title_text.setText(rb_setting.getText());
                vpager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }


    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    rb_channel.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_message.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_better.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rb_setting.setChecked(true);
                    break;
            }
        }
    }


    //显示菜单
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.toolbar, menu);//R.表示通过哪一个资源来创建菜单,第二个参数用来指定菜单将会添加到哪一个Menu对象
//        return true;
//    }

    //定义菜单子项点击响应事件
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
////            HomeAsUp的ID永远是android.R.id.home
//            case android.R.id.home:
//                mDrawerLayout.openDrawer(GravityCompat.START);
//                break;
//            case R.id.delete:
//                Toast.makeText(this, "You clicked Delete", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.setting:
//                Toast.makeText(this, "You Clicked Setting", Toast.LENGTH_SHORT).show();
//                break;
//            default:
//        }
//        return true;
//    }


    //显示弹出的菜单
    private void showPopupMenu(View view) {
        // View当前PopupMenu显示的相对View的位置
        final PopupMenu popupMenu = new PopupMenu(this, view);
        // menu布局
        popupMenu.getMenuInflater().inflate(R.menu.toolbar, popupMenu.getMenu());
        // menu的item点击事件
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.delete:
                        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.setting:
                        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        // PopupMenu关闭事件
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
                Toast.makeText(getApplicationContext(), "关闭PopupMenu", Toast.LENGTH_SHORT).show();
            }
        });
        popupMenu.show();
    }

    //标题中各项点击事件
    public void onClick(View view) {
//        Intent intent=null;
        switch (view.getId()) {
            case R.id.hdmenu_image:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.menu_image:
                showPopupMenu(menu_image);
            case R.id.comment_send:
                break;
        }
    }

    //动态添加碎片
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.menu_fragment, fragment);
        //模拟返回栈 防止退出碎片时也退出活动
        transaction.addToBackStack(null);
        transaction.commit();
    }

    //显示评论框,隐藏最底部的选项卡
    public void showPinglun(int flag) {
        if (flag == 1) {
            //输入框获取焦点
            comment_content.setFocusable(true);
            comment_content.setFocusableInTouchMode(true);
            comment_content.requestFocus();
            // 显示评论框
            rg_tab_bar.setVisibility(View.GONE);
            r1_content.setVisibility(View.VISIBLE);
            // 弹出输入法
            InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        } else {
            // 隐藏评论框
            rg_tab_bar.setVisibility(View.VISIBLE);
            r1_content.setVisibility(View.GONE);
            // 隐藏输入法，然后暂存当前输入框的内容，方便下次使用
            InputMethodManager im = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(comment_content.getWindowToken(), 0);
        }

    }

//    //当点击评论按钮之后的操作
//    public String sendComment(){
//        return comment_content.getText().toString();
//    }

    //判断评论输入框内容是否为空
    private void submit() {
        String content = comment_content.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            Toast.makeText(this, "shuruneirong", Toast.LENGTH_SHORT).show();
        }
    }

}
