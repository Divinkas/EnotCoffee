package com.example.divin.enotcoffe.Presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.divin.enotcoffe.Contract.SplashView;
import com.example.divin.enotcoffe.Model.FirebaseModel;

@InjectViewState
public class CheckUserPresenter extends MvpPresenter<SplashView> {
    private Context context;
    private FirebaseModel firebaseModel;

    public CheckUserPresenter() {
    }

    public void setContextActivity(Context context){
        if(this.context == null){
            this.context = context;
            firebaseModel = new FirebaseModel(context);
        }
    }

    public boolean isAuthentificationUser(){
        return firebaseModel.isAuthUser();
    }
}
