package com.dwaarph.game.utils;

/**
 * Created by Scimson on 18/05/2015.
 */
public interface Constants {
	public static final int SCREEN_WIDTH = 480;
	public static final int SCREEN_HEIGHT = 800;
	public static final int CELL_SIZE = 32;
	public static final int GRID_SIZE = 42;
	public static final int NROWS = SCREEN_HEIGHT/CELL_SIZE;
	public static final int NCOLS = SCREEN_WIDTH/CELL_SIZE;
	public static final int UPROWS = (NROWS - 1)/2;
	public static final int UPCOLS = (NCOLS - 1)/2;
}
