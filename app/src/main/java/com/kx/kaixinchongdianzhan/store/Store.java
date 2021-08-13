package com.kx.kaixinchongdianzhan.store;

import android.content.Context;
import android.icu.number.CompactNotation;
import android.widget.LinearLayout;

public class Store {
    private LinearLayout parentLayout;
    private Context mainContext;

    public Store(Context context, LinearLayout parent){
        mainContext = context;
        parentLayout = parent;
    }

    public void showEquipage(){
        webPay();
    }

    public void webPay(){

    }
}
