package com.kx.kaixinchongdianzhan.store;

import android.content.Context;
import android.icu.number.CompactNotation;
import android.os.Environment;
import android.util.Log;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.kx.kaixinchongdianzhan.MainActivity;

import java.io.File;

public class Store {
    private String tag = getClass().getName();
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
        WebView webView = new WebView(mainContext);
        parentLayout.addView(webView);
        webView.getSettings().setJavaScriptEnabled(true);
        String webUrl ="http://192.168.27.76:8080/h5/pay.html";
        //使用http协议，需要在manifest里面加上：
        // android:usesCleartextTraffic="true"
        webView.loadUrl(webUrl);

//        File story = Environment.getExternalStorageDirectory();
//        String htmlPath = story.toString() + "/h5/pay.html";
//        Log.e(tag, "h5 path: " + htmlPath);
//        webView.getSettings().setAllowFileAccess(true);
//        webView.getSettings().setAllowContentAccess(true);
//        webView.loadUrl("file:///" + htmlPath);
        //test--->
        //webView.loadUrl("http://www.baidu.com/");
    }
}
