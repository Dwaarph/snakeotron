package com.dwaarph.game.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dwaarph.game.snake.Snake;

/**
 * Created by Scimson on 17/05/2015.
 */
public class Map {

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Snake snake;

    public Map(){
        batch = new SpriteBatch();
        this.camera = new OrthographicCamera(800, 480);// Works with manual input
        snake = new Snake();
    }

    public void draw(){

        camera.update();
        batch.setProjectionMatrix(camera.combined);


        batch.begin();
        snake.draw(batch);


        batch.end();
    }
}
