package com.example.divin.enotcoffe.Utils;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.example.divin.enotcoffe.Data.Constants;
import com.example.divin.enotcoffe.R;

public class InstallMatherialMenu {
    private Context context;
    private MaterialMenuDrawable materialMenu;

    public InstallMatherialMenu(Context context, Toolbar toolbar, DrawerLayout drawerLayout, NavigationView navigationView) {
        this.context = context;
        materialMenu = new MaterialMenuDrawable(this.context, Color.WHITE, MaterialMenuDrawable.Stroke.THIN);
        initNavigationView(navigationView);

        toolbar.setNavigationIcon(materialMenu);
        toolbar.setNavigationOnClickListener(v -> {
            if(materialMenu.getIconState() == Constants.STATE_BURGER){
                materialMenu.animateIconState(Constants.STATE_ARROW);
                drawerLayout.openDrawer(navigationView);
            } else {
               materialMenu.animateIconState(Constants.STATE_BURGER);
                drawerLayout.closeDrawer(navigationView);
            }
        });

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {

            }

            @Override
            public void onDrawerOpened(@NonNull View view) {
                materialMenu.animateIconState(Constants.STATE_ARROW);
            }

            @Override
            public void onDrawerClosed(@NonNull View view) {
                materialMenu.animateIconState(Constants.STATE_BURGER);
            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
    }

    private void initNavigationView(NavigationView navigationView){
        navigationView.addHeaderView(LayoutInflater.from(context).inflate(R.layout.navigation_view_header, navigationView, false));
        navigationView.inflateMenu(R.menu.navigation_menu);
        initTvCountNotification(navigationView);
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.tovars_menu_item:
                    break;
                default:
                    Toast.makeText(context, "listener", Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        });
    }

    private void initTvCountNotification(NavigationView navigationView){
        TextView tvCountNotification = (TextView) MenuItemCompat.getActionView(navigationView.getMenu().getItem(4));

        //add getNotification method
        tvCountNotification.setText("0");
        tvCountNotification.setGravity(Gravity.CENTER);
    }

}
