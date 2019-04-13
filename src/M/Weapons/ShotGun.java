package M.Weapons;

import M.MazeRunner.MazeRunner;

public class ShotGun extends Weapon {

	public ShotGun() {
		MazeRunner mazeRunner = MazeRunner.getInstance();
		mazeRunner.setWeaponType(this);
		setWeaponBehavior(new Shot());
	}
}
