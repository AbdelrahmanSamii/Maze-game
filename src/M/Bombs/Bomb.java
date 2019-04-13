package M.Bombs;

public class Bomb implements IBomb {

	private IBombBehavior bombBehavior;
	private int length, width;

	public void setBombBehavior(IBombBehavior bombBehavior) {
		this.bombBehavior = bombBehavior;
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
	public void exploded() {
		bombBehavior.executeBehaviorExploded();
		if (bombBehavior.isGone()) {
			disappeared();
		}
	}

	@Override
	public void shotted() {
		bombBehavior.executeBehaviorShotted();
		if (bombBehavior.isGone()) {
			disappeared();
		}
	}

	@Override
	public void disappeared() {
		//TODO bomb is disappeared
	}
}
