package M.Walls;

public class Wall implements IWall {
	
	private IWallBehavior wallBehavior;
	private int length, width;
	
	public void setWallBehavior(IWallBehavior wallBehavior) {
		this.wallBehavior = wallBehavior;
	}

	@Override
	public void setLength (int length){
		this.length = length;
	}

	@Override
	public void setWidth (int width){
		this.width = width;
	}
	
	@Override
	public int getLength (){
		return this.length;
	}

	@Override
	public int getwidth (){
		return this.width;
	}

	@Override
	public boolean canBeDestroyed() {
		return wallBehavior.executeBehavior();
	}

	@Override
	public void shotted() {
		wallBehavior.shotted();
		if (wallBehavior.isGone()) {
			disappeared();
		}
	}

	@Override
	public void disappeared() {
		//TODO wall is disappeared
	}
}
