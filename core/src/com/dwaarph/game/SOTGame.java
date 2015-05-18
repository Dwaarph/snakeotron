package com.dwaarph.game;

import com.dwaarph.game.graphics.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dwaarph.game.run.GameInstance;

public class SOTGame extends Game {

	private GameScreen gameScreen;
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		gameScreen = new GameScreen();
		gameScreen.setInstance(new GameInstance());
	}

	@Override
	public void render () {
		super.render();
		gameScreen.render(0);
	}
}
