package game;

import game.interaction.Interaction;
import game.level.Level;
import graphics.Sprite;
import graphics.SpriteSheet;
import graphics.TextureAtlas;
import io.Input;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;


public class Player extends Entity {
    public static final int SPRITE_SCALE = 64;
    public static final int SPRITES_PER_HEADING = 2;

    public enum Heading {
        NORTH(0 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        NORTH_ANIMATION(1 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        EAST(2 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        EAST_ANIMATION(3 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        SOUTH(4 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        SOUTH_ANIMATION(5 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        WEST(6 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        WEST_ANIMATION(7 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE);

        private int x, y, h, w;

        Heading(int x, int y, int h, int w) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.w = w;
        }

        protected BufferedImage texture(TextureAtlas atlas) {
            return atlas.cut(x, y, h, w);
        }

    }

    private Heading heading;
    private Map<Heading, Sprite> spriteMap;
    private float scale;
    private float speed;
    private Interaction interaction;
    private int count = 0;


    public Player(float x, float y, float scale, float speed, TextureAtlas atlas, Interaction interaction) {
        super(EntityType.PLAYER, x, y);
        heading = Heading.NORTH;
        spriteMap = new HashMap<Heading, Sprite>();
        this.scale = scale;
        this.speed = speed;
        this.interaction = interaction;

        for (Heading h : Heading.values()) {
            SpriteSheet sheet = new SpriteSheet(h.texture(atlas), SPRITES_PER_HEADING, SPRITE_SCALE);
            Sprite sprite = new Sprite(sheet, scale);
            spriteMap.put(h, sprite);
        }
    }

    @Override
    public void update(Input input, float a, float b) {
        float tankX = x;
        float tankY = y;
        if (count > 1) count = 0;
        if (input.getKey(KeyEvent.VK_SPACE)) {
            fire(x, y);
        }
        if (input.getKey(KeyEvent.VK_UP)) {
            tankY -= speed;
            if (count == 0) {
                heading = Heading.NORTH;
            }
            if (count > 0) {
                heading = Heading.NORTH_ANIMATION;
            }
        } else if (input.getKey(KeyEvent.VK_RIGHT)) {
            tankX += speed;
            if (count == 0) {
                heading = Heading.EAST;
            }
            if (count > 0) {
                heading = Heading.EAST_ANIMATION;
            }
        } else if (input.getKey(KeyEvent.VK_DOWN)) {
            tankY += speed;
            if (count == 0) {
                heading = Heading.SOUTH;
            }
            if (count > 0) {
                heading = Heading.SOUTH_ANIMATION;
            }
        } else if (input.getKey(KeyEvent.VK_LEFT)) {
            tankX -= speed;
            if (count == 0) {
                heading = Heading.WEST;
            }
            if (count > 0) {
                heading = Heading.WEST_ANIMATION;
            }
        }
        if (tankX < 0) {
            tankX = 0;
        } else if (tankX >= Game.WIDTH - SPRITE_SCALE * scale) {
            tankX = Game.WIDTH - SPRITE_SCALE * scale;
        }
        if (tankY < 0) {
            tankY = 0;
        } else if (tankY >= Game.HEIGHT - SPRITE_SCALE * scale) {
            tankY = Game.HEIGHT - SPRITE_SCALE * scale;
        }
        count++;
        for (Point p : Level.waterCords)
            if ((tankX > p.x - Level.TILE_SCALE) && (tankX < p.x + Level.TILE_SCALE) && (tankY > p.y - Level.TILE_SCALE) && (tankY < p.y + Level.TILE_SCALE)) {
                if (input.getKey(KeyEvent.VK_UP)) tankY += speed;
                else if (input.getKey(KeyEvent.VK_RIGHT)) tankX -= speed;
                else if (input.getKey(KeyEvent.VK_DOWN)) tankY -= speed;
                else if (input.getKey(KeyEvent.VK_LEFT)) tankX += speed;
            }
        for (Point q : Level.metalCords)
            if ((tankX > q.x - Level.TILE_SCALE) && (tankX < q.x + Level.TILE_SCALE) && (tankY > q.y - Level.TILE_SCALE) && (tankY < q.y + Level.TILE_SCALE)) {
                if (input.getKey(KeyEvent.VK_UP)) tankY += speed;
                else if (input.getKey(KeyEvent.VK_RIGHT)) tankX -= speed;
                else if (input.getKey(KeyEvent.VK_DOWN)) tankY -= speed;
                else if (input.getKey(KeyEvent.VK_LEFT)) tankX += speed;
            }
        for (Point q : Level.brickCords)
            if ((tankX > q.x - Level.TILE_SCALE) && (tankX < q.x + Level.TILE_SCALE) && (tankY > q.y - Level.TILE_SCALE) && (tankY < q.y + Level.TILE_SCALE)) {
                if (input.getKey(KeyEvent.VK_UP)) tankY += speed;
                else if (input.getKey(KeyEvent.VK_RIGHT)) tankX -= speed;
                else if (input.getKey(KeyEvent.VK_DOWN)) tankY -= speed;
                else if (input.getKey(KeyEvent.VK_LEFT)) tankX += speed;
            }
        x = tankX;
        y = tankY;
    }

    @Override
    public void render(Graphics2D g) {
        spriteMap.get(heading).render(g, x, y);

    }

    public void fire(float tankInteractionX, float tankInteractionY) {
        if (!interaction.getGame().getBullet().isActive()) {
            if (heading == Heading.NORTH || heading == Heading.NORTH_ANIMATION) {
                tankInteractionX += Bullet.SPRITE_BULLET;
                tankInteractionY -= Bullet.SPRITE_BULLET;
            } else if (heading == Heading.SOUTH || heading == Heading.SOUTH_ANIMATION) {
                tankInteractionX += Bullet.SPRITE_BULLET;
                tankInteractionY += Bullet.SPRITE_BULLET_MOVE;
            } else if (heading == Heading.WEST || heading == Heading.WEST_ANIMATION) {
                tankInteractionX -= Bullet.SPRITE_BULLET;
                tankInteractionY += Bullet.SPRITE_BULLET;
            } else if (heading == Heading.EAST || heading == Heading.EAST_ANIMATION) {
                tankInteractionX += Bullet.SPRITE_BULLET_MOVE;
                tankInteractionY += Bullet.SPRITE_BULLET;
            }
            interaction.getGame().getBullet().activate(tankInteractionX, tankInteractionY, heading);
        }
    }

}
