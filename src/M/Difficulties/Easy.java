package M.Difficulties;

import M.DefaultValues.DefaultValues;
import M.GenerateMaze.RandomDistribution;
import M.GenerateMaze.RecursiveDivision;
import M.Levels.Levels;

public class Easy implements Difficulty {

	private int level = 1, rows = 3, cols = 3, trees = 10, monsters = 3, bombs = 3, gifts = 3, obstacleTrees = 0;
	private double[][] maze;
	private RecursiveDivision mazeGenerator;
	private RandomDistribution mazeDistribution;
	int[] position;
	Levels levelState ;

	@Override
	public void run() {
		mazeGenerator = new RecursiveDivision(rows, cols, trees);
		mazeGenerator.makeMaze();
		maze = mazeGenerator.getMaze();
		position = mazeGenerator.getPlayerPosition();
		mazeDistribution = new RandomDistribution(monsters, bombs, gifts, obstacleTrees, maze, position);
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
