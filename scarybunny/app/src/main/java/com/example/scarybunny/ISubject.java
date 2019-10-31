package com.example.scarybunny;



public interface ISubject {

    void attach(IObserver s);
    void detach(IObserver s);

    void notifyState();


}
