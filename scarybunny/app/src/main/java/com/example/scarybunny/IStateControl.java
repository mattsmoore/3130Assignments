package com.example.scarybunny;

public interface IStateControl {

    State makeRandomState();
    CuteBunny makeCuteBunnyState();
    ScaryBunny makeScaryBunnyState();

}
