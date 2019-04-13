package M.Monsters;

public class NormalMonster extends Monster {
	public NormalMonster() {
		setMonsterBehavior(new HealthLossBehavior());
	}
}
