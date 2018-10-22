package com.example.divin.enotcoffe.Adapter;

import android.content.Context;

import com.example.divin.enotcoffe.Data.SellCava;

import java.util.List;

public class CoffeeFragmentAdapter {

    private List<SellCava> sellCavaList;
    private Context context;

    public CoffeeFragmentAdapter(List<SellCava> sellCavaList, Context context) {
        this.sellCavaList = sellCavaList;
        this.context = context;
    }
}
