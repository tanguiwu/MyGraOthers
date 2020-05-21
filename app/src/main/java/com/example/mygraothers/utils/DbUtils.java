package com.example.mygraothers.utils;

import android.util.Log;

import com.example.mygraothers.bean.UserBean;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class DbUtils {


    private void editData(){
        Realm mRealm=Realm.getDefaultInstance();

        UserBean people = mRealm.where(UserBean.class).equalTo("id", "1").findFirst();
        mRealm.beginTransaction();
        people.setName("修改的名字");
        mRealm.commitTransaction();
    }



    private void deleteData(){
        Realm  mRealm=Realm.getDefaultInstance();

        final RealmResults<UserBean> peoples=  mRealm.where(UserBean.class).findAll();

        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //删除第几个
                UserBean people=peoples.get(2);
                people.deleteFromRealm();
                //删除第一个数据
//                peoples.deleteFirstFromRealm();
                //删除最后一个数据
//                peoples.deleteLastFromRealm();
                //删除位置为1的数据
//                peoples.deleteFromRealm(1);
                //删除所有数据
//                peoples.deleteAllFromRealm();
            }
        });
    }

    // 1.查询全部
    //查询结果为RealmResults，可以使用mRealm.copyFromRealm(peoples)方法将它转为List
    public List<UserBean> queryAllPeople() {
        Realm   realm = Realm.getDefaultInstance();
        RealmResults<UserBean> peoples = realm.where(UserBean.class).findAll();
        return realm.copyFromRealm(peoples);
    }

    //（2）条件查询
    public static UserBean queryPeopleById(String id) {
        Realm mRealm = Realm.getDefaultInstance();
        UserBean people = mRealm.where(UserBean.class).equalTo("id", id).findFirst();
        return people;
    }


    /**
     * 3 对查询结果进行排序
     * query （查询所有）
     */
    public List<UserBean> queryAllDog() {
        Realm mRealm = Realm.getDefaultInstance();
        RealmResults<UserBean> peoples = mRealm.where(UserBean.class).findAll();
        /**
         * 对查询结果，按Id进行排序，只能对查询结果进行排序
         */
        //增序排列
        peoples=peoples.sort("id");
        //降序排列
//        peoples=peoples.sort("id", Sort.DESCENDING);
        return mRealm.copyFromRealm(peoples);
    }



    /**
     *  查询平均年龄
     */
    private void getAverageAge() {
        Realm mRealm = Realm.getDefaultInstance();
        double avgAge=  mRealm.where(UserBean.class).findAll().average("age");
        Log.d("平均年龄", "getAverageAge: "+avgAge);
    }

    /**
     *  查询总年龄
     */
    private void getSumAge() {
        Realm mRealm = Realm.getDefaultInstance();
        Number sum=  mRealm.where(UserBean.class).findAll().sum("age");
        int sumAge=sum.intValue();
        Log.d("总年龄", "getAverageAge: "+sum);
    }

    /**
     *  查询最大年龄
     */
    private void getMaxId(){
        Realm mRealm = Realm.getDefaultInstance();
        Number max=  mRealm.where(UserBean.class).findAll().max("age");
        int maxAge=max.intValue();
        Log.d("最大年龄", "getAverageAge: "+maxAge);
    }
}
