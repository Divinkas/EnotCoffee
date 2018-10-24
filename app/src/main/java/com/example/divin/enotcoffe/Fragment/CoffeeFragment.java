package com.example.divin.enotcoffe.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.divin.enotcoffe.Presenter.CoffeeFragmentPresenter;
import com.example.divin.enotcoffe.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoffeeFragment extends AbstractFragment {
    private static final int LAYOUT_FRAGMENT = R.layout.fragment_coffee;

    @InjectPresenter
    public CoffeeFragmentPresenter coffeeFragmentPresenter;

    @BindView(R.id.itemsCoffeeListRecycler)
    public RecyclerView recyclerView;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT_FRAGMENT, container, false);
        setUnbinder(ButterKnife.bind(this, view));
        coffeeFragmentPresenter.setDefaultContext(context);
        recyclerView.setLayoutManager(coffeeFragmentPresenter.getLayoutManager());
        recyclerView.setAdapter(coffeeFragmentPresenter.getAdapter());
        return view;
    }

}
