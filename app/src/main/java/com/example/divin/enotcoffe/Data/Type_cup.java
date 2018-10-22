package com.example.divin.enotcoffe.Data;

import io.realm.RealmObject;

public class Type_cup extends RealmObject {
    private int id;
    private int typeNameStakan;
    private int countStk;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeNameStakan() {
        return typeNameStakan;
    }

    public void setTypeNameStakan(int typeNameStakan) {
        this.typeNameStakan = typeNameStakan;
    }

    public int getCountStk() {
        return countStk;
    }

    public void setCountStk(int countStk) {
        this.countStk = countStk;
    }
}
