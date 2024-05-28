package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;

public class Menu implements Screen {
    private Stage stage;
    private Music music;
    private BitmapFont font;
    private TextureAtlas buttonsAtlas;
    private Skin buttonSkin;
    private TextButton button;
    private BitmapFont font2;
    private TextureAtlas buttonsAtlas2;
    private Skin buttonSkin2;
    private TextButton button2;
    MovingBackground backgroundTexture;
    Texture characterTexture;
    Texture exitTexture;
    Texture newGameTexture;
    Name nameTexture;
    NewGame newGame;
    Exit exit;
    Texture nameTagTexture;
    Character character;
    private final MyGdxGame myGdxGame;
    Menu (MyGdxGame myGdxGame) {
        new Music() {
            @Override
            public void play() {

            }

            @Override
            public void pause() {

            }

            @Override
            public void stop() {

            }

            @Override
            public boolean isPlaying() {
                return false;
            }

            @Override
            public void setLooping(boolean isLooping) {

            }

            @Override
            public boolean isLooping() {
                return false;
            }

            @Override
            public void setVolume(float volume) {

            }

            @Override
            public float getVolume() {
                return 0;
            }

            @Override
            public void setPan(float pan, float volume) {

            }

            @Override
            public void setPosition(float position) {

            }

            @Override
            public float getPosition() {
                return 0;
            }

            @Override
            public void dispose() {

            }

            @Override
            public void setOnCompletionListener(OnCompletionListener listener) {

            }
        };
        music = Gdx.audio.newMusic(Gdx.files.internal("menu.mp3"));
        music.setLooping(true);
        music.setVolume(0.3f);


        character = new Character(-1000, -1000, characterTexture, 0, 500, 500);
        exit = new Exit(720,250,exitTexture,0,700,100);
        newGame = new NewGame(720,400,newGameTexture,0,700,100);
        newGameTexture = new Texture("newgame.png");
        characterTexture = new Texture("R_An00_F00.png");
        exitTexture = new Texture("exit.png");
        backgroundTexture = new MovingBackground("Sprite-0001.png");
        nameTexture = new Name(550, 600,nameTagTexture, 0,1000,500);
        nameTagTexture = new Texture("Sprite-0003.png");
        this.myGdxGame = myGdxGame;

        buttonsAtlas = new TextureAtlas("buttons.pack2");
        buttonSkin = new Skin();
        buttonSkin.addRegions(buttonsAtlas);
        font = new BitmapFont();
        font.getData().scale(5f);
        font.setColor(Color.WHITE);
        stage = new Stage();
        stage.clear();



        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = buttonSkin.getDrawable("ButtonOff");
        style.down = buttonSkin.getDrawable("ButtonOn");
        style.font = font;

        button = new TextButton("New game", style);
        button.setPosition(620, 400);
        button.setHeight(100);
        button.setWidth(700);
        button.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                myGdxGame.setScreen(myGdxGame.screenGame);
                return true;
            }


            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {


            }

        });
        buttonsAtlas2 = new TextureAtlas("buttons.pack2");
        buttonSkin2 = new Skin();
        buttonSkin2.addRegions(buttonsAtlas2);
        font2 = new BitmapFont();
        font2.getData().scale(5f);
        font2.setColor(Color.WHITE);
        stage = new Stage();
        stage.clear();



        TextButton.TextButtonStyle style2 = new TextButton.TextButtonStyle();
        style.up = buttonSkin2.getDrawable("ButtonOff");
        style.down = buttonSkin2.getDrawable("ButtonOn");
        style.font = font2;

        button2 = new TextButton("", style);
        button2.setPosition(620, 250);
        button2.setHeight(100);
        button2.setWidth(700);
        button2.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                return true;
            }


            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {


            }

        });


        stage.addActor(button);
        stage.addActor(button2);

    }

    @Override
    public void show() {
        music.play();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {




        stage.act();

        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        stage.draw();
        backgroundTexture.move();
        backgroundTexture.draw(myGdxGame.batch);
        character.draw(myGdxGame.batch);
        exit.draw(myGdxGame.batch);
        nameTexture.draw(myGdxGame.batch);
        newGame.draw(myGdxGame.batch);
        stage.draw();
        myGdxGame.batch.end();


    }
    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        music.stop();

    }

    @Override
    public void dispose() {
        newGame.dispose();
        backgroundTexture.dispose();
        character.dispose();
        exit.dispose();
        nameTexture.dispose();
        buttonSkin.dispose();
        buttonsAtlas.dispose();
        font.dispose();
        buttonSkin2.dispose();
        buttonsAtlas2.dispose();
        font2.dispose();
        stage.dispose();

    }
}