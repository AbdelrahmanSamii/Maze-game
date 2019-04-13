package M.Walls;

import M.DefaultValues.DefaultValues;
import M.MazeRunner.MazeRunner;

public interface IWallBehavior {
	MazeRunner mazeRunner = MazeRunner.getInstance();
	public boolean executeBehavior();
	public void shotted();
	public boolean isGone();
}

class CanBeDetroyed implements IWallBehavior {

	private boolean gone = false;

	@Override
	public boolean executeBehavior() {
		return true;
	}

	@Override
	public void shotted() {
		//TODO if bullet hit wall
		mazeRunner.increaseScore(DefaultValues.SCORE_GAIN_OR_LOSS);
		gone = true;
	}

	@Override
	public boolean isGone() {
		return gone;
	}
	
}

class CantBeDetroyed implements IWallBehavior {

	@Override
	public boolean executeBehavior() {
		return false;
	}

	@Override
	public void shotted() {
		//TODO if bullet hit wall
		//can't be destroyed :P
	}

	@Override
	public boolean isGone() {
		return false;
	}
}
