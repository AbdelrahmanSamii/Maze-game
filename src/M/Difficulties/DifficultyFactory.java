package M.Difficulties;

public class DifficultyFactory {

	public Difficulty checkDifficulty(String className) {
		Difficulty difficult = null;
		if (className.equals("Easy")) {
			difficult = new Easy();
		} else if (className.equals("Normal")) {
			difficult = new Normal();
		} else if (className.equals("Hard")) {
			difficult = new Hard();
		}
		return difficult;
	}
}
