package M.Gifts;

import M.DefaultValues.DefaultValues;
import M.MazeRunner.MazeRunner;

public interface IGiftBehavior {

	MazeRunner mazeRunner = MazeRunner.getInstance();

	public void executeBehavior();

}

class giveHealthBehavior implements IGiftBehavior {

	@Override
	public void executeBehavior() {
		mazeRunner.increaseHealth(DefaultValues.HEALTH_GAIN_OR_LOSS);
		mazeRunner.increaseScore(DefaultValues.SCORE_GAIN_OR_LOSS);
	}

}

class giveBulletsBehavior implements IGiftBehavior {

	@Override
	public void executeBehavior() {
		mazeRunner.increaseBullets(DefaultValues.GAIN_BULLET);
		mazeRunner.increaseScore(DefaultValues.SCORE_GAIN_OR_LOSS);
	}

}

class extraLifeBehavior implements IGiftBehavior {

	@Override
	public void executeBehavior() {
		mazeRunner.gainExtraLife();
		mazeRunner.increaseScore(DefaultValues.SCORE_GAIN_OR_LOSS * 2);
	}

}