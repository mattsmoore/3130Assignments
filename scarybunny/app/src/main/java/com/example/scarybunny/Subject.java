package com.example.scarybunny;

import java.util.Observer;

public interface Subject {

    public void attach(Observer o);
    public void detach(Observer o);

    public void notifyState();


}
