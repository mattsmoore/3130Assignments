/* Matthew Moore, B00767194, CSCI3130
   Dalhousie University
   Oct/Nov 2019
 */

package com.example.scarybunny;


import java.util.Random;

public class CuteBunny extends State {

    private static int prevNum = -1;

    private int id;

    public int getAudioID(){
        return 0;
    }

    public int getResourceID(){
        return this.id;
    }


    // update the subject after notify is called and start the state change
    public void updateState(){

        ScaryBunnyGame.getInstance().subject.detach(ScaryBunnyGame.getInstance().currentState);
        ScaryBunnyGame.getInstance().currentState = ScaryBunnyGame.getInstance().stateControl.makeScaryBunnyState();
        ScaryBunnyGame.getInstance().subject.attach(ScaryBunnyGame.getInstance().currentState);
        ScaryBunnyGame.getInstance().notifyStateListener();

    }

    // initiate the state with the ids of the images, pick one at random
    CuteBunny(){

        int[] resourceIDs = {R.drawable.cutebunny1, R.drawable.cutebunny2, R.drawable.cutebunny3, R.drawable.cutebunny4};

        Random rand = new Random();
        int random = rand.nextInt(4);
        if(random == prevNum){
            random = (random+1)%resourceIDs.length;
        }
        prevNum = random;
        this.id = resourceIDs[random];

    }

    // handle method for onClick, changes state
    public void handle(){
        ScaryBunnyGame.getInstance().currentState = ScaryBunnyGame.getInstance().stateControl.makeRandomState();

    }


}
