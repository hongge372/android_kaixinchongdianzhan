package com.kx.kaixinchongdianzhan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initLayout();
    }

    private void initLayout(){
        View registerView = findViewById(R.id.layout_register);
        registerView.bringToFront();
        View loginView = findViewById(R.id.layout_login);
        loginView.setVisibility(View.GONE);
    }
}