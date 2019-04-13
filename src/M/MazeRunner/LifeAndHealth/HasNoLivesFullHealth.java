package M.MazeRunner.LifeAndHealth;

import M.DefaultValues.DefaultValues;

public class HasNoLivesFullHealth implements PlayerState {

	Life life;
	public HasNoLivesFullHealth(Life life) {
		this.life = life;
	}

	@Override
	public void loseAlife() {
		// TODO game over
	}

	@Override
	public void gainAlife() {
		life.numberOfLives++;
		life.setState(life.getHasLivesFullHealth());
	}

	@Override
	public void loseHealth(int damage) {
		life.Health -= damage;
		if(life.Health >= DefaultValues.MEDIUM_HEALTH){
			life.setState(life.hasNoLivesMediumHealth);
		}else if (life.Health == DefaultValues.LOW_HEALTH){
			life.setState(life.hasNoLivesLowHealth);
		}
	}

	@Override
	public void gainHealth(int health) {
		// TODO  m4 3arfein :D 
		
	}
}
