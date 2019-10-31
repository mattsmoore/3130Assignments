package com.example.scarybunny;

import android.os.CountDownTimer;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class Subject implements ISubject {


    private ArrayList<IObserver> observers;

    Subject(){
        observers = new ArrayList<>();

        long randomNum = ThreadLocalRandom.current().nextLong(10000, 20000);
        CountDownTimer timer = new CountDownTimer(randomNum, randomNum) {
            @Override
            public void onTick(long millisUntilFinished) {
                // nothing
            }

            @Override
            public void onFinish() {
                notifyState();
            }
        };
        timer.start();

    }

    public void attach(IObserver s){
        observers.add(s);

    }
    public void detach(IObserver s){
        observers.remove(s);
    }

    public void notifyState(){
       for(IObserver x : observers){
            x.updateState();
        }
        long randomNum = ThreadLocalRandom.current().nextLong(10000, 20000);
        CountDownTimer timer = new CountDownTimer(randomNum, randomNum) {
            @Override
            public void onTick(long millisUntilFinished) {
                // nothing
            }

            @Override
            public void onFinish() {
                notifyState();
            }
        };
        timer.start();
    }


}