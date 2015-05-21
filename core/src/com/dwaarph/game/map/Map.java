package com.dwaarph.game.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dwaarph.game.items.Entity;
import com.dwaarph.game.snake.Snake;
import com.dwaarph.game.utils.Constants;

/**
 * Created by Scimson on 17/05/2015.
 */
public class Map {

    private Entity[][] grid;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private int camx, camy;
    private Viewport viewport;
    private Snake[] snake;
	private Snake cam_focus;
	private boolean started;
	private long last_update;
	private int interval;

    public Map(){
        batch = new SpriteBatch();
        this.camera = new OrthographicCamera(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		this.camera.translate(Constants.CELL_SIZE/2f, Constants.CELL_SIZE/2f);
        grid = new Entity[Constants.GRID_SIZE][Constants.GRID_SIZE];
		camx = 0;
		camy = 0;
        create();
    }

    public void create(){
		snake = new Snake[3];
        snake[0] = new Snake(0,0);
		snake[1] = new Snake(1,2);
		snake[2] = new Snake(41,41);
		grid[0][0] = snake[0];
		grid[1][2] = snake[1];
		grid [41][41] = snake[2];

		cam_focus = snake[0];

		started = false;
		interval = 1000;
		start();
	}

	public void start(){
		last_update = System.currentTimeMillis();
		started = true;
	}

	public void update(){
		if(started){
			long current_time = System.currentTimeMillis();
			long delta = current_time - last_update;
			if(delta >= interval){
				snake[0].update(this);
				last_update = current_time;
			}
		}
		this.updateCamera();
	}

	public void updateCamera(){
		camx = cam_focus.getX();
		camy = cam_focus.getY();
		//System.out.println(camx);
	}

    public void draw(){

		this.update();

        camera.update();
        batch.setProjectionMatrix(camera.combined);

		int start_col = camx - Constants.UPCOLS;
		int end_col = camx + Constants.UPCOLS;
		int start_row = camy - Constants.UPROWS;
		int end_row = camy + Constants.UPROWS;


        batch.begin();
		for(int i = start_col, pos_x = -Constants.UPCOLS; i <= end_col; ++i, ++pos_x){
			int x = getRelativePosition(i);
			for(int j = start_row, pos_y = -Constants.UPROWS; j <= end_row; ++j, ++pos_y){
				int y = getRelativePosition(j);
				Entity entity = grid[x][y];
				if(entity != null){
					entity.draw(batch, pos_x, pos_y);
				}
			}
		}


        batch.end();
    }

	public Entity[][] getGrid() {
		return grid;
	}

	/**
	 * Returns the relative position of x within the range
	 * @param x
	 * @return
	 */
	public static int getRelativePosition(int x){
		if(x < 0)
			x = x + Constants.GRID_SIZE;
		else if(x >= Constants.GRID_SIZE)
			x = x - Constants.GRID_SIZE;
		return x;
	}
}
