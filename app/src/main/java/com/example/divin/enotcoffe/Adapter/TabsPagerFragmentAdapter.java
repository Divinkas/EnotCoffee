package com.example.divin.enotcoffe.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.divin.enotcoffe.Data.CavaType;
import com.example.divin.enotcoffe.Fragment.AbstractFragment;
import com.example.divin.enotcoffe.Fragment.CoffeeFragment;
import com.example.divin.enotcoffe.Model.CreaterCoffeeFragment;
import com.example.divin.enotcoffe.Model.DatabaseModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {
    private Map<Integer, AbstractFragment> tabs;
    private Context ctx;

    public TabsPagerFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.ctx = context;
        initFragments(ctx);
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position+1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return Objects.requireNonNull(tabs.get(position + 1)).getTITLE();
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    @SuppressLint("UseSparseArrays")
    private void initFragments(Context ctx) {
        tabs = new HashMap<>();
        DatabaseModel model = new DatabaseModel(ctx);
        List<CavaType> list = model.getTypeCava();
        for (int i = 0; i < list.size(); i++){
            tabs.put(list.get(i).getId(), CreaterCoffeeFragment.getCoffeeFragmentObject(ctx, list.get(i).getTypeName()));
        }
    }

}
