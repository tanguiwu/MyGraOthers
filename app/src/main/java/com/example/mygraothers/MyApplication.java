package com.example.mygraothers;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        //Realm文件默认位于Context.getFilesDir（）中，名称为“default.realm”
        Realm.init(this.getApplicationContext());
//        //1.默认配置
//        RealmConfiguration config = new RealmConfiguration.Builder().build();
//        Realm.setDefaultConfiguration(config);

        //2.使用自定义配置
        // The RealmConfiguration is created using the builder pattern.
        // The Realm file will be located in Context.getFilesDir() with name "myRealm.realm"
        RealmConfiguration config1 = new  RealmConfiguration.Builder()
                .name("myRealm.realm")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config1);
       // Use the config
//        Realm realm = Realm.getInstance(config1);


    }
}
