package M.MazeRunner.LifeAndHealth;

import M.DefaultValues.DefaultValues;

public class HasLivesMediumHealth implements PlayerState {

	Life life ;
	
	public HasLivesMediumHealth(Life life) {
		this.life = life;
	}

	@Override
	public void loseAlife() {
		life.numberOfLives--;
		if(life.numberOfLives == 0){
			life.setState(life.getHasNoLivesMediumHealth());
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
		life.Health -= damage;
		if(life.Health == DefaultValues.LOW_HEALTH){
			life.setState(life.getHasLivesLowHealth());
		}else if (life.Health < DefaultValues.LOW_HEALTH) {
			life.numberOfLives--;
			life.Health = DefaultValues.FULL_HEALTH;
			life.setState(life.getHasLivesFullHealth());
		}
	}

	@Override
	public void gainHealth(int health) {
		life.Health += health;
		if(life.Health == DefaultValues.FULL_HEALTH){
			life.setState(life.getHasLivesFullHealth());
		}
	}
}
