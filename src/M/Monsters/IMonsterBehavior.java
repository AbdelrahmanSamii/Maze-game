package M.Monsters;

import M.DefaultValues.DefaultValues;
import M.MazeRunner.MazeRunner;

public interface IMonsterBehavior {

	MazeRunner mazeRunner = MazeRunner.getInstance();

	public void executeBehaviorHit();
	
	public void executeBehaviorShotted();
	
	public boolean isGone();
}

class HealthLossBehavior implements IMonsterBehavior{

	private boolean gone = false;

	@Override
	public void executeBehaviorHit() {
		mazeRunner.takeDamage(DefaultValues.HEALTH_GAIN_OR_LOSS);
		mazeRunner.decreaseScore(DefaultValues.SCORE_GAIN_OR_LOSS);
	}

	@Override
	public void executeBehaviorShotted() {
		//TODO if bullet hit monster
		mazeRunner.increaseScore(DefaultValues.SCORE_GAIN_OR_LOSS);
		gone = true;
	}

	@Override
	public boolean isGone() {
		return gone;
	}
	
}

class LifeLossBehavior implements IMonsterBehavior{

	private boolean gone = false;

	@Override
	public void executeBehaviorHit() {
		mazeRunner.loseAlife();
		mazeRunner.decreaseScore(DefaultValues.SCORE_GAIN_OR_LOSS * 2);
	}

	@Override
	public void executeBehaviorShotted() {
		//TODO if bullet hit monster
		mazeRunner.increaseScore(DefaultValues.SCORE_GAIN_OR_LOSS * 2);
		gone = true;
	}

	@Override
	public boolean isGone() {
		return gone;
	}
}
