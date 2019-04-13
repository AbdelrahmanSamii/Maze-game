package M.Monsters;

public class KillerMonster extends Monster {
	public KillerMonster() {
		setMonsterBehavior(new LifeLossBehavior());
	}
}
