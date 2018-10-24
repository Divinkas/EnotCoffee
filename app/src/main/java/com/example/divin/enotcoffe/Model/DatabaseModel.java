package com.example.divin.enotcoffe.Model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import com.example.divin.enotcoffe.Data.CavaItemInfo;
import com.example.divin.enotcoffe.Data.CavaType;
import com.example.divin.enotcoffe.Data.SellCoffee;
import com.example.divin.enotcoffe.Database.RealmClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public CavaItemInfo getCavaIntemInfoById(int id){
        realm.beginTransaction();
        CavaItemInfo cavaItemInfo = realm.where(CavaItemInfo.class).equalTo("identify", id).findFirst();
        realm.commitTransaction();
        return cavaItemInfo;
    }

    @SuppressLint("SimpleDateFormat")
    public List<SellCoffee> getDefaulMockListSells(){
        List<SellCoffee> list = new ArrayList<>();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        for (int i = 0; i < 10; i++){
            SellCoffee itemSells = new SellCoffee();

            itemSells.setId(i+1);
            itemSells.setCount(1);
            itemSells.setKod_cava_item(i+1);
            itemSells.setCurrent_day(formatter.format(date));

            list.add(itemSells);
        }

        return list;
    }

    public int addOneItemsInSellsById(int idSells){
        Toast.makeText(context, "+", Toast.LENGTH_SHORT).show();
        return idSells;
    }
}
