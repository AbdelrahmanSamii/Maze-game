package M.Gifts;

public class HealthGift extends Gift {

	public HealthGift() {
		setGiftBehavior(new giveHealthBehavior());
	}
}
