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

public class CharactersGameSlider {
    private String tag = getClass().getName();
    private int perLine = 3;
    private Context mainContext;
    private ScrollView scrollView;
    private RelativeLayout parentLayout;

    public CharactersGameSlider(Context context, RelativeLayout parent){
        mainContext = context;
        parentLayout = parent;
        scrollView = new ScrollView(context);
    }

    public void showView(){
        CharactersGameInfo gameInfo = CharactersGameInfo.getInstance();
        int holeLevel = gameInfo.getHoleLevel();
        int curLevel = gameInfo.getCurLevel();
        RelativeLayout.LayoutParams rlp=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        for(int i=0;i<holeLevel/perLine;i++){
            LinearLayout liner = new LinearLayout(mainContext);
            LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            //params.layout_gravity = Gravity.CENTER_HORIZONTAL;
            liner.setLayoutParams(params);
            //liner.setOrientation(LinearLayout.HORIZONTAL);
            Button[] buttons = new Button[perLine];
            perLine = 1;
            for(int j=0;j<perLine;j++){
                String text = "第" + (i+j) + "关";
                buttons[j] = new Button(mainContext);
                buttons[j].setText(text);
                liner.addView(buttons[j]);
            }
            liner.setBackgroundColor(0xEE82EE);
            liner.bringToFront();
            parentLayout.addView(liner,rlp);
        }
    }
}
