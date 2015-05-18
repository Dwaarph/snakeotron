package com.dwaarph.game.run;

import com.dwaarph.game.map.Map;
import com.dwaarph.game.snake.Snake;

/**
 * Created by Scimson on 17/05/2015.
 */
public class GameInstance {

    private Map map;
    public GameInstance(){
        map = new Map();
    }

    public void draw(){
       map.draw();
    }
}
