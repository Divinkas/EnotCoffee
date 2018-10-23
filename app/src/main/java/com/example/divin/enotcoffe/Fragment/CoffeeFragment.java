package com.example.divin.enotcoffe.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.divin.enotcoffe.R;

public class CoffeeFragment extends AbstractFragment {
    private static final int LAYOUT_FRAGMENT = R.layout.fragment_coffee;

    public static CoffeeFragment getInstance(Context ctx, String title){
        CoffeeFragment coffeeFragment = new CoffeeFragment();
        coffeeFragment.context = ctx;
        coffeeFragment.setTitle(title);
        return coffeeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT_FRAGMENT, container, false);

        //add initialization

        return view;
    }
}
