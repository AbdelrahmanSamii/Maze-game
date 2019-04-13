package M.Bombs;

public class LifeBomb extends Bomb {
	public LifeBomb() {
		setBombBehavior(new LifeLossBehavior());
	}
}
