package com.example.scarybunny;

public interface IStateControl {

    IState makeRandomState();
    CuteBunny makeCuteBunnyState();
    ScaryBunny makeScaryBunnyState();

}
