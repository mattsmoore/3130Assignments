/* Matthew Moore, B00767194, CSCI3130
   Dalhousie University
   Oct/Nov 2019
 */

package com.example.scarybunny;
import java.util.concurrent.ThreadLocalRandom;

public class StateControl implements IStateControl {


    // make a random state
    public State makeRandomState(){
        double d = ThreadLocalRandom.current().nextDouble();
        double scaryOdds = 0.1;
        if(d < scaryOdds) return new ScaryBunny();
        else return new CuteBunny();
    }

    // return scary bunny state
    public ScaryBunny makeScaryBunnyState(){
        return new ScaryBunny();
    }

    // return the cute bunny state
    public CuteBunny makeCuteBunnyState(){
        return new CuteBunny();
    }

}