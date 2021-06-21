package game.level;

import game.Game;
import graphics.TextureAtlas;
import utils.Utils;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Level {


    public static final int TILE_SCALE = 32;
    public static final int TILE_IN_GAME_SCALE = 1;
    public static final int SCALED_TILE_SIZE = TILE_SCALE * TILE_IN_GAME_SCALE;
    public static final int TILE_IN_WITDH = Game.WIDTH / SCALED_TILE_SIZE;
    public static final int TILE_IN_HEIGHT = Game.HEIGHT / SCALED_TILE_SIZE;


    private Integer[][] tileMap;
    private Map<TileType, Tile> tiles;
    private List<Point> grassCords;
    private List<Point> brickCords;
    public static List<Point> waterCords;
    public static List<Point> metalCords;

    public Level(TextureAtlas atlas) {
        tileMap = new Integer[TILE_IN_WITDH][TILE_IN_HEIGHT];
        tiles = new HashMap<>();
        tiles.put(TileType.BRICK, new Tile(atlas.cut(1 * TILE_SCALE, 0 * TILE_SCALE, TILE_SCALE, TILE_SCALE), TILE_IN_GAME_SCALE, TileType.BRICK));
        tiles.put(TileType.METAL, new Tile(atlas.cut(2 * TILE_SCALE, 0 * TILE_SCALE, TILE_SCALE, TILE_SCALE), TILE_IN_GAME_SCALE, TileType.METAL));
        tiles.put(TileType.WATER, new Tile(atlas.cut(1 * TILE_SCALE, 1 * TILE_SCALE, TILE_SCALE, TILE_SCALE), TILE_IN_GAME_SCALE, TileType.WATER));
        tiles.put(TileType.GRASS, new Tile(atlas.cut(3 * TILE_SCALE, 0 * TILE_SCALE, TILE_SCALE, TILE_SCALE), TILE_IN_GAME_SCALE, TileType.GRASS));
        tiles.put(TileType.ICE, new Tile(atlas.cut(4 * TILE_SCALE, 0 * TILE_SCALE, TILE_SCALE, TILE_SCALE), TILE_IN_GAME_SCALE, TileType.ICE));
        tiles.put(TileType.EMPTY, new Tile(atlas.cut(0 * TILE_SCALE, 0 * TILE_SCALE, TILE_SCALE, TILE_SCALE), TILE_IN_GAME_SCALE, TileType.EMPTY));

        tileMap = Utils.levelParser("res/level.lvl");
        grassCords = new ArrayList<>();
        brickCords = new ArrayList<>();
        waterCords = new ArrayList<>();
        metalCords = new ArrayList<>();
        for (int i = 0; i < tileMap.length; i++) {
            for (int j = 0; j < tileMap[i].length; j++) {
                Tile tile = tiles.get(TileType.fromNumeric(tileMap[i][j]));
                if (tile.type() == TileType.GRASS)
                    grassCords.add(new Point(j * SCALED_TILE_SIZE, i * SCALED_TILE_SIZE));
                if (tile.type() == TileType.WATER)
                    waterCords.add(new Point(j * SCALED_TILE_SIZE, i * SCALED_TILE_SIZE));
                if (tile.type() == TileType.METAL)
                    metalCords.add(new Point(j * SCALED_TILE_SIZE, i * SCALED_TILE_SIZE));
                if (tile.type() == TileType.BRICK)
                    brickCords.add(new Point(j * SCALED_TILE_SIZE, i * SCALED_TILE_SIZE));
            }
        }
    }

    public void update() {

    }

    public void render(Graphics2D g) {
        for (int i = 0; i < tileMap.length; i++) {
            for (int j = 0; j < tileMap[i].length; j++) {
                Tile tile = tiles.get(TileType.fromNumeric(tileMap[i][j]));
                if (tile.type() != TileType.GRASS)
                    tile.render(g, j * SCALED_TILE_SIZE, i * SCALED_TILE_SIZE);
            }
        }
    }

    public void renderGrass(Graphics2D g) {
        for (Point p : grassCords) {
            tiles.get(TileType.GRASS).render(g, p.x, p.y);
        }

    }
    public void renderBrick(Graphics2D g) {
        for (Point p : brickCords) {
            tiles.get(TileType.BRICK).render(g, p.x, p.y);
        }

    }

}
