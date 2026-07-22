package mazeGame;

import java.util.Random;

public class Maze {
	
	private int size;
	private Tile[][] grid;
		
	public Maze(int size) {	
		
		this.size = size;
		
		grid = new Tile[size][size];
		
		Random rand = new Random();

		
//create empty maze
		for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Tile(false, false);
            }
        }

		
//add randomized exit tile
		int exitX;
		int exitY;
														//I added this do-while loop that the Exit can't be at the starting position		
		do {
			exitX = rand.nextInt(size);
			exitY = rand.nextInt(size);
		} while (exitX == 0 && exitY == 0);
							
		grid[exitX][exitY] = new Tile(false, true);

		
//add randomized walls 
		int numWalls = size*size / 10; 					//the number of walls scales to the size of the maze
		
		for (int i= 0; i < numWalls; i++) {
			
			int wallX;
			int wallY;
			
			do {
				wallX = rand.nextInt(size);
				wallY = rand.nextInt(size);
			} while (
				(wallX == 0 && wallY == 0) ||			//This prevents the wall to spawn at the starting position
				(wallX == exitX && wallY == exitY)		//This prevents the wall to spawn at the exit position
				);
				
			grid[wallX][wallY] = new Tile(true, false);	
			}			
	}
			
			
//visualization 
		public void printMaze(Player player) {
		   		
		for (int y = size - 1; y >= 0; y--) {			//coordinate system is used as if 0/0 is at bottom left
		    for (int x = 0; x < size; x++) {
				
				if (x == player.getX() && y == player.getY()) {
					System.out.print("[Pl.1]");
				} 
				
				else if (grid[y][x].isWall()) {	
					System.out.print("[####]");
				} 
				
				else if (grid[y][x].isExit()) {
					System.out.print("[EXIT]");
				} 
				
				else {
					System.out.print("[    ]");
				}
			}
			
			System.out.println();
		}
		
	}


		
		//getter for size
				public int getSize() {
					return size;
				}
		//getter for wall checking
				public boolean isWall(int x,int y) {
					return grid[y][x].isWall();
				}
		//getter for winning condition
				public boolean isExit(int x, int y) {
					return grid[y][x].isExit();
				}
}
