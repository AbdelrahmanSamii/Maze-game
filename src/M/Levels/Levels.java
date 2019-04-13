package M.Levels;

import M.DefaultValues.DefaultValues;
import M.GenerateMaze.RandomDistribution;
import M.GenerateMaze.RecursiveDivision;
import M.MazeRunner.MazeRunner;

public class Levels implements Level{

	private int level,  rows, cols, trees, monsters, bombs, gifts, obstacleTrees, health, lifes, score;
	private double[][] maze;
	private RecursiveDivision mazeGenerator;
	private RandomDistribution mazeDistribution;
	private int[] position;

	public Levels(int level, int rows, int cols, int trees, int monsters, int bombs, int gifts, int obstacleTrees, int health, int lifes, int score, double[][] maze) {
		this.level = level;
		this.rows = rows;
		this.cols = cols;
		this.trees = trees;
		this.monsters = monsters;
		this.bombs = bombs;
		this.gifts = gifts;
		this.obstacleTrees = obstacleTrees;
		this.health = health;
		this.lifes = lifes;
		this.score = score;
		this.maze = maze;
	}
	public Levels win() {
		level++;
		if (level > 5) {
			//win and end the game
			return null;
		}
		if (rows == cols) {
			rows++;
		} else {
			cols++;
		}
		monsters++;
		bombs++;
		gifts++;
		obstacleTrees++;
		score += DefaultValues.SCORE;
		mazeGenerator = new RecursiveDivision(rows, cols, trees);
		mazeGenerator.makeMaze();
		maze = mazeGenerator.getMaze();
		position = mazeGenerator.getPlayerPosition();
		mazeDistribution = new RandomDistribution(monsters, bombs, gifts, obstacleTrees, maze, position);
		maze = mazeDistribution.getMaze();
		Levels nextLevel = new Levels(level, rows, cols, trees, monsters, bombs, gifts, obstacleTrees, health, lifes, score, maze);
		MazeRunner mazeRunner = MazeRunner.getInstance();
		mazeRunner.setNumberOfBullets(6);
		mazeRunner.increaseHealth(100);
		return nextLevel ;
	}
	public double[][] getMaze() {
		return maze;
	}
}
