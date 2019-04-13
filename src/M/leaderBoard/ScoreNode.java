package M.leaderBoard;

public class ScoreNode {
	private String name;
	private int score;
	
	
	public ScoreNode(String name, int score) {
		setName(name);
		setScore(score);
	}
	
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	private void setScore(int score) {
		this.score = score;
	}
	
}
