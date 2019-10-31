package com.example.scarybunny;

abstract class State implements IObserver {

    abstract int returnType();
    abstract int getResourceID();
    abstract void handle();
    abstract int getAudioID();

}
