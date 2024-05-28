package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class MenuExit {
    public int x, y;
    int speed;
    Texture texture;
    int width, height;

    public MenuExit(int x, int y, Texture texture, int speed, int width, int height) {
        this.x = x;
        this.y = y;
        this.texture = new Texture("kjol_.png");
        this.speed = speed;
        this.width = width;
        this.height = height;
    }
    public void draw(Batch batch) {
        batch.draw(texture,x, y, width, height);
    }

    public void dispose() {
        texture.dispose();
    }
}
