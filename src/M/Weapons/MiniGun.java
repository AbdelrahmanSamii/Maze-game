package M.Weapons;

import M.MazeRunner.MazeRunner;

public class MiniGun extends Weapon {
	public MiniGun() {
		MazeRunner mazeRunner = MazeRunner.getInstance();
		mazeRunner.setWeaponType(this);
		setWeaponBehavior(new Mini());
	}
}
