package M.MazeRunner.LifeAndHealth;

import M.DefaultValues.DefaultValues;

public class HasLivesLowHealth implements PlayerState {

	Life life;
	
	public HasLivesLowHealth(Life life) {
		this.life = life;
	}

	@Override
	public void loseAlife() {
		life.numberOfLives--;
		if(life.numberOfLives == 0){
			life.setState(life.getHasNoLivesLowHealth());
		}
	}

	@Override
	public void gainAlife() {
		if(life.numberOfLives == DefaultValues.NUM_OF_LIFES){
			// TODO m4 3aref
		}else{
			life.numberOfLives ++;
		}
	}

	@Override
	public void loseHealth(int damage) {
		life.Health = DefaultValues.FULL_HEALTH;
		loseAlife();
	}

	@Override
	public void gainHealth(int health) {
		life.Health += health;
		life.setState(life.getHasLivesMediumHealth());
	}

}
