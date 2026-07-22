//Bernhard Vidra
package mazeGame;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Maze maze = new Maze(8);
		Player player = new Player("Pl.1", maze.getSize());		//The size getter is necessary to scale the amount of energy with the maze 		
		Scanner input = new Scanner(System.in);
		
		int max = maze.getSize() - 1;
				
		while(true) {
			
			maze.printMaze(player);
			System.out.println("Energy: " + player.getEnergy());
			System.out.println("Move with entering (w/a/s/d)");
			
			 String move = input.nextLine();
			 
			 if (move.equals("w")) {
				
				 int newX = player.getX();
				 int newY = player.getY() + 1;
				 
				 if (newY <= max && !maze.isWall(newX, newY)) {	// checks if it is a legal move; 1st if it is out of bound and 2nd if it is a wall
	                player.moveUp();
				    } else System.out.println("You can't go here!");
			 	}
			 
	            else if (move.equals("a")) {
	            	
	            	int newX = player.getX() - 1;
					int newY = player.getY();
	            	
					if (newX >= 0 && !maze.isWall(newX, newY)) {
	                player.moveLeft();
					} else System.out.println("You can't go here!");
	            }
			 
	            else if (move.equals("s")) {
	            	
	            	int newX = player.getX();
					int newY = player.getY() - 1;
	            	
					if (newY >= 0 && !maze.isWall(newX, newY)) {
	                player.moveDown();
					} else System.out.println("You can't go here!");
	            }
	            else if (move.equals("d")) {
	            	
	            	int newX = player.getX() + 1;
					int newY = player.getY();
	            	
					if (newX <= max && !maze.isWall(newX, newY)) {
	                player.moveRight();
					} else System.out.println("You can't go here!");
	            }
		
			 //losing condition
			 if (player.getEnergy() == 0) {
				 System.out.println("You run out of Energy - You Lose!");
				 maze.printMaze(player);
				 break;
			 }
			 
			 //Winning condition
			 if (maze.isExit(player.getX(), player.getY())) {				 
				 System.out.println("You found the Exit - You Win!");
				 maze.printMaze(player);
				 break;
			 }
			 
		}
		
	}
	
}
