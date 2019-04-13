package M.leaderBoard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.Formatter;
import java.util.LinkedList;

public class LeaderBoard {

	private static String path = System.getProperty("user.dir") + "\\src\\material\\LeaderBoard\\";

	public void addScore(String name, int score, String difficulty) {
		LinkedList<ScoreNode> leaderBoard = getLeaderBoard(difficulty);
		leaderBoard.add(new ScoreNode(name, score));
		leaderBoard = checkExistsName(leaderBoard);
		sortRecords(difficulty, leaderBoard);
	}

	@SuppressWarnings("resource")
	public static LinkedList<ScoreNode> getLeaderBoard (String difficulty){
		LinkedList<ScoreNode> leaderBoard = new LinkedList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(path + "leaderBoard " + difficulty + ".txt")));
			String name,score;
			while((name = br.readLine())!= null && (score = br.readLine())!= null){
				leaderBoard.add(new ScoreNode(name, Integer.parseInt(score)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leaderBoard;
	}

	private static LinkedList<ScoreNode> checkExistsName(LinkedList<ScoreNode> leaderBoard) {
		for(int i = 0; i < leaderBoard.size() - 1; i++){
			if (leaderBoard.get(i).getName().equals(leaderBoard.get(leaderBoard.size()-1).getName())) {
				if (leaderBoard.get(i).getScore() >= leaderBoard.get(leaderBoard.size()-1).getScore()) {
					leaderBoard.removeLast();
				} else if (leaderBoard.get(i).getScore() < leaderBoard.get(leaderBoard.size()-1).getScore()) {
					leaderBoard.remove(i);
				}
				break;
			}
		}
		return leaderBoard;
	}

	// here it is
	private static void sortRecords (String difficulty, LinkedList<ScoreNode> leaderBoard){
		for(int i = leaderBoard.size()-1; i > 0; i--){
			if(leaderBoard.get(i).getScore() < leaderBoard.get(i - 1).getScore() ){
				Collections.swap(leaderBoard, i, i - 1);
			}
		}
		writeRecordsAfterSorting(difficulty, leaderBoard);
	}

	private static void writeRecordsAfterSorting(String difficulty, LinkedList<ScoreNode> leaderBoard){
		Formatter x;
		try {
			x = new Formatter(new File(path + "leaderBoard " + difficulty + ".txt"));
			for(ScoreNode s : leaderBoard){
				x.format("%s\n", s.getName());
				x.format("%s\n", s.getScore());
			}
			x.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
