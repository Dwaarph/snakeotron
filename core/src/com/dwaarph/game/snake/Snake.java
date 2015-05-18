package com.dwaarph.game.snake;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Scimson on 17/05/2015.
 */
public class Snake {

	Texture texture;
	Sprite sprite;

	public Snake() {
		texture = new Texture("textures/HeadSnake0.png");
		sprite = new Sprite(texture);
		sprite.setSize(32, 32);
	}

	public void draw(SpriteBatch batch) {
		sprite.draw(batch);
	}
}
