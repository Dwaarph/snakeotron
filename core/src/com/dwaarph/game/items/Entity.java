package com.dwaarph.game.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dwaarph.game.utils.Constants;
import com.sun.corba.se.impl.orbutil.closure.Constant;

/**
 * Created by Scimson on 18/05/2015.
 */
public abstract class Entity {

	public enum Types{
		FOOD,
		WALL,
		HEAD
	}

	public enum Direction{
		UP,
		DOWN,
		LEFT,
		RIGHT
	}

	private Types type;
	private int x, y;

	public Entity(Types type, int x, int y){
		super();
		this.type = type;
		this.x = x;
		this.y = y;
	}

	public abstract void onHit();

	public abstract void draw(SpriteBatch batch, int pos_x, int pos_y);

	public void move(Direction direction){
		if(direction == Direction.UP){
			moveUp();
		}
		else if(direction == Direction.DOWN){
			moveDown();
		}
		else if(direction == Direction.LEFT){
			moveLeft();
		}
		else if(direction == Direction.RIGHT){
			moveRight();
		}
	}

	public void moveUp(){
		this.y++;
		if(this.y >= Constants.GRID_SIZE){
			this.y -= Constants.GRID_SIZE;
		}
	}

	public void moveDown(){
		this.y--;
		if(this.y < 0){
			this.y += Constants.GRID_SIZE;
		}
	}

	public void moveLeft(){
		this.x--;
		if(this.x < 0){
			this.x += Constants.GRID_SIZE;
		}
	}

	public void moveRight(){
		this.x++;
		if(this.x >= Constants.GRID_SIZE){
			this.x -= Constants.GRID_SIZE;
		}
	}

	public Types getType(){
		return this.type;
	}

	public void setType(Types type){
		this.type = type;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
