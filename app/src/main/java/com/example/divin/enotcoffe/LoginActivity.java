package com.example.divin.enotcoffe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.divin.enotcoffe.Contract.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends MvpAppCompatActivity implements LoginView {

    @BindView(R.id.etLogin)
    public EditText etLogin;

    @BindView(R.id.etPassword)
    public EditText etPassword;

    @BindView(R.id.btnLogin)
    public Button btnLogin;

    @BindView(R.id.tv_goto_registration_page)
    public TextView tvRegistration;

    @OnClick(R.id.btnLogin)
    void openTovarActivity(){
        Intent intent = new Intent(LoginActivity.this, TovarActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(LoginActivity.this);
    }
}
