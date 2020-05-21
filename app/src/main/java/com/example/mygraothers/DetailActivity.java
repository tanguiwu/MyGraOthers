package com.example.mygraothers;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mygraothers.bean.Fruit;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class DetailActivity extends AppCompatActivity {


    private ImageView image;
    private TextView name;
    private TextView price;
    private TextView intro;
    private int positionId;
    private TextView txtNavTitle;
    private TextView txtNaveBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detail);
//        setToolbarHide(true);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        initview();

        Intent intent = getIntent();
        positionId = getIntent().getIntExtra("myposition", 0);
        RealmList<Fruit> fruits = queryAllPeople();
        Fruit fruit = fruits.get(positionId);
        Log.d("tgw2详情：", "onCreate: "+fruit.toString());
        txtNavTitle.setText(fruit.getName());
        image.setImageResource(fruit.getImageId());
        name.setText("水果：" + fruit.getName());
        price.setText("价格：" + fruit.getPrice());
        intro.setText("介绍：" + fruit.getIntro());
    }

    private void initview() {
        image = (ImageView) findViewById(R.id.image);
        name = (TextView) findViewById(R.id.name);
        price = (TextView) findViewById(R.id.price);
        intro = (TextView) findViewById(R.id.intro);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.anim_toolbar);
        txtNavTitle = (TextView) findViewById(R.id.nav_toolbar_title);
        txtNaveBack = (TextView) findViewById(R.id.nav_toolbar_back);

        txtNaveBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    // 1.查询全部
    //查询结果为RealmResults，可以使用mRealm.copyFromRealm(peoples)方法将它转为List
    public RealmList<Fruit> queryAllPeople() {
        RealmList<Fruit> list = new RealmList<>();
        Realm realmQ = Realm.getDefaultInstance();
        RealmResults<Fruit> fruits = realmQ.where(Fruit.class).findAll();
        Log.d("tgw所有值：", "queryAllPeople: "+fruits.toString());
        list.addAll(realmQ.copyFromRealm(fruits));
        return list;
    }
}
