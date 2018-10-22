package com.example.divin.enotcoffe.Data;

import io.realm.RealmObject;

public class CavaItemInfo extends RealmObject {
    private int identify;
    private String name;
    private int price;
    private int volume;
    private int kod_type_cava;
    private int kod_type_cup;

    public int getIdentify() {
        return identify;
    }

    public void setIdentify(int identify) {
        this.identify = identify;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getKod_type_cava() {
        return kod_type_cava;
    }

    public void setKod_type_cava(int kod_type_cava) {
        this.kod_type_cava = kod_type_cava;
    }

    public int getKod_type_cup() {
        return kod_type_cup;
    }

    public void setKod_type_cup(int kod_type_cup) {
        this.kod_type_cup = kod_type_cup;
    }
}
