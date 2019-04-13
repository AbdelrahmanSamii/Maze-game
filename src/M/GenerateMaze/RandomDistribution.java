package M.GenerateMaze;

import java.util.Random;

public class RandomDistribution {
	private int monstersMax, bombsMax, giftsMax, treesMax, monstersCounter = 0, bombsCounter = 0 , giftsCounter = 0 , treesCounter = 0;
	private double[][] board;
	private int[] position;
	public RandomDistribution(int monstersMaxNum, int bombsMaxNum, int giftsMaxNum, int treesMaxNum, double[][] maze, int[] playerPosition) {
		monstersMax = monstersMaxNum;
		bombsMax = bombsMaxNum;
		giftsMax = giftsMaxNum;
		treesMax = treesMaxNum;
		board = maze;
		position = playerPosition;
	}

	public void monstersDistribution() {
		Random randX = new Random();
		Random randY = new Random();
		int x = 1 + randX.nextInt(board.length - 2);
		int y = 1 + randY.nextInt(board[0].length - 2);
		while (board[x][y] != 0 || (x <= position[0] + 5 && x >= position[0] - 5 && y <= position[1] + 5 && y >= position[1] - 5)) {
			x = 1 + randX.nextInt(board.length - 2);
			y = 1 + randY.nextInt(board[0].length - 2);
		}
		if (monstersCounter < monstersMax && monstersCounter % 2 == 0) {
			board[x][y] = 2.1;
			monstersCounter++;
			monstersDistribution();
		} else if (monstersCounter < monstersMax && monstersCounter % 2 == 1) {
			board[x][y] = 2.2;
			monstersCounter++;
			monstersDistribution();
		}
	}

	public void bombsDistribution() {
		Random randX = new Random();
		Random randY = new Random();
		int x = 1 + randX.nextInt(board.length - 2);
		int y = 1 + randY.nextInt(board[0].length - 2);
		while (board[x][y] != 0 || (x <= position[0] + 5 && x >= position[0] - 5 && y <= position[1] + 5 && y >= position[1] - 5)) {
			x = 1 + randX.nextInt(board.length - 2);
			y = 1 + randY.nextInt(board[0].length - 2);
		}
		if (bombsCounter < bombsMax && bombsCounter % 2 == 0) {
			board[x][y] = 3.1;
			bombsCounter++;
			bombsDistribution();
		} else if (bombsCounter < bombsMax && bombsCounter % 2 == 1) {
			board[x][y] = 3.2;
			bombsCounter++;
			bombsDistribution();
		}
	}

	public void giftsDistribution() {
		Random randX = new Random();
		Random randY = new Random();
		int x = 1 + randX.nextInt(board.length - 2);
		int y = 1 + randY.nextInt(board[0].length - 2);
		while (board[x][y] != 0 || (x <= position[0] + 5 && x >= position[0] - 5 && y <= position[1] + 5 && y >= position[1] - 5)) {
			x = 1 + randX.nextInt(board.length - 2);
			y = 1 + randY.nextInt(board[0].length - 2);
		}
		if (giftsCounter < giftsMax && giftsCounter % 3 == 0) {
			board[x][y] = 4.1;
			giftsCounter++;
			giftsDistribution();
		} else if (giftsCounter < giftsMax && giftsCounter % 3 == 1) {
			board[x][y] = 4.2;
			giftsCounter++;
			giftsDistribution();
		} else if (giftsCounter < giftsMax && giftsCounter % 3 == 2) {
			board[x][y] = 4.3;
			giftsCounter++;
			giftsDistribution();
		}
	}
	
	public void treesDistribution() {
		Random randX = new Random();
		Random randY = new Random();
		int x = 1 + randX.nextInt(board.length - 2);
		int y = 1 + randY.nextInt(board[0].length - 2);
		while (board[x][y] != 0 || (x <= position[0] + 5 && x >= position[0] - 5 && y <= position[1] + 5 && y >= position[1] - 5)) {
			x = 1 + randX.nextInt(board.length - 2);
			y = 1 + randY.nextInt(board[0].length - 2);
		}
		if (treesCounter < treesMax) {
			board[x][y] = 1.2;
			treesCounter++;
			treesDistribution();
		}
	}

	public double[][] getMaze() {
		monstersDistribution();
		bombsDistribution();
		giftsDistribution();
		treesDistribution();
		return board;
	}
}
