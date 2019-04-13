package M.MazeRunner;

import M.DefaultValues.DefaultValues;
import M.MazeRunner.LifeAndHealth.Life;
import M.Weapons.Weapon;

public class MazeRunner implements IMazeRunner {

	private Life life = new Life();
	private int bullets, score;
	private Weapon weaponType;
	private static MazeRunner mazeRunner = null;

	private MazeRunner() {
		setNumberOfBullets(DefaultValues.NUM_OF_BULLETS);
		setScore(DefaultValues.SCORE);
	}

	public static MazeRunner getInstance() {
		if (mazeRunner == null) {
			mazeRunner = new MazeRunner();
		}
		return mazeRunner;
	}
	
	public void setWeaponType(Weapon weaponType) {
		this.weaponType = weaponType;
	}
	@Override
	public Weapon getWeaponType() {
		return weaponType;
	}
	
	@Override
	public int getLifesRemains() {
		return this.life.getNumberOfLives();
	}
	@Override
	public void gainExtraLife() {
		life.gainAlife();
	}
	@Override
	public void loseAlife() {
		life.loseAlife();
	}

	@Override
	public int getHealthRemains() {
		return this.life.getHealth();
	}
	@Override
	public void increaseHealth(int bonus) {
		this.life.gainHealth(bonus);
	}
	@Override
	public void takeDamage(int damage) {
		this.life.loseHealth(damage);
	}

	public void setNumberOfBullets(int bullets) {
		this.bullets = bullets;
	}
	@Override
	public int getbulletsRemains() {
		return this.bullets;
	}
	@Override
	public void increaseBullets(int bonus) {
		bullets += bonus;
		if (bullets >= 6) {
			reload();
		}
		
	}
	@Override
	public Boolean shot() {
		if (bullets == 0) {
			return false;
		}
		bullets--;
		return true;
		//weaponType.shot();
	}
	@Override
	public void reload() {
		setNumberOfBullets(DefaultValues.NUM_OF_BULLETS);
	}

	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public int getScore() {
		return score;
	}
	@Override
	public void increaseScore(int bonus) {
		score += bonus;
	}
	@Override
	public void decreaseScore(int damage) {
		score -= damage;
	}
}
