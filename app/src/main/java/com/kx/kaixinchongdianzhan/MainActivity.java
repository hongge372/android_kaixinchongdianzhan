package com.kx.kaixinchongdianzhan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin;
    private Button btnRegister;
    private boolean showLoginView = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initLayout();
        initButtons();
    }

    private void initLayout(){
        chgViewLoginOrRegister();
    }

    private void chgViewLoginOrRegister(){
        View registerView = findViewById(R.id.layout_register);
        View loginView = findViewById(R.id.layout_login);
        if(showLoginView){
            loginView.setVisibility(View.VISIBLE);
            loginView.bringToFront();
            registerView.setVisibility(View.GONE);
        }else {
            loginView.setVisibility(View.GONE);
            registerView.setVisibility(View.VISIBLE);
            registerView.bringToFront();
        }
    }

    private void initButtons(){
        btnLogin = (Button)findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        btnRegister = (Button)findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                showLoginView = true;
                chgViewLoginOrRegister();
                break;
            case R.id.btn_register:
                showLoginView = false;
                chgViewLoginOrRegister();
                break;
            default:
                break;
        }
    }
}