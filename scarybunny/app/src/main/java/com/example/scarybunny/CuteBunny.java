package com.example.scarybunny;


import java.util.Random;

public class CuteBunny extends State {

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

    public void updateState(){

        ScaryBunnyGame.getInstance().subject.detach(ScaryBunnyGame.getInstance().currentState);
        ScaryBunnyGame.getInstance().currentState = ScaryBunnyGame.getInstance().stateControl.makeScaryBunnyState();
        ScaryBunnyGame.getInstance().subject.attach(ScaryBunnyGame.getInstance().currentState);
        ScaryBunnyGame.getInstance().notifyStateListener();

    }

    CuteBunny(){

        int[] resourceIDs = {R.drawable.cutebunny1, R.drawable.cutebunny2, R.drawable.cutebunny3, R.drawable.cutebunny4};

        Random rand = new Random();
        int random = rand.nextInt(4);
        this.id = resourceIDs[random];

    }

    public void handle(){
        ScaryBunnyGame.getInstance().currentState = ScaryBunnyGame.getInstance().stateControl.makeRandomState();

    }


}
