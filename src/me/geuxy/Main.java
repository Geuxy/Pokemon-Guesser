package me.geuxy;

import me.geuxy.gui.LoadingScreen;
import me.geuxy.gui.GameScreen;

public class Main {

    public static void main(String[] args) {
        LoadingScreen loadingScreen = new LoadingScreen();
        new GameScreen(loadingScreen);
    }

}
