package com.mygdx.game;

import static com.mygdx.game.MyGdxGame.SCR_HEIGHT;
import static com.mygdx.game.MyGdxGame.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
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

public class ShopScreen implements Screen {
    public void setsetscreengame(boolean newsetscreengame) {
        setscreengame = newsetscreengame;
    }
    public void setCount(int newcount) {
        count = newcount;
    }


    private Stage stage;
    private BitmapFont font;
    private TextureAtlas buttonsAtlas;
    boolean isTouchDownLeft;
    boolean isTouchDownRight;

    private Skin buttonSkin;
    boolean setscreengame = false;
    private TextButton button;
    private BitmapFont font2;
    private TextureAtlas buttonsAtlas2;
    private final MyGdxGame myGdxGame;
    private Skin buttonSkin2;
    int index = 0;
    private Music music;
    private TextButton button2;
    private BitmapFont font3;
    private TextureAtlas buttonsAtlas3;
    private Skin buttonSkin3;
    private TextButton button3;
    private BitmapFont font4;
    private TextureAtlas buttonsAtlas4;
    private Skin buttonSkin4;
    private TextButton button4;
    private BitmapFont font5;
    private TextureAtlas buttonsAtlas5;
    private Skin buttonSkin5;
    private TextButton button5;
    int count;
    int points = 1;
    PointCounter pointCounter;
    boolean Sfont = false;
    boolean Sfont2 = false;
    boolean Sfont3 = false;
    boolean Sfont4 = false;
    boolean Sfont5 = false;
    boolean Sfont6 = false;
    Dealer dealer;
    public Character character;
    Texture characterTexture;
    MenuExit menuExit;
    Texture backgroundTexture;
    Texture dealerTexture;
    Texture menuExitTexture;
    ScreenGame screenGame;

    int currentTextureIndexToRight = 0;
    int currentTextureIndexLeft = 0;

    final int pointCounterMarginRight = 400;
    final int pointCounterMarginTop = 60;
    ShopScreen(MyGdxGame myGdxGame) {

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
        music = Gdx.audio.newMusic(Gdx.files.internal("shop.mp3"));
        music.setLooping(true);
        music.setVolume(0.3f);



        screenGame = new ScreenGame(myGdxGame);

        //массив текстур передвижения вправо
        Texture textureToRight1 = new Texture("An01_F00.png");
        Texture textureToRight2 = new Texture("An01_F01.png");
        Texture textureToRight3 = new Texture("An01_F02.png");
        Texture textureToRight4 = new Texture("An01_F03.png");
        Texture textureToRight5 = new Texture("An01_F04.png");
        Texture textureToRight6 = new Texture("An01_F05.png");
        Texture textureToRight7 = new Texture("An01_F06.png");
        Texture textureToRight8 = new Texture("An01_F07.png");
        Texture textureToRight9 = new Texture("An01_F08.png");
        Texture textureToRight10 = new Texture("An01_F09.png");
        Texture textureToRight11= new Texture("An01_F10.png");
        Texture textureToRight12= new Texture("An01_F11.png");
        Texture textureToRight13 = new Texture("An01_F12.png");
        Texture textureToRight14 = new Texture("An01_F13.png");
        Texture textureToRight15= new Texture("An01_F14.png");
        Texture textureToRight16= new Texture("An01_F15.png");
        Texture[] texturesToRight = new Texture[]{textureToRight1, textureToRight2, textureToRight3,textureToRight4, textureToRight5, textureToRight6,textureToRight7, textureToRight8, textureToRight9,textureToRight10, textureToRight11, textureToRight12,textureToRight13,textureToRight14,textureToRight15,textureToRight16};


        Texture textureToLeft1 = new Texture("An01_F00 (1).png");
        Texture textureToLeft2 = new Texture("An01_F01 (1).png");
        Texture textureToLeft3 = new Texture("An01_F02 (1).png");
        Texture textureToLeft4 = new Texture("An01_F03 (1).png");
        Texture textureToLeft5 = new Texture("An01_F04 (1).png");
        Texture textureToLeft6 = new Texture("An01_F05 (1).png");
        Texture textureToLeft7 = new Texture("An01_F06 (1).png");
        Texture textureToLeft8 = new Texture("An01_F07 (1).png");
        Texture textureToLeft9 = new Texture("An01_F08 (1).png");
        Texture textureToLeft10 = new Texture("An01_F09 (1).png");
        Texture textureToLeft11 = new Texture("An01_F10 (1).png");
        Texture textureToLeft12 = new Texture("An01_F11 (1).png");
        Texture textureToLeft13 = new Texture("An01_F12 (1).png");
        Texture textureToLeft14 = new Texture("An01_F13 (1).png");
        Texture textureToLeft15 = new Texture("An01_F14 (1).png");
        Texture textureToLeft16 = new Texture("An01_F15 (1).png");
        Texture[] texturesToLeft = new Texture[]{textureToLeft1, textureToLeft2, textureToLeft3,textureToLeft4, textureToLeft5, textureToLeft6,textureToLeft7, textureToLeft8, textureToLeft9,textureToLeft10, textureToLeft11, textureToLeft12,textureToLeft13,textureToLeft14,textureToLeft15,textureToLeft16};

        character = new Character(100, -70, characterTexture, 0, 700, 700);
        characterTexture = new Texture("An01_F00.png");
        menuExit = new MenuExit(50,890,menuExitTexture,0,120,120);
        menuExitTexture = new Texture("kjol_.png");
        dealer = new Dealer(930,0, dealerTexture,0,450,450);
        dealerTexture = new Texture("MonsterIdle_F0.png");
        backgroundTexture = new TextureRegion(new Texture("Sprite-0002.png"), 0, 0, 2048, 563).getTexture();
        this.myGdxGame = myGdxGame;

        // кнопка передвижения вправо
        buttonsAtlas = new TextureAtlas("buttons.pack");
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

        button = new TextButton("", style);
        button.setPosition(350, 50);
        button.setHeight(100);
        button.setWidth(150);
        button.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                character.setisStanding(false);
                character.setisStandingToLeft(false);
                isTouchDownRight = true;
                new Thread(() -> {
                    while (isTouchDownRight) {
                        character.setrunToRight(true);
                        character.moveToRight();
                        character.setTexture(texturesToRight[currentTextureIndexToRight]);
                        characterTexture = texturesToRight[currentTextureIndexToRight];
                        currentTextureIndexToRight = ++currentTextureIndexToRight % texturesToRight.length;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }).start();
                return true;

            }


            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isTouchDownRight = false;
                currentTextureIndexToRight = 0;
                character.setrunToRight(false);
                character.setisStanding(true);
                character.isCharacterStanding();

            }

        });

        buttonsAtlas2 = new TextureAtlas("buttons2.pack");
        buttonSkin2 = new Skin();
        buttonSkin2.addRegions(buttonsAtlas2);
        font2 = new BitmapFont();
        font2.getData().scale(5f);
        font2.setColor(Color.WHITE);


        TextButton.TextButtonStyle style2 = new TextButton.TextButtonStyle();
        style2.up = buttonSkin2.getDrawable("ButtonOn");
        style2.down = buttonSkin2.getDrawable("ButtonOff");
        style2.font = font2;

        button2 = new TextButton("", style2);
        button2.setPosition(100, 50);
        button2.setHeight(100);
        button2.setWidth(150);
        button2.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                character.setisStanding(false);
                character.setisStandingToLeft(false);
                isTouchDownLeft = true;
                new Thread(() -> {
                    while (isTouchDownLeft) {
                        character.setrunToLeft(true);
                        character.moveToLeft();
                        character.setTexture(texturesToLeft[currentTextureIndexLeft]);
                        characterTexture = texturesToLeft[currentTextureIndexLeft];
                        currentTextureIndexLeft = ++currentTextureIndexLeft % texturesToLeft.length;
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }).start();

                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isTouchDownLeft = false;
                currentTextureIndexLeft = 0;
                character.setrunToLeft(false);
                character.setisStandingToLeft(true);
                character.isCharacterStandingToLeft();
            }

        });


        buttonsAtlas4 = new TextureAtlas("buttons.pack2");
        buttonSkin4 = new Skin();
        buttonSkin4.addRegions(buttonsAtlas4);
        font4 = new BitmapFont();
        font4.getData().scale(5f);
        font4.setColor(Color.WHITE);


        TextButton.TextButtonStyle style4 = new TextButton.TextButtonStyle();
        style4.up = buttonSkin4.getDrawable("ButtonOff");
        style4.down = buttonSkin4.getDrawable("ButtonOn");
        style4.font = font4;

        button4 = new TextButton("", style4);
        button4.setPosition(1150, 50);
        button4.setHeight(300);
        button4.setWidth(300);
        button4.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                int checkedX = character.getXToCheck();
                if (checkedX>= 500 && checkedX<= 1400){
                    index += 1;
                    if (index == 1){
                        Sfont = true;
                    }
                    if (index == 2){
                        Sfont2 = true;
                    }
                    if (index == 3){
                        Sfont3 = true;
                    }
                    if (index == 4){
                        Sfont4 = true;
                    }
                    if (index == 5){
                        Sfont5 = true;
                    }
                    if (index == 6){
                        Sfont6 = true;
                    }

                }
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if(index > 6){
                    index = 0;
                }
            }

        });
        buttonsAtlas5 = new TextureAtlas("buttons.pack2");
        buttonSkin5 = new Skin();
        buttonSkin5.addRegions(buttonsAtlas5);
        font5 = new BitmapFont();
        font5.getData().scale(5f);
        font5.setColor(Color.WHITE);
        stage = new Stage();
        stage.clear();


        TextButton.TextButtonStyle style5 = new TextButton.TextButtonStyle();
        style5.up = buttonSkin5.getDrawable("ButtonOff");
        style5.down = buttonSkin5.getDrawable("ButtonOn");
        style5.font = font5;

        button5 = new TextButton("", style5);
        button5.setPosition(50, 900);
        button5.setHeight(100);
        button5.setWidth(100);
        button5.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                myGdxGame.setScreen(myGdxGame.menu);
                return true;

            }


            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }

        });
        stage.addActor(button);
        stage.addActor(button2);
        stage.addActor(button4);
        stage.addActor(button5);



    }



    @Override
    public void show() {

        music.play();
        Gdx.input.setInputProcessor(stage);
        myGdxGame.screenGame.setsetscreenshop(false);
        if(setscreengame){
            character.setX(300);
        }

    }

    @Override
    public void render(float delta) {
        int checkedCount = screenGame.getCountToCheck();
        count = checkedCount;
        int checkedX = character.getXToCheck();
        if (checkedX <= 30){
            myGdxGame.setScreen(myGdxGame.screenGame);
        }

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();
        myGdxGame.batch.draw(backgroundTexture, 0, 0);
        myGdxGame.batch.draw(backgroundTexture, 0, Gdx.graphics.getHeight());
        if (Sfont){
            myGdxGame.font.draw(myGdxGame.batch, "You probably don't remember how it all started. You were one of those who came to defend our territory.", 500, 500);
        }
        if (Sfont2){
            myGdxGame.font.draw(myGdxGame.batch, " I saw you that day  you were so stubborn, so strong", 800, 500);
            Sfont = false;
        }
        if (Sfont3){
            myGdxGame.font.draw(myGdxGame.batch, "But then everything changed. You were seriously injured in one of the battles", 800, 500);
            Sfont2= false;
        }
        if (Sfont4){
            myGdxGame.font.draw(myGdxGame.batch, "Your enemies caught you, but I know it's not your fault.", 800, 500);
            Sfont3 = false;
        }
        if (Sfont5){
            myGdxGame.font.draw(myGdxGame.batch, "You were my ally, and I believe in you.", 800, 500);
            Sfont4= false;
        }
        if (Sfont6){
            myGdxGame.font.draw(myGdxGame.batch, "", 500, 500);
            Sfont5 = false;
        }
        menuExit.draw(myGdxGame.batch);
        dealer.draw(myGdxGame.batch);
        character.draw(myGdxGame.batch);
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
        Sfont = false;
        Sfont2 = false;
        Sfont3 = false;
        Sfont4 = false;
        Sfont5 = false;
        Sfont6 = false;
        music.stop();
        Gdx.input.setInputProcessor(null);
        myGdxGame.screenGame.setsetscreenshop(true);
    }

    @Override
    public void dispose() {
        menuExit.dispose();
        dealer.dispose();
        character.dispose();
        buttonSkin.dispose();
        buttonsAtlas.dispose();
        font.dispose();
        stage.dispose();
        buttonSkin2.dispose();
        buttonsAtlas2.dispose();
        font2.dispose();
        buttonSkin4.dispose();
        buttonsAtlas4.dispose();
        font4.dispose();

    }
}
