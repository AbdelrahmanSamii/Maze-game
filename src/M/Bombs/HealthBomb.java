package M.Bombs;

public class HealthBomb extends Bomb {
	public HealthBomb() {
		setBombBehavior(new HealthLossBehavior());
	}
}
