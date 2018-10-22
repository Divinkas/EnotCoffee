package com.example.divin.enotcoffe.Data;

import java.util.Date;

import io.realm.RealmObject;

public class DayStatsSells extends RealmObject {
    private int id;
    private int priceSells;
    private Date day;

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

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}
