package com.example.scarybunny;
import java.util.concurrent.ThreadLocalRandom;

public class StateControl implements IStateControl {

    public IState makeRandomState(){
        double d = ThreadLocalRandom.current().nextDouble();
        double scaryOdds = 0.1;
        if(d < scaryOdds) return new ScaryBunny();
        else return new CuteBunny();
    }

    public ScaryBunny makeScaryBunnyState(){
        return new ScaryBunny();
    }

    public CuteBunny makeCuteBunnyState(){
        return new CuteBunny();
    }

}