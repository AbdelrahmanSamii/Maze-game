package M.Weapons;

public class Weapon implements IWeapon {

	private IWeaponBehavior weaponBehavior;
	private int length,width;
	
	public void setWeaponBehavior(IWeaponBehavior weaponBehavior){
		this.weaponBehavior = weaponBehavior;
	}

	@Override
	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public int getLength() {
		return this.length;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public void shot() {
		weaponBehavior.executeBehavior();
	}
}
