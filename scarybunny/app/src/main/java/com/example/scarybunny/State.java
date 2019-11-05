/* Matthew Moore, B00767194, CSCI3130
   Dalhousie University
   Oct/Nov 2019
 */

package com.example.scarybunny;

abstract class State implements IObserver {

    abstract int getResourceID();
    abstract void handle();
    abstract int getAudioID();

}
