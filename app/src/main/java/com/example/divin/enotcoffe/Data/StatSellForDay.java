package com.example.divin.enotcoffe.Data;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

@RealmClass
public class StatSellForDay extends RealmObject {
    private int id;
    private int priceSells;
    private String day;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriceSells() {
        return priceSells;
    }

    public void setPriceSells(int priceSells) {
        this.priceSells = priceSells;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
