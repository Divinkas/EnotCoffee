package com.example.divin.enotcoffe.Database;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;

public class MigrationRealm implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        if (oldVersion==0){
            realm.createObject("SellCoffee");
            realm.createObject("StatSellForDay");
        }
    }
}
