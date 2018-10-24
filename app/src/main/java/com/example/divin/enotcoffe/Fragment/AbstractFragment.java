package com.example.divin.enotcoffe.Fragment;

import android.content.Context;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.example.divin.enotcoffe.Contract.IFragmentCoffeeView;

import butterknife.Unbinder;

public class AbstractFragment extends MvpAppCompatFragment implements IFragmentCoffeeView {
    private String TITLE;

    protected Context context;
    protected View view;
    protected Unbinder unbinder;

    public void setTitle(String title){
        TITLE = title;
    }
    public void setContext(Context context){ this.context = context; }
    public void setUnbinder(Unbinder unbinder){ this.unbinder = unbinder; }

    public String getTITLE() {
        return TITLE;
    }
}
