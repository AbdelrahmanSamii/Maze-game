package M.Monsters;

public class Monster implements IMonster {

	private IMonsterBehavior monsterBehavior;
	private int length;
	private int width;

	public void setMonsterBehavior(IMonsterBehavior monsterBehavior) {
		this.monsterBehavior = monsterBehavior;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void move() {
		//TODO movement
	}

	@Override
	public void hitRunner() {
		monsterBehavior.executeBehaviorHit();
	}

	@Override
	public void shotted() {
		monsterBehavior.executeBehaviorShotted();
		if (monsterBehavior.isGone()) {
			disappeared();
		}
	}

	@Override
	public void disappeared() {
		//TODO monster is disappeared
	}
}
