package M.leaderBoard;

import java.util.LinkedList;

public class leaderboardMain {

	public static void main(String[] args) {
		LeaderBoard list = new LeaderBoard();
		LinkedList<ScoreNode> leaderBoard = new LinkedList<>();
		String name;
		int score;

		name = "mazen";
		score = 1175;
		list.addScore(name, score, "Hard");
		System.out.println("d5lt " + name +" w el score " + score);
		leaderBoard = LeaderBoard.getLeaderBoard("Hard");

		name = "ahmed";
		score = 1200;
		list.addScore(name, score, "Hard");
		System.out.println("d5lt " + name +" w el score " + score);
		leaderBoard = LeaderBoard.getLeaderBoard("Hard");

		name = "belal";
		score = 1150;
		list.addScore(name, score, "Hard");
		System.out.println("d5lt " + name +" w el score " + score);
		leaderBoard = LeaderBoard.getLeaderBoard("Hard");

		name = "sara";
		score = 1155;
		list.addScore(name, score, "Hard");
		System.out.println("d5lt " + name +" w el score " + score + "\n");
		leaderBoard = LeaderBoard.getLeaderBoard("Hard");

		for(ScoreNode s : leaderBoard){
			System.out.println(s.getName() + "   " + s.getScore() + "\n");
		}
	}
}
