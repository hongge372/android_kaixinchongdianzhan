package com.kx.kaixinchongdianzhan;

import android.util.Log;

import com.kx.kaixinchongdianzhan.httprequest.JsonKey;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginManager {
    private String tag = getClass().getName();
    public boolean ifRegister;
    public String account;
    public String passWord;

    public void login() {
        JSONObject loginJson = new JSONObject();
        if(ifRegister){
            Log.e(tag, "user register");
        }else {
            Log.e(tag, "user login");
        }
        try {
            loginJson.put(JsonKey.USER_NAME, account);
            loginJson.put(JsonKey.PASS_WORD, passWord);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.v(tag, "account: " + account + " pass word: " + passWord);

    }

    public static boolean ifRational(String data){
        return true;
    }
}
