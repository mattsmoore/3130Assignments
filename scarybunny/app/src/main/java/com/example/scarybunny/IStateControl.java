/* Matthew Moore, B00767194, CSCI3130
   Dalhousie University
   Oct/Nov 2019
 */

package com.example.scarybunny;

public interface IStateControl {

    State makeRandomState();
    CuteBunny makeCuteBunnyState();
    ScaryBunny makeScaryBunnyState();

}
