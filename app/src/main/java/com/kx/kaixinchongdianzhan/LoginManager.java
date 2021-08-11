package com.kx.kaixinchongdianzhan;

import android.util.Log;

public class LoginManager {
    private String tag = getClass().getName();
    public boolean ifRegister;
    public String account;
    public String passWord;

    public void login() {
        if(ifRegister){
            Log.e(tag, "user register");
        }else {
            Log.e(tag, "user login");
        }
        Log.v(tag, "account: " + account + " pass word: " + passWord);
    }

    public static boolean ifRational(String data){
        return true;
    }
}
