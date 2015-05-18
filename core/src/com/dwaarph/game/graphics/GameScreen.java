package com.dwaarph.game.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dwaarph.game.run.GameInstance;

/**
 * Created by Scimson on 17/05/2015.
 */
public class GameScreen implements Screen {

    private GameInstance instance;

    public GameScreen(){
        super();
    }

    public void applyCamera(SpriteBatch batch){

    }

    public void setInstance(GameInstance instance){
        this.instance = instance;
    }

    public GameInstance getInstance(){
        return this.instance;
    }

    @Override
    public  void dispose(){

    }

    @Override
    public void show(){


    }

    @Override
    public void render (float delta){
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        instance.draw();

    }

    @Override
    public void resize (int width, int height){

    }

    @Override
    public void pause (){

    }

    @Override
    public void resume (){

    }

    @Override
    public void hide (){

    }

}
