package com.example.scarybunny;

class ScaryBunnyGame {

    StateControl stateControl;
    State currentState;
    Subject subject;
    private IStateListener listener;


    private static final ScaryBunnyGame ourInstance = new ScaryBunnyGame();

    static ScaryBunnyGame getInstance() {
        return ourInstance;
    }

    private ScaryBunnyGame() {
        this.stateControl = new StateControl();
        subject = new Subject();
    }

    public void notifyStateListener() {
        if(this.listener != null) {
            listener.update();
        }
    }

    public void registerStateListener(IStateListener listener) {
        this.listener = listener;
    }

    int nextImg(){
        if(currentState == null){
            this.currentState = stateControl.makeCuteBunnyState();
            subject.attach(currentState);
        }
        else {
            subject.detach(currentState);
            this.currentState.handle();
            subject.attach(currentState);
        }

        return currentState.getResourceID();

    }
}
