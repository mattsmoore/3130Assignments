/* Matthew Moore, B00767194, CSCI3130
   Dalhousie University
   Oct/Nov 2019
 */

package com.example.scarybunny;

class ScaryBunnyGame {

    StateControl stateControl;
    State currentState;
    Subject subject;
    private IStateListener listener;
    private static final ScaryBunnyGame ourInstance = new ScaryBunnyGame();

    // singleton is only accessed by this method so it always returns the same singleton
    static ScaryBunnyGame getInstance() {
        return ourInstance;
    }

    // When initiating the singleton also initiate a subject and a state controller
    private ScaryBunnyGame() {
        this.stateControl = new StateControl();
        subject = new Subject();
    }

    // method notify the listening that we want to update upon timer
    void notifyStateListener() {
        if(this.listener != null) {
            listener.update();
        }
    }

    // method to register the MainActivity with the listener
    void registerStateListener(IStateListener listener) {
        this.listener = listener;
    }

    // process of going to the next image
    int nextImg(){

        // if we are just starting
        if(currentState == null){
            this.currentState = stateControl.makeCuteBunnyState();
            subject.attach(currentState);
        }
        // otherwise detach, handle, and attach
        else {
            subject.detach(currentState);
            this.currentState.handle();
            subject.attach(currentState);
        }

        // return the current states image ID
        return currentState.getResourceID();

    }
}
