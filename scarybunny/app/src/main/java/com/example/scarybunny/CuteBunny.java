package com.example.scarybunny;


import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CuteBunny implements IState {

    private int id;

    public int getAudioID(){
        return 0;
    }

    public int returnType(){
        return 1;
    }

    public int getResourceID(){
        return this.id;
    }

    CuteBunny(){

        int[] resourceIDs = {R.drawable.cutebunny1, R.drawable.cutebunny2, R.drawable.cutebunny3, R.drawable.cutebunny4};

        Random rand = new Random();
        int random = rand.nextInt(4);
        this.id = resourceIDs[random];

    }

    public void handle(){

        ScaryBunnyGame.getInstance().currentState = new CuteBunny();
        ScaryBunnyGame.getInstance().stateControl.makeCuteBunnyState();

    }


}
