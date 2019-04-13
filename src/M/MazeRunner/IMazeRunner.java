package M.MazeRunner;

import M.Weapons.Weapon;

public interface IMazeRunner {

	public Weapon getWeaponType();

	public int getHealthRemains();
	public void increaseHealth(int bonus);
	/**
	 * decreases the player health due to abomb or amonster
	 * @param damage
	 */
	public void takeDamage(int damage);

	public int getLifesRemains();
	/**
	 * gain extra life due to a special gift
	 */
	public void gainExtraLife();
	/**
	 * lose a life due to a special bomb
	 */
	public void loseAlife();
		
	public int getbulletsRemains();
	public void increaseBullets(int bonus);
	/**
	 * decreases the number of bullets "till now"
	 */
	public Boolean shot();
	/**
	 * set the number of bullets to default (6 bullets)
	 */
	public void reload();

	public int getScore();
	public void increaseScore(int bonus);
	public void decreaseScore(int damage);
}
