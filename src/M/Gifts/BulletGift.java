package M.Gifts;

public class BulletGift extends Gift {

	public BulletGift() {
		setGiftBehavior(new giveBulletsBehavior());
	}
}
