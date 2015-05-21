package com.dwaarph.game.snake;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dwaarph.game.items.Entity;
import com.dwaarph.game.map.Map;
import com.dwaarph.game.utils.Constants;

/**
 * Created by Scimson on 17/05/2015.
 */
public class Snake extends Entity {

	private Texture texture;
	private Sprite sprite;
	private Direction direction;

	public Snake(int x, int y) {
		super(Types.HEAD, x, y);
		texture = new Texture("textures/HeadSnake0.png");
		sprite = new Sprite(texture);
		sprite.setSize(Constants.CELL_SIZE, Constants.CELL_SIZE);
		direction = Direction.UP;
	}

	@Override
	public void draw(SpriteBatch batch, int pos_x, int pos_y) {
		sprite.setPosition(pos_x * Constants.CELL_SIZE, pos_y * Constants.CELL_SIZE);
		sprite.draw(batch);
	}

	@Override
	public void onHit(){

	}

	public void update(Map map){
		Entity[][] grid = map.getGrid();
		grid[this.getX()][this.getY()] = null;
		this.move(direction);
		this.move(Direction.RIGHT);
		grid[this.getX()][this.getY()] = this;
	}
}
