package M.MazeRunner.LifeAndHealth;

import M.DefaultValues.DefaultValues;

public class Life {
	PlayerState hasNoLivesLowHealth;
	PlayerState hasNoLivesMediumHealth;
	PlayerState hasNoLivesFullHealth;
	PlayerState hasLivesLowHealth;
	PlayerState hasLivesMediumHealth;
	PlayerState hasLivesFullHealth;

	PlayerState currentState;

	int numberOfLives = DefaultValues.NUM_OF_LIFES;
	int Health = DefaultValues.FULL_HEALTH;

	public Life() {
		hasNoLivesLowHealth = new HasNoLivesLowHealth(this);
		hasNoLivesMediumHealth = new HasNoLivesMediumHealth(this);
		hasNoLivesFullHealth = new HasNoLivesFullHealth(this);
		hasLivesLowHealth = new HasLivesLowHealth(this);
		hasLivesMediumHealth = new HasLivesMediumHealth(this);
		hasLivesFullHealth = new HasLivesFullHealth(this);

		setState(hasLivesFullHealth);
	}

	public void setState(PlayerState state) {
		currentState = state;
	}

	public int getNumberOfLives() {
		return numberOfLives;
	}

	public int getHealth() {
		return Health;
	}

	public PlayerState getHasLivesMediumHealth() {
		return hasLivesMediumHealth;
	}

	public PlayerState getHasNoLivesMediumHealth() {
		return hasNoLivesMediumHealth;
	}

	public void loseAlife() {
		currentState.loseAlife();
	}

	public void gainAlife() {
		currentState.gainAlife();
	}

	public void loseHealth(int damage) {
		currentState.loseHealth(damage);
	}

	public void gainHealth(int health) {
		currentState.gainHealth(health);
	}

	public PlayerState getHasNoLivesLowHealth() {
		return hasNoLivesLowHealth;
	}

	public PlayerState getHasNoLivesFullHealth() {
		return hasNoLivesFullHealth;
	}

	public PlayerState getHasLivesFullHealth() {
		return hasLivesFullHealth;
	}

	public PlayerState getHasLivesLowHealth() {
		return hasLivesLowHealth;
	}

}
