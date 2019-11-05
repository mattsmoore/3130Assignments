/* Matthew Moore, B00767194, CSCI3130
   Dalhousie University
   Oct/Nov 2019
 */

package com.example.scarybunny;

import java.util.Random;

public class ScaryBunny extends State {

    private int id;
    private int audioID;


    // return image ID
    public int getResourceID(){
        return this.id;
    }

    // return audio ID
    public int getAudioID(){
        return this.audioID;
    }

    // Observer update method
    public void updateState(){
        // Do nothing if in ScaryBunny State
    }


    // initiate the state with the ids of the images and audio, pick random audio
    ScaryBunny(){
        this.id = R.drawable.scarybunny;
        int[] audioIDs = {R.raw.scary1, R.raw.scary2, R.raw.scary3};
        Random rand = new Random();
        int random = rand.nextInt(3);
        this.audioID = audioIDs[random];
    }

    // handle method for onClick, changes state
    public void handle(){
        ScaryBunnyGame.getInstance().currentState = ScaryBunnyGame.getInstance().stateControl.makeCuteBunnyState();

    }

}
