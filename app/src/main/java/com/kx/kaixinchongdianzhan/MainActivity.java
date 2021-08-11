package com.kx.kaixinchongdianzhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin;
    private Button btnRegister;
    private Button btnStart;
    private boolean ifRegister = true;
    private LoginManager loginManager = new LoginManager();

    private String userAccount;
    private String passWord;

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
        if(ifRegister){
            loginView.setVisibility(View.GONE);
            registerView.setVisibility(View.VISIBLE);
            registerView.bringToFront();
        }else {
            loginView.setVisibility(View.VISIBLE);
            loginView.bringToFront();
            registerView.setVisibility(View.GONE);
        }
    }

    private void initButtons(){
        btnLogin = (Button)findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        btnRegister = (Button)findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(this);
        btnStart = (Button)findViewById(R.id.btn_start);
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                ifRegister = false;
                chgViewLoginOrRegister();
                break;
            case R.id.btn_register:
                ifRegister = true;
                chgViewLoginOrRegister();
                break;
            case R.id.btn_start:
                login();
                break;
            default:
                break;
        }
    }

    private void login() {
        boolean prepareOk = confirmInfo();
        if(!prepareOk){
            return;
        }
        loginManager.ifRegister = ifRegister;
        loginManager.account = userAccount;
        loginManager.passWord = passWord;
        loginManager.login();
    }

    private boolean confirmInfo() {
        String repeat = null;
        if(ifRegister){
            userAccount =((EditText)findViewById(R.id.edit_register_account)).getText().toString();
            passWord =  ((EditText)findViewById(R.id.edit_register_password)).getText().toString();
            repeat = ((EditText)findViewById(R.id.edit_repeat_password)).getText().toString();
        }else{
            userAccount = ((EditText)findViewById(R.id.edit_login_account)).getText().toString();
            passWord =  ((EditText)findViewById(R.id.edit_login_password)).getText().toString();
        }

        if(userAccount == null || userAccount.equals("")){
            toastErr("用户名不能为空");
            return false;
        }

        if(passWord == null || passWord.equals("")){
            toastErr("密码不能为空");
            return false;
        }

        if(!LoginManager.ifRational(userAccount)){
            toastErr("用户名非法，请使用字符数字和下划线");;
            return false;
        }

        if(!LoginManager.ifRational(passWord)){
            toastErr("密码非法，请使用字符数字和下划线");;
            return false;
        }

        if(ifRegister && !passWord.equals(repeat)){
            toastErr("两次密码不一致");;
            return false;
        }
        return true;
    }

    private void toastErr(String err){
        Toast.makeText(this,err,Toast.LENGTH_LONG).show();
    }
}