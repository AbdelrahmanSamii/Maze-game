package M.MazeRunner.LifeAndHealth;

public class HasNoLivesLowHealth implements PlayerState {
	
	Life life;

	public HasNoLivesLowHealth(Life life) {
		this.life = life;
	}

	@Override
	public void loseAlife() {
		//TODO game over 
	}

	@Override
	public void gainAlife() {
		life.numberOfLives++;
		life.setState(life.getHasLivesLowHealth());
	}

	@Override
	public void loseHealth(int damage) {
		loseAlife();
	}

	@Override
	public void gainHealth(int health) {
		life.Health += health;
		life.setState(life.getHasNoLivesMediumHealth());
	}
}
