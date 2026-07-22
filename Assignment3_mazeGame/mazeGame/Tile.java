package mazeGame;

public class Tile {
	private boolean isWall;
	private boolean isExit;
	
	public Tile(boolean isWall, boolean isExit) {
		this.isWall = isWall;
		this.isExit = isExit;
	}
	
	public boolean isWall() {
		return this.isWall;
	}

	public boolean isExit() {
		return this.isExit;
	}
}
