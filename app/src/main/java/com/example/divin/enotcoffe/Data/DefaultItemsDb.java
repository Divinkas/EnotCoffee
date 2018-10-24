package com.example.divin.enotcoffe.Data;

import android.content.Context;

import com.example.divin.enotcoffe.Database.RealmClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmObjectSchema;
import io.realm.RealmResults;
import io.realm.RealmSchema;
import io.realm.annotations.RealmModule;

public class DefaultItemsDb {

    private Context context;
    private Realm realm;

    private int id = 1;
    private List<CavaItemInfo> cavaItemInfoList;

    public DefaultItemsDb(Context context) {
        this.context = context;
        realm = RealmClient.getInstance(this.context);
        cavaItemInfoList = new ArrayList<>();
        installDefaultData();
    }

    private void installDefaultData(){
        realm.beginTransaction();
        List<CavaItemInfo> listCava;

//        realm.delete(CavaItemInfo.class);
//        realm.delete(CavaType.class);
//        realm.delete(Type_cup.class);
//
//        realm.commitTransaction();
//        realm.beginTransaction();

        listCava = realm.where(CavaItemInfo.class).findAll();

        realm.commitTransaction();

        if (listCava.size() == 0){
            setDefaultCoffeeType();
            setDefaultTypeCupCoffee();
            setDefaultCoffeeItemInfo();
        }

    }

    private void setDefaultCoffeeItemInfo(){
        //create list americano
        List<String> namesAmericanoObjects = Arrays.asList("Рістеро", "Еспресо", "Лунго", "Допіо", "Романо", "Макіато", "Амерікано", "Дабл Амерікано", "Флет Уайт");
        List<Integer> priceListAmericano = Arrays.asList(9, 9, 9, 9, 10, 11, 9, 15, 17);
        List<Integer> volumeTypeListAmericano = Arrays.asList(1, 1, 2, 2, 2, 2, 2, 1, 1);
        insertedData(namesAmericanoObjects, priceListAmericano, volumeTypeListAmericano, 1);

        //create list capocino
        List<String> namesCapochinoObjects = Arrays.asList("Капучіно", "Капучіно", "Капучіно", "Дабл Капучіно", "Дабл Капучіно", "Ірландський Капучіно", "Ірландський Капучіно", "Горіховий Капучіно", "Горіховий Капучіно");
        List<Integer> priceListCapochino = Arrays.asList(15, 20, 22, 23, 25, 17, 22, 20, 25);
        List<Integer> volumeListCapochino = Arrays.asList(3, 3, 5, 3, 3, 5, 3, 3, 3);
        insertedData(namesCapochinoObjects, priceListCapochino, volumeListCapochino, 2);

        //create list late


        realm.beginTransaction();
        realm.insert(cavaItemInfoList);
        realm.commitTransaction();
    }

    private void setDefaultTypeCupCoffee(){
        List<Type_cup> type_cupList = new ArrayList<>();
        int default_count = 100;
        List<Integer> volumes = Arrays.asList(90, 180, 250, 400, 500);
        for(int i = 0; i < volumes.size(); i++){
            Type_cup cup = new Type_cup();
            cup.setId(i+1);
            cup.setCountStk(default_count);
            cup.setTypeNameStakan(volumes.get(i));
            type_cupList.add(cup);
        }
        realm.beginTransaction();
        realm.insert(type_cupList);
        realm.commitTransaction();
    }

    private void setDefaultCoffeeType(){
        List<CavaType> defaultData = new ArrayList<>();
        List<Integer> id = Arrays.asList(1, 2, 3, 4, 5);
        //List<String> nameType = Arrays.asList("Амерікано", "Капучіно", "Лате", "Чай","Холодні");
        List<String> nameType = Arrays.asList("Амерікано", "Капучіно");
        for (int i = 0; i<nameType.size(); i++){
            CavaType cavaType = new CavaType();
            cavaType.setId(id.get(i));
            cavaType.setTypeName(nameType.get(i));
            defaultData.add(cavaType);
        }
        realm.beginTransaction();
        realm.insert(defaultData);
        realm.commitTransaction();

    }

    private void insertedData(List<String> nameCoffee, List<Integer> priceCoffee, List<Integer> volumeCoffee,
                                            int typeCoffee){
        for (int i = 0; i< nameCoffee.size(); i++){
            CavaItemInfo cavaItemInfo = new CavaItemInfo();
            cavaItemInfo.setIdentify(id);
            cavaItemInfo.setKod_type_cava(typeCoffee);

            realm.beginTransaction();
            Type_cup cup = realm.where(Type_cup.class).equalTo("id", volumeCoffee.get(i)).findFirst();
            realm.commitTransaction();

            cavaItemInfo.setKod_type_cup(cup.getId());
            cavaItemInfo.setName(nameCoffee.get(i));
            cavaItemInfo.setPrice(priceCoffee.get(i));
            cavaItemInfo.setVolume(cup.getTypeNameStakan());

            cavaItemInfoList.add(cavaItemInfo);
            id++;
        }
    }
}
