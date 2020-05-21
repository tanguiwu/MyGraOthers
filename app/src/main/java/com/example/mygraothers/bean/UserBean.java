package com.example.mygraothers.bean;

import io.realm.RealmObject;

public class UserBean extends RealmObject {

    private String id;
    private String name;
    private int age;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
//     class Peopleextends  extends RealmObject {
//        public int id;
//        public RealmList<Description> descriptions;
//    }
//
//     class Description  extends  RealmObject {
//        public String name;
//        public int age;
//    }
}
