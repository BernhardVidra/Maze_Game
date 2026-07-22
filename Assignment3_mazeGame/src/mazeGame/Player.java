package mazeGame;

public class Player {
	
	private int playerX;
	private int playerY;
	private int energy;
	
	public Player(String name, int mazeSize) {
		
		this.playerX = 0;
		this.playerY = 0;
		this.energy = mazeSize * 2;  //The energy number needs to by high enough to reach the right upper corner 
									 
	}
		
//movement methods
	public void moveUp() {
		this.playerY = this.playerY + 1;
		this.energy--;
	}
	public void moveDown() {
		this.playerY = this.playerY - 1;
		this.energy--;
	}
	public void moveLeft() {
		this.playerX = this.playerX - 1;
		this.energy--;
	}
	public void moveRight() {
		this.playerX = this.playerX + 1;
		this.energy--;
	}
	
//getter for x and y coordinates, and energy
	public int getX() {
	    return playerX;
	}
	public int getY() {
	    return playerY;
	}
	
	public int getEnergy() {
		return energy;
	}
		
}
