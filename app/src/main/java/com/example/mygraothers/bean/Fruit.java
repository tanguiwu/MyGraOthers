package com.example.mygraothers.bean;

import java.io.Serializable;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Fruit extends RealmObject{

    int id;
    String name;
    String intro;
    int imageID;
    String price;


    public Fruit() {

    }

    public Fruit(String name, String intro, int imageID, String price) {
        this.name = name;
        this.intro = intro;
        this.imageID = imageID;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getIntro() {
        return intro;
    }

    public int getImageId() {
        return imageID;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", imageID=" + imageID +
                ", price='" + price + '\'' +
                '}';
    }
}
