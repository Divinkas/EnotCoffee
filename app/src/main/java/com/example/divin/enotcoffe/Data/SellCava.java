package com.example.divin.enotcoffe.Data;

import java.util.Date;

import io.realm.RealmObject;

public class SellCava extends RealmObject {
    private int id;
    private int count;
    private int kod_cava_item;
    private Date current_day;
}
