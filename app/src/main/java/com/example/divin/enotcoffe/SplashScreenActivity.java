package com.example.divin.enotcoffe;

import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.divin.enotcoffe.Contract.SplashView;
import com.example.divin.enotcoffe.Presenter.CheckUserPresenter;

public class SplashScreenActivity extends MvpAppCompatActivity implements SplashView {

    @InjectPresenter
    public CheckUserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userPresenter.setContextActivity(SplashScreenActivity.this);
        checkUserLogin();
        finish();
    }

    @Override
    public void checkUserLogin() {
        Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
        if(userPresenter.isAuthentificationUser()){
            intent = new Intent(SplashScreenActivity.this, CoffeeActivity.class);
        }
        startActivity(intent);
    }
}
