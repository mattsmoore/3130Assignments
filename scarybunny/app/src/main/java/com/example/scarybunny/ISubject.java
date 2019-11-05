/* Matthew Moore, B00767194, CSCI3130
   Dalhousie University
   Oct/Nov 2019
 */

package com.example.scarybunny;

public interface ISubject {

    void attach(IObserver s);
    void detach(IObserver s);

    void notifyState();


}
