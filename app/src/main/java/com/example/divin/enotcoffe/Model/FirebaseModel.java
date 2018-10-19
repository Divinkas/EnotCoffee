package com.example.divin.enotcoffe.Model;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirebaseModel {

    private Context context;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    public FirebaseModel(Context context) {
        this.context = context;
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
    }

    public boolean isAuthUser(){
        return currentUser != null;
    }
}
