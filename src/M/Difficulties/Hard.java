package M.Difficulties;

import M.DefaultValues.DefaultValues;
import M.GenerateMaze.RandomDistribution;
import M.GenerateMaze.RecursiveDivision;
import M.Levels.Levels;

public class Hard implements Difficulty {

	private int level = 1, rows = 3, cols = 3, trees = 5, monsters = 7, bombs = 7, gifts = 1, obstacleTrees = 5;
	private double[][] maze;
	private RecursiveDivision mazeGenerator = new RecursiveDivision(rows, cols, trees);
	Levels levelState ;

	@Override
	public void run() {
		mazeGenerator.makeMaze();
		maze = mazeGenerator.getMaze();
		int[] position = mazeGenerator.getPlayerPosition();
		RandomDistribution mazeDistribution = new RandomDistribution(monsters, bombs, gifts, obstacleTrees, maze, position);
		maze = mazeDistribution.getMaze();
		levelState = new Levels(level, rows, cols, trees, monsters, bombs, gifts, obstacleTrees, DefaultValues.FULL_HEALTH, DefaultValues.NUM_OF_LIFES, DefaultValues.SCORE, maze);
	}

	@Override
	public void win(){
		this.levelState = getLevel().win();
	}
	@Override
	public Levels getLevel(){
		return this.levelState ;
	}

}
