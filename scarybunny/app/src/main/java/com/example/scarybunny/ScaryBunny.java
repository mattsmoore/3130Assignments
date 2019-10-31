package com.example.scarybunny;



import java.util.Random;

public class ScaryBunny extends State {

    private int id;
    private int audioID;

    public int returnType(){
        return 0;
    }

    public int getResourceID(){
        return this.id;
    }

    public int getAudioID(){
        return this.audioID;
    }

    public void updateState(){

    }


    ScaryBunny(){
        this.id = R.drawable.scarybunny;
        int[] audioIDs = {R.raw.scary1, R.raw.scary2, R.raw.scary3};
        Random rand = new Random();
        int random = rand.nextInt(3);
        this.audioID = audioIDs[random];
    }

    public void handle(){
        ScaryBunnyGame.getInstance().currentState = ScaryBunnyGame.getInstance().stateControl.makeCuteBunnyState();

    }

}
