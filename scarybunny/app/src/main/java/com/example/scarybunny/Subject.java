/* Matthew Moore, B00767194, CSCI3130
   Dalhousie University
   Oct/Nov 2019
 */

package com.example.scarybunny;

import android.os.CountDownTimer;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class Subject implements ISubject {


    // list of observers
    private ArrayList<IObserver> observers;

    // upon initiation, create an arraylist, start timer
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

    // attach to the observers list
    public void attach(IObserver s){
        observers.add(s);
    }

    // detach from the observers list
    public void detach(IObserver s){
        observers.remove(s);
    }

    // notify the states that the timer had gone off, start new timer
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