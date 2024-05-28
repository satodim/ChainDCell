package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game {
	public static final int SCR_WIDTH = 1920;
	public static final int SCR_HEIGHT = 1080;
	SpriteBatch batch;
	ScreenGame screenGame;
	BitmapFont font;
	ShopScreen shopScreen;
	Menu menu;
	public OrthographicCamera camera;

	@Override
	public void create () {
		font = new BitmapFont();
		font.getData().setScale(2);
		font.setColor(Color.WHITE);
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);


		screenGame = new ScreenGame(this);
		shopScreen = new ShopScreen(this);
		menu = new Menu(this);
		setScreen(menu);
	}

	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}
}

