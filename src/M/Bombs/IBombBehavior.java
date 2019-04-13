package M.Bombs;

import M.MazeRunner.MazeRunner;
import M.DefaultValues.DefaultValues;

public interface IBombBehavior {
	
	MazeRunner mazeRunner = MazeRunner.getInstance();

	public void executeBehaviorExploded();
	
	public void executeBehaviorShotted();
	
	public boolean isGone();
}


class HealthLossBehavior implements IBombBehavior{

	private boolean gone = false;

	@Override
	public void executeBehaviorExploded() {
		mazeRunner.takeDamage(DefaultValues.HEALTH_GAIN_OR_LOSS);
		mazeRunner.decreaseScore(DefaultValues.SCORE_GAIN_OR_LOSS);
		gone = true;
	}

	@Override
	public void executeBehaviorShotted() {
		//TODO if bullet hit bomb
		mazeRunner.increaseScore(DefaultValues.SCORE_GAIN_OR_LOSS);
		gone = true;
	}

	@Override
	public boolean isGone() {
		return gone;
	}
	
}

class LifeLossBehavior implements IBombBehavior{

	private boolean gone = false;

	@Override
	public void executeBehaviorExploded() {
		mazeRunner.loseAlife();
		mazeRunner.decreaseScore(DefaultValues.SCORE_GAIN_OR_LOSS * 2);
		gone = true;
	}

	@Override
	public void executeBehaviorShotted() {
		//TODO if bullet hit bomb
		mazeRunner.increaseScore(DefaultValues.SCORE_GAIN_OR_LOSS * 2);
		gone = true;
	}

	@Override
	public boolean isGone() {
		return gone;
	}
}
