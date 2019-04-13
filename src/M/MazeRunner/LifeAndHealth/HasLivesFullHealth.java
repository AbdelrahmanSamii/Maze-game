package M.MazeRunner.LifeAndHealth;

import M.DefaultValues.DefaultValues;

public class HasLivesFullHealth implements PlayerState {
	
	Life life ;

	public HasLivesFullHealth(Life life) {
		this.life = life;
	}

	@Override
	public void loseAlife() {
		life.numberOfLives--;
		if(life.numberOfLives == 0){
			life.setState(life.getHasNoLivesFullHealth());
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
		if(life.Health >= DefaultValues.MEDIUM_HEALTH){
			life.setState(life.getHasLivesMediumHealth());
		}else if (life.Health == DefaultValues.LOW_HEALTH){
			life.setState(life.getHasLivesLowHealth());			
		}
	}

	@Override
	public void gainHealth(int health) {
		// TODO m4 3aref :D
		
	}
}
