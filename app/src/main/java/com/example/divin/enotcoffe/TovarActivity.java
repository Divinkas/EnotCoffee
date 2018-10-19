package com.example.divin.enotcoffe;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.divin.enotcoffe.Utils.InstallMatherialMenu;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TovarActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    @BindView(R.id.drawerTovars)
    public DrawerLayout drawerLayout;

    @BindView(R.id.tovarsNavigationView)
    public NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tovars);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        new InstallMatherialMenu(TovarActivity.this, toolbar, drawerLayout, navigationView);

    }


}
