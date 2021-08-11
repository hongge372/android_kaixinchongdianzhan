package com.kx.kaixinchongdianzhan.gamecontrol.pintu.characters;

public class CharactersGameInfo {
    private int holeLevel;
    private int curLevel;
    private static CharactersGameInfo gameInfo;
    private static Object createLock = new Object();
    
    private CharactersGameInfo(){}
    
    public static CharactersGameInfo getInstance(){
        if(gameInfo == null){
            synchronized(createLock){
                if(gameInfo == null){
                    gameInfo = new CharactersGameInfo();
                    gameInfo.init();
                }
            }
        }
        return gameInfo;
    }

    private void init() {
        //todo
        holeLevel = 256;
        curLevel = 26;
    }

    public int getHoleLevel(){
        return holeLevel;
    }

    public int getCurLevel(){
        return curLevel;
    }
}
