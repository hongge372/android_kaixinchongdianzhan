package com.kx.kaixinchongdianzhan.gamecontrol.pintu.characters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
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

import com.kx.kaixinchongdianzhan.R;
import com.kx.kaixinchongdianzhan.store.Store;

public class GamingActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnGaming;
    private Button btnStore;
    private Button btnMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_pager);
        initView();
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
        switch (view.getId()){
            case R.id.btn_gaming_character:
                LinearLayout parent = findViewById(R.id.layout_characters_game);
                parent.setBackgroundColor(Color.YELLOW);
                CharactersGameSlider slider = new CharactersGameSlider(getApplicationContext(), parent);
                slider.showView();
                break;
            case R.id.btn_store:
                    Store store = new Store();
                break;
            case R.id.btn_me:
                break;
        }
    }
}
