package M.GenerateMaze;

public class MazePrinter {

	public static void main(String[] args) {
		int row = 2, column = 2, treesMax = 10, monstersMaxNum = 3, bombsMaxNum = 3, giftsMaxNum = 3, obstacleTreesMax = 3;
		RecursiveDivision mazeGenerator = new RecursiveDivision(row, column, treesMax);
		mazeGenerator.makeMaze();
		double[][] board = mazeGenerator.getMaze();
		int[] position = mazeGenerator.getPlayerPosition();
		RandomDistribution mazeDistribution = new RandomDistribution(monstersMaxNum, bombsMaxNum, giftsMaxNum, obstacleTreesMax, board, position);
		board = mazeDistribution.getMaze();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 0) {
					System.out.print("    ");
				} else {
					System.out.print(board[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
