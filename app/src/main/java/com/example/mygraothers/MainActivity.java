package com.example.mygraothers;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.mygraothers.base.MyFragmentTabHost;
import com.example.mygraothers.fragment.HomeFragment;
import com.example.mygraothers.fragment.UserFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, MyFragmentTabHost.OnFragmentChangedListener {
    private MyFragmentTabHost mTabHost;
    private RadioGroup radioGroup = null;
    //tvMainTool用来区分是工作台还是扫码，tvMainToolIv对应的事件
    private TextView tvMainToolIv, tvMainTool;
    private RadioButton rbHome, rbClass, rbMore, rbUser, rbToolsSpace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
//        setToolbarHide(true);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }



        mTabHost = (MyFragmentTabHost) findViewById(R.id.tabhost);
        mTabHost.setChanagedListener(this);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        addCustomTab(this, "首页", "home",
                R.drawable.app_main_home, HomeFragment.class, mTabHost);
        addCustomTab(this, "我的", "user",
                R.drawable.app_main_home, UserFragment.class, mTabHost);

        radioGroup = (RadioGroup) findViewById(R.id.tab_bottom_layout_radioGroup);
        rbHome = (RadioButton) findViewById(R.id.tab_main_home);
        rbUser = (RadioButton) findViewById(R.id.tab_main_user);
        rbToolsSpace = (RadioButton) findViewById(R.id.tab_main_tool_space);

        radioGroup.setOnCheckedChangeListener(this);
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {

            }
        });

        mTabHost.setCurrentTab(0);
        // 默认选中第一个页卡
        onCheckedChanged(radioGroup, R.id.tab_main_home);

    }

    private void setToolbarHide(boolean isHide) {
        if (getSupportActionBar() != null) {
            if (isHide) {
                getSupportActionBar().hide();
            } else {
                getSupportActionBar().show();
            }
        }
    }

    private void setStatusBarHide() {
        if (Build.VERSION.SDK_INT < 16) {//before Jelly Bean Versions{
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else { // Jelly Bean and up

            View decorView = getWindow().getDecorView();
            // Hide the status bar.
            int ui = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(ui);

            //Hide actionbar
//            ActionBar actionBar = getActionBar();
//            actionBar.hide();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Drawable homeDefault = getResources().getDrawable(R.drawable.app_main_home);
        homeDefault.setBounds(0, 0, homeDefault.getIntrinsicWidth(), homeDefault.getIntrinsicHeight());
        Drawable homeSelect = getResources().getDrawable(R.drawable.app_main_home_selected);
        homeSelect.setBounds(0, 0, homeSelect.getIntrinsicWidth(), homeSelect.getIntrinsicHeight());
        Drawable userDefault = getResources().getDrawable(R.drawable.app_main_mypage);
        userDefault.setBounds(0, 0, userDefault.getIntrinsicWidth(), userDefault.getIntrinsicHeight());
        Drawable userSelect = getResources().getDrawable(R.drawable.app_main_mypage_selected);
        userSelect.setBounds(0, 0, userSelect.getIntrinsicWidth(), userSelect.getIntrinsicHeight());
        rbHome.setCompoundDrawables(null, homeDefault, null, null);
        rbUser.setCompoundDrawables(null, userDefault, null, null);

        if (checkedId == R.id.tab_main_home) {
            mTabHost.setCurrentTab(0);
            rbHome.setCompoundDrawables(null, homeSelect, null, null);
        } else if (checkedId == R.id.tab_main_user) {
            mTabHost.setCurrentTab(1);
            rbUser.setCompoundDrawables(null, userSelect, null, null);
        }


    }

    private void addCustomTab(Context context, String tabHostTitle, String tag,
                              int resid, Class<?> c, MyFragmentTabHost fth) {
        View view = LayoutInflater.from(context).inflate(
                R.layout.tab_customtab, null);
        ImageView image = (ImageView) view.findViewById(R.id.tab_icon);
        TextView text = (TextView) view.findViewById(R.id.tabtitle);
        image.setBackgroundResource(resid);
        text.setText(tabHostTitle);
        TabHost.TabSpec spec = fth.newTabSpec(tag);
        spec.setIndicator(view);
        fth.addTab(spec, c, null);
    }

    @Override
    public void onChanaged(Fragment fragments) {

    }
}
