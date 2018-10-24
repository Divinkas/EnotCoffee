package com.example.divin.enotcoffe.Model;

import android.content.Context;

import com.example.divin.enotcoffe.Fragment.CoffeeFragment;

public class CreaterCoffeeFragment {

    public static CoffeeFragment getCoffeeFragmentObject(Context ctx, String title){
        CoffeeFragment coffeeFragment = new CoffeeFragment();
        coffeeFragment.setContext(ctx);
        coffeeFragment.setTitle(title);
        return coffeeFragment;
    }
}
