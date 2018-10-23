package com.example.divin.enotcoffe.Data;

import java.util.Date;

import io.realm.RealmObject;

public class SellCava extends RealmObject {
    private int id;
    private int count;
    private int kod_cava_item;
    private Date current_day;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getKod_cava_item() {
        return kod_cava_item;
    }

    public void setKod_cava_item(int kod_cava_item) {
        this.kod_cava_item = kod_cava_item;
    }

    public Date getCurrent_day() {
        return current_day;
    }

    public void setCurrent_day(Date current_day) {
        this.current_day = current_day;
    }
}
