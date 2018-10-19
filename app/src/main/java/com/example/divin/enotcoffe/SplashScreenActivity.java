package com.example.divin.enotcoffe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.divin.enotcoffe.Contract.SplashView;
import com.example.divin.enotcoffe.Presenter.CheckUserPresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreenActivity extends MvpAppCompatActivity implements SplashView {

    @InjectPresenter
    public CheckUserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userPresenter.setContextActivity(SplashScreenActivity.this);
        checkUser();
        finish();
    }

    @Override
    public void checkUser() {
        Intent intent = new Intent(SplashScreenActivity.this, TovarActivity.class);
        if(userPresenter.isAuthentificationUser()){
            intent = new Intent(SplashScreenActivity.this, TovarActivity.class);
        }
        startActivity(intent);
    }
}
