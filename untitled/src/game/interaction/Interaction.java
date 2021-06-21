package game.interaction;

import game.Bullet;
import game.Game;
import game.Player;


import java.awt.*;

public class Interaction {

    private Player player;
    private Bullet bullet;
    private Game game;


    public Game getGame() {
        return game;
    }


    public Interaction(Game game) {
        this.game=game;
    }
    public Interaction(Player player,Bullet bullet,Game game) {
        this.game=game;
        this.player=player;
        this.bullet=bullet;
    }


}

