package com.example.mygraothers.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mygraothers.DetailActivity;
import com.example.mygraothers.R;
import com.example.mygraothers.adapter.FruitAdapter;
import com.example.mygraothers.base.AbstractBaseFragment;
import com.example.mygraothers.bean.Fruit;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by tanguiwu
 */
public class HomeFragment extends AbstractBaseFragment implements View.OnClickListener, FruitAdapter.OnItemClickListener {
    private LinearLayout llEdit;
    private TextView txtNavTitle;
    private TextView txtNaveBack;
    private RecyclerView recyclerView;
    private ArrayList<Fruit> fruitList;
    private FruitAdapter fruitAdapter;
    private int positionId = 0;

    public HomeFragment() {
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.home_main_fragment;
    }

    @Override
    protected void initView(View v) {
        final Toolbar toolbar = (Toolbar) v.findViewById(R.id.anim_toolbar);
        txtNavTitle = (TextView) v.findViewById(R.id.nav_toolbar_title);
        txtNaveBack = (TextView) v.findViewById(R.id.nav_toolbar_back);
        txtNavTitle.setText("主页");
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
//            toolbar.getLayoutParams().height = toolbar.getLayoutParams().height + getStatusBarHeight();
//            toolbar.setPadding(0, getStatusBarHeight(), 0, 0);
//        }

        fruitList = new ArrayList<>();
        recyclerView = (RecyclerView) v.findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        fruitAdapter = new FruitAdapter(getActivity(), fruitList, this);
        recyclerView.setAdapter(fruitAdapter);


        fruitAdapter.notifyDataSetChanged();


    }

    private void initFruitData() {
        Realm realm = Realm.getDefaultInstance();
        for (int i = 0; i < 5; i++) {
            realm.beginTransaction();//开启事务
            Fruit apple = realm.createObject(Fruit.class); //
//            apple = new Fruit("富士苹果", "鲜美多汁，香甜爽口", R.drawable.apple, "20元/kg");
            apple.setId(positionId++);
            apple.setName("富士苹果");
            apple.setIntro("鲜美多汁，香甜爽口");
            apple.setImageID(R.drawable.apple);
            apple.setPrice("20元/kg");
            fruitList.add(apple);
            realm.commitTransaction();//提交事务
            realm.beginTransaction();//开启事务
            Fruit  shiliu = realm.createObject(Fruit.class); //
//            Fruit shiliu = new Fruit("大理石榴", "鲜美多汁，新鲜上市", R.drawable.pomegranate, "25元/kg");
            shiliu.setId(positionId++);
            shiliu.setName("大理石榴");
            shiliu.setIntro("鲜美多汁，新鲜上市");
            shiliu.setImageID(R.drawable.pomegranate);
            shiliu.setPrice("25元/kg");
            fruitList.add(shiliu);
            realm.commitTransaction();//提交事务

            realm.beginTransaction();//开启事务
            Fruit cehngzi = realm.createObject(Fruit.class); //
//            Fruit cehngzi = new Fruit("台湾橙子", "浓甜可口，瓣瓣多汁", R.drawable.orange, "13.3元/kg");
            cehngzi.setId(positionId++);
            cehngzi.setName("台湾橙子");
            cehngzi.setIntro("浓甜可口，瓣瓣多汁");
            cehngzi.setImageID(R.drawable.orange);
            cehngzi.setPrice("13.3元/kg");
            fruitList.add(cehngzi);
            realm.commitTransaction();//提交事务

            realm.beginTransaction();//开启事务
            Fruit mangguo = realm.createObject(Fruit.class); //
//            Fruit mangguo = new Fruit("新鲜青芒", "精选大果，香甜可口", R.drawable.mangguo, "33元/kg");
            mangguo.setId(positionId++);
            mangguo.setName("新鲜青芒");
            mangguo.setIntro("精选大果，香甜可口");
            mangguo.setImageID(R.drawable.mangguo);
            mangguo.setPrice("33元/kg");
            fruitList.add(mangguo);
            realm.commitTransaction();//提交事务


            realm.beginTransaction();//开启事务
            Fruit putao = realm.createObject(Fruit.class); //
//            Fruit putao = new Fruit("小蜜蜂葡萄", "滋润多汁，新鲜采摘", R.drawable.putao, "21元/kg");
            putao.setId(positionId++);
            putao.setName("小蜜蜂葡萄");
            putao.setIntro("滋润多汁，新鲜采摘");
            putao.setImageID(R.drawable.putao);
            putao.setPrice("21元/kg");
            fruitList.add(putao);
            realm.commitTransaction();//提交事务


            realm.beginTransaction();//开启事务
            Fruit boluo = realm.createObject(Fruit.class); //
//            Fruit boluo = new Fruit("台湾菠萝", "止水浓厚，新鲜采摘", R.drawable.boluo, "19元/kg");
            boluo.setId(positionId++);
            boluo.setName("台湾菠萝");
            boluo.setIntro("止水浓厚，新鲜采摘");
            boluo.setImageID(R.drawable.boluo);
            boluo.setPrice("19元/kg");
            fruitList.add(boluo);
            realm.commitTransaction();//提交事务

            realm.beginTransaction();//开启事务
            Fruit xigua = realm.createObject(Fruit.class); //
//            Fruit xigua = new Fruit("红玉西瓜", "皮薄肉厚，新鲜上市", R.drawable.xigua, "12元/kg");
            xigua.setId(positionId++);
            xigua.setName("红玉西瓜");
            xigua.setIntro("皮薄肉厚，新鲜上市");
            xigua.setImageID(R.drawable.xigua);
            xigua.setPrice("12元/kg");
            fruitList.add(xigua);
            realm.commitTransaction();//提交事务
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        initFruitData();
    }


    @Override
    public void onPause() {
        super.onPause();
//        deleteData();

    }

    @Override
    protected void initData() {


    }

//    // 1.查询全部
//    //查询结果为RealmResults，可以使用mRealm.copyFromRealm(peoples)方法将它转为List
//    public RealmList<Fruit> queryAllPeople() {
//        RealmList<Fruit> list = new RealmList<>();
//        Realm realmQ = Realm.getDefaultInstance();
//        RealmResults<Fruit> userBeans = realmQ.where(Fruit.class).findAll();
//        list.addAll(realmQ.copyFromRealm(userBeans));
//        return list;
//    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();

    }


    private void deleteData() {
        Realm mRealm = Realm.getDefaultInstance();

        final RealmResults<Fruit> fruits = mRealm.where(Fruit.class).findAll();

        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //删除第几个
//                UserBean people=userBeans.get(2);
//                people.deleteFromRealm();
                //删除第一个数据
//                userBeans.deleteFirstFromRealm();
                //删除最后一个数据
//                userBeans.deleteLastFromRealm();
                //删除位置为1的数据
//                userBeans.deleteFromRealm(1);
                //删除所有数据
                fruits.deleteAllFromRealm();
            }
        });
    }


    @Override
    public void onItemClicked(int position, View v) {
        Log.d("", "onItemClicked: " + position + "---" + fruitList.get(position).toString());

        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("myposition", position);
        getActivity().startActivity(intent);
    }
}
