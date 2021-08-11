package com.kx.kaixinchongdianzhan.gamecontrol.pintu.characters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.kx.kaixinchongdianzhan.R;

public class CharactersGameSlider {
    private String tag = getClass().getName();
    private int perLine = 3;
    private Context mainContext;
    LinearLayout parentLayout;

    public CharactersGameSlider(Context context, LinearLayout parent){
        mainContext = context;
        parentLayout = parent;
    }

    public void showView(){
        CharactersGameInfo gameInfo = CharactersGameInfo.getInstance();
        int holeLevel = gameInfo.getHoleLevel();
        int curLevel = gameInfo.getCurLevel();
        for(int i=0;i<holeLevel/perLine;i++){
            LinearLayout liner = new LinearLayout(mainContext);
            LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER_HORIZONTAL;
            liner.setLayoutParams(params);
            Button[] buttons = new Button[perLine];
            for(int j=0;j<perLine;j++){
                String text = "第" + (i+j) + "关";
                buttons[j] = new Button(mainContext);
                buttons[j].setText(text);
                liner.addView(buttons[j],params);
            }
            liner.setBackgroundColor(0xEE82EE);
            liner.bringToFront();
            parentLayout.addView(liner);
        }
    }
}
