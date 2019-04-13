package M.MazeRunner.LifeAndHealth;

import M.DefaultValues.DefaultValues;

public class HasNoLivesMediumHealth implements PlayerState {
	
	Life life;

	public HasNoLivesMediumHealth(Life life) {
		this.life = life;
	}

	@Override
	public void loseAlife() {
		// TODO game over

	}

	@Override
	public void gainAlife() {
		life.numberOfLives++;
		life.setState(life.getHasLivesMediumHealth());
	}

	@Override
	public void loseHealth(int damage) {
		life.Health -= damage;
		if(life.Health == DefaultValues.LOW_HEALTH){
			life.setState(life.getHasNoLivesLowHealth());
		}else if (life.Health < DefaultValues.LOW_HEALTH) {
			loseAlife();
		}
	}

	@Override
	public void gainHealth(int health) {
		life.Health += health;
		if(life.Health == DefaultValues.FULL_HEALTH){
			life.setState(life.getHasNoLivesFullHealth());
		}
	}
}
