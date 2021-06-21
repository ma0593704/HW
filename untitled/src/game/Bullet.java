package game;


import game.interaction.Interaction;
import graphics.Sprite;
import graphics.SpriteSheet;
import graphics.TextureAtlas;
import io.Input;

import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class Bullet extends Entity {
    public static final int SPRITE_SCALE = 16;
    public static final int SPRITES_PER_HEADING = 1;
    public static final int SPRITE_BULLET = 12;
    public static final int SPRITE_BULLET_MOVE = 32;

    private enum Heading {
        NORTH(12 * SPRITE_SCALE, 0 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        EAST(14 * SPRITE_SCALE, 2 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        SOUTH(12 * SPRITE_SCALE, 2 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE),
        WEST(14 * SPRITE_SCALE, 0 * SPRITE_SCALE, 1 * SPRITE_SCALE, 1 * SPRITE_SCALE);

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
    private Map<Bullet.Heading, Sprite> spriteMap;
    private float scale;
    private float speed;
    private boolean active;
    private Interaction interaction;
    

    public Bullet(float x, float y, float scale, float speed, TextureAtlas atlas, Interaction interaction) {
        super(EntityType.BULLET, x, y);
        heading = Heading.NORTH;
        spriteMap = new HashMap<Heading, Sprite>();
        this.scale = scale;
        this.speed = speed;
        this.active = false;
        this.interaction = interaction;
        for (Heading h : Heading.values()) {
            SpriteSheet sheet = new SpriteSheet(h.texture(atlas), SPRITES_PER_HEADING, SPRITE_SCALE);
            Sprite sprite = new Sprite(sheet, scale);
            spriteMap.put(h, sprite);
        }
    }

    @Override
    public void update(Input input, float tanX, float tanY) {
        float bulletX = x;
        float bulletY = y;
        if (bulletX < 0 || bulletY < 0 || bulletX > Game.WIDTH || bulletY > Game.HEIGHT) {
            deactivate();
        }


        if (interaction.getGame().getPlayer().getHeading() == Player.Heading.NORTH ) {
            // bulletX = tankX + SPRITE_BULLET;
            // bulletY = tankY - SPRITE_BULLET;

            heading = Heading.NORTH;
            bulletY -= speed;
        }
        if (interaction.getGame().getPlayer().getHeading() == Player.Heading.SOUTH ) {
            //bulletX = tankX + SPRITE_BULLET;
            //bulletY = tankY + SPRITE_BULLET_MOVE;

            heading = Heading.SOUTH;
            bulletY += speed;
        }if (interaction.getGame().getPlayer().getHeading() == Player.Heading.WEST ) {
            //bulletX = tankX - SPRITE_BULLET;
            //bulletY = tankY + SPRITE_BULLET;

            heading = Heading.WEST;
            bulletX -= speed;
        }if (interaction.getGame().getPlayer().getHeading() == Player.Heading.EAST ) {
            //bulletX = tankX + SPRITE_BULLET_MOVE;
            //bulletY = tankY + SPRITE_BULLET;

            heading = Heading.EAST;
            bulletX += speed;
        }
        x = bulletX;
        y = bulletY;
    }

    @Override
    public void render(Graphics2D g) {
        if (isActive())
            spriteMap.get(heading).render(g, x, y);

    }

    public void activate(float tankInteractionX, float tankInteractionY, Input input) {
        this.active = true;
        this.x = tankInteractionX;
        this.y = tankInteractionY;
    }

    public void deactivate() {
        active = false;
    }

    public boolean isActive() {
        return active;
    }

    public float getSpeed() {
        return speed;
    }

}
