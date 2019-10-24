package com.example.scarybunny;

public class ScaryBunny implements IState {

    private int id;

    public int returnType(){
        return 0;
    }

    public int getResourceID(){
        return this.id;
    }

    ScaryBunny(){
        this.id = R.drawable.scarybunny;

    }

    public void handle(){
        ScaryBunnyGame.getInstance().currentState = new ScaryBunny();
        ScaryBunnyGame.getInstance().stateControl.makeScaryBunnyState();
    }

}
