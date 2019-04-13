package M.MazeRunner.LifeAndHealth;

public interface PlayerState {
	
	void loseAlife();

	void gainAlife();

	void loseHealth(int damage);

	void gainHealth(int health);
}
