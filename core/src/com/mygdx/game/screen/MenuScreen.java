package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private SpriteBatch batch;
    private Texture img;
    private Texture backgroundImg;
    private Vector2 touch;

    private Vector2 currentPosition;
    private Vector2 touchedPosition;
    private Vector2 v;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        backgroundImg = new Texture("space.jpg");
        img = new Texture("F5S2.png");
        touch = new Vector2();

        touchedPosition = new Vector2();
        currentPosition = new Vector2(0, 0);
        v = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.4f, 0.6f, 0.5f, 0.8f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(backgroundImg, 0, 0);
        batch.draw(img, currentPosition.x, currentPosition.y);
        batch.end();
        System.out.println("v.x = " + v.x + " v.y = " + v.y);
        currentPosition.set(touchedPosition);

        // МОЯ ПОПЫТКА СДЕЛАТЬ ЧЕРЕЗ ВЕКТОРА

//        if (currentPosition.x <= touchedPosition.x && currentPosition.y <= touchedPosition.y) {
//            v = touchedPosition.sub(currentPosition);
//            System.out.println("v.x = " + v.x + " v.y = " + v.y);
//            currentPosition.add(v);
//        } else {
//            currentPosition.set(touchedPosition);
//        }

//        if (touchedPosition.x <= currentPosition.x && touchedPosition.y <= currentPosition.y) {
//            v = touchedPosition.sub(currentPosition);
//            System.out.println("v.x = " + v.x + " v.y = " + v.y);
//            currentPosition.add(v);
//        }
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touchedPosition.set(screenX, Gdx.graphics.getHeight() - screenY);
        System.out.println("touchedPosition.x = " + touchedPosition.x + " touchedPosition.y = " + touchedPosition.y);
        return super.touchDown(screenX, screenY, pointer, button);
    }

}
