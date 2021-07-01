package game.interaction;

import game.Bullet;
import game.Game;
import game.Player;
import game.level.Level;


public class Interaction {

    private Player player;
    private Bullet bullet;
    private Game game;
    private Level level;


    public Game getGame() {
        return game;
    }

    public Interaction(Game game) {
        this.game=game;
    }
    public Interaction(Player player,Bullet bullet,Game game, Level level) {
        this.game=game;
        this.player=player;
        this.bullet=bullet;
        this.level=level;
    }


}

