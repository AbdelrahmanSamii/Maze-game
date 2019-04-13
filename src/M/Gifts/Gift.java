package M.Gifts;

public class Gift implements IGift {
	
	private IGiftBehavior giftBehavior;
	private int length,width;
	
	public void setGiftBehavior(IGiftBehavior giftBehavior){
		this.giftBehavior = giftBehavior;
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
	public void givePrize(){
		giftBehavior.executeBehavior();
		disappeared();
	}

	@Override
	public void disappeared() {
		//TODO gift is disappeared
	}
}
