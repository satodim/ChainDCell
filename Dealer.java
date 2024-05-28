package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Dealer {
    public int x, y;
    int speed;
    Texture texture;
    Texture[] framesArray;
    int frameCounter;
    int width, height;

    public Dealer(int x, int y, Texture texture, int speed, int width, int height) {
        this.x = x;
        this.y = y;
        this.texture = new Texture("TraderIdle_F0.png");
        this.speed = speed;
        this.width = width;
        this.height = height;
        framesArray = new Texture[]{
                new Texture("TraderIdle_F0.png"),
                new Texture("TraderIdle_F1.png"),
                new Texture("TraderIdle_F2.png"),
                new Texture("TraderIdle_F3.png"),
                new Texture("TraderIdle_F4.png"),
                new Texture("TraderIdle_F5.png"),
                new Texture("TraderIdle_F6.png"),
                new Texture("TraderIdle_F7.png"),
        };


    }

    public void draw(Batch batch) {
        int frameMultiplier = 10;
        batch.draw(framesArray[frameCounter / frameMultiplier], x, y, width, height);
        if (frameCounter++ == framesArray.length * frameMultiplier - 1) frameCounter = 0;
    }

    public void dispose() {
        texture.dispose();
    }
}
