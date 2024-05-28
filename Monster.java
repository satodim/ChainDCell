package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Monster {
    public int x, y;
    int speed;
    Texture texture;
    Texture[] framesArray;
    Texture[] framesArray2;
    int currentTextureIndexStanding = 0;
    int currentTextureIndexAttacking = 0;
    boolean isStanding = true;
    boolean isAttacking = true;
    int width, height;

    public Monster(int x, int y, Texture texture, int speed, int width, int height) {
        this.x = x;
        this.y = y;
        this.texture = new Texture("An01_F00.png");
        this.speed = speed;
        this.width = width;
        this.height = height;
        framesArray = new Texture[]{
                new Texture("MonsterIdle_F0.png"),
                new Texture("MonsterIdle_F1.png"),
                new Texture("MonsterIdle_F2.png"),
                new Texture("MonsterIdle_F3.png"),
                new Texture("MonsterIdle_F4.png"),
                new Texture("MonsterIdle_F5.png"),
                new Texture("MonsterIdle_F6.png"),
                new Texture("MonsterIdle_F7.png"),
        };

        framesArray2 = new Texture[]{
                new Texture("MonsterDamage_F0.png"),
                new Texture("MonsterDamage_F0.png"),
                new Texture("MonsterDamage_F0.png"),
                new Texture("MonsterDamage_F0.png"),
                new Texture("MonsterDamage_F0.png"),
                new Texture("MonsterDamage_F0.png"),
                new Texture("MonsterDamage_F0.png"),
                new Texture("MonsterDamage_F0.png"),
        };



    }
    public void isMonsterStanding(){
        new Thread(() -> {
            while (isStanding){
                texture = framesArray[currentTextureIndexStanding];
                currentTextureIndexStanding = ++currentTextureIndexStanding % framesArray.length;
                try {
                    Thread.sleep(130);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }
    public void isMonsterAttacked(){

        new Thread(() -> {
            while (isAttacking){
                texture = framesArray2[currentTextureIndexAttacking];
                currentTextureIndexAttacking = ++currentTextureIndexAttacking % framesArray2.length;
                try {
                    Thread.sleep(35);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
    public void setisStandingMonster(boolean newisStanding) {
        isStanding = newisStanding;
    }
    public void setisMonsterAttacking(boolean newisAttacking) {
        isAttacking = newisAttacking;
    }

    public void draw(Batch batch) {
        batch.draw(texture,x, y, width, height);
    }

    public void dispose() {
        texture.dispose();
    }
}
