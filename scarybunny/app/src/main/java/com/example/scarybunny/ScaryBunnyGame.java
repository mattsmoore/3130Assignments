package com.example.scarybunny;

public class ScaryBunnyGame {
    private static final ScaryBunnyGame ourInstance = new ScaryBunnyGame();

    public static ScaryBunnyGame getInstance() {
        return ourInstance;
    }

    private ScaryBunnyGame() {



    }
}
