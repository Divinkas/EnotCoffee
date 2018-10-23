package com.example.divin.enotcoffe.Model;

import android.content.Context;
import android.util.Log;

import com.example.divin.enotcoffe.Data.CavaItemInfo;
import com.example.divin.enotcoffe.Data.CavaType;
import com.example.divin.enotcoffe.Database.RealmClient;

import java.util.List;

import io.realm.Realm;

public class DatabaseModel {
    private Realm realm;
    private Context context;

    public DatabaseModel(Context context) {
        this.context = context;
        realm = RealmClient.getInstance(context);
    }

    public List<CavaType> getTypeCava(){
        List<CavaType> cavaTypeList;
        realm.beginTransaction();
        cavaTypeList = realm.where(CavaType.class).findAll();
        realm.commitTransaction();
        return cavaTypeList;
    }

    public List<CavaItemInfo> getItemsCavaByIdType(int idType){
        realm.beginTransaction();
        List<CavaItemInfo> list = realm.where(CavaItemInfo.class).equalTo("kod_type_cava", idType).findAll();
        realm.commitTransaction();
        return list;
    }
}
