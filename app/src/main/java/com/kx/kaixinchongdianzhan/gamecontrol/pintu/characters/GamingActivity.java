package com.kx.kaixinchongdianzhan.gamecontrol.pintu.characters;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.kx.kaixinchongdianzhan.R;
import com.kx.kaixinchongdianzhan.store.Store;

public class GamingActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnGaming;
    private Button btnStore;
    private Button btnMe;

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.INTERNET,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_NETWORK_STATE};
    private static int REQUEST_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_pager);
        initView();
        permissionRequest();
    }

    private void initView(){
        btnGaming = (Button)findViewById(R.id.btn_gaming_character);
        btnGaming.setOnClickListener(this);
        btnStore = (Button)findViewById(R.id.btn_store);
        btnStore.setOnClickListener(this);
        btnMe = (Button)findViewById(R.id.btn_me);
        btnMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        LinearLayout parent = findViewById(R.id.layout_characters_game);
        parent.setBackgroundColor(Color.YELLOW);
        switch (view.getId()){
            case R.id.btn_gaming_character:
                CharactersGameSlider slider = new CharactersGameSlider(getApplicationContext(), parent);
                slider.showView();
                break;
            case R.id.btn_store:
                    Store store = new Store(getApplicationContext(), parent);
                    store.showEquipage();
                break;
            case R.id.btn_me:
                break;
        }
    }

    private void permissionRequest(){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
        }
    }
}
