package M.Gifts;

public class LifeGift extends Gift {

	public LifeGift() {
		setGiftBehavior(new extraLifeBehavior());
	}
}
