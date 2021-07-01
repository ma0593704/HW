package application;

import display.Display;
import game.Game;


public class Main {
    public static void main(String[] args) {
        Display.create(800, 608, "Tanks", 0Xff000000, 3);

        Game tanks = new Game();
        tanks.start();

    }
}
