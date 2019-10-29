package com.example.scarybunny;

class ScaryBunnyGame {

    StateControl stateControl;
    IState currentState;

    private static final ScaryBunnyGame ourInstance = new ScaryBunnyGame();

    static ScaryBunnyGame getInstance() {
        return ourInstance;
    }

    private ScaryBunnyGame() {
        this.stateControl = new StateControl();
    }



    int nextImg(){
        if(currentState == null){
            this.currentState = stateControl.makeCuteBunnyState();
        }
        else {
            this.currentState.handle();
        }

        return currentState.getResourceID();
    }
}
