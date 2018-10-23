package com.example.divin.enotcoffe;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.divin.enotcoffe.Adapter.TabsPagerFragmentAdapter;
import com.example.divin.enotcoffe.Contract.ITovarView;
import com.example.divin.enotcoffe.Presenter.TovarPresenter;
import com.example.divin.enotcoffe.Utils.InstallMatherialMenu;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoffeeActivity extends MvpAppCompatActivity implements ITovarView {

    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    @BindView(R.id.drawerTovars)
    public DrawerLayout drawerLayout;

    @BindView(R.id.tovarsNavigationView)
    public NavigationView navigationView;

    @BindView(R.id.viewPager)
    public ViewPager viewPager;

    @BindView(R.id.tabLayoutMain)
    public TabLayout tabLayout;

    @InjectPresenter
    public TovarPresenter tovarPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
        ButterKnife.bind(this);

        tovarPresenter.setDefaultContext(CoffeeActivity.this);

        setSupportActionBar(toolbar);
        new InstallMatherialMenu(CoffeeActivity.this, toolbar, drawerLayout, navigationView);

        TabsPagerFragmentAdapter tabsAdapter = new TabsPagerFragmentAdapter(getSupportFragmentManager(), this);

        viewPager.setAdapter(tabsAdapter);
        viewPager.setCurrentItem(1);

        tabLayout.setupWithViewPager(viewPager);


    }


}
