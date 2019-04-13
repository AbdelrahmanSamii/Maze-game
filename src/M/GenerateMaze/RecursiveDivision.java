package M.GenerateMaze;

import java.util.*;

public class RecursiveDivision {

	private int rows, cols, treesMax, treesCounter = 0;
	private double [][] board;
	private int[] position = new int[2];

	public RecursiveDivision(int row, int col, int treesMaxNum) {

		// initialize instance variables
		rows = row * 10 + 1;
		cols = col * 10 + 1;
		treesMax = treesMaxNum;
		board = new double[rows][cols];

		// set the maze to empty
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = 0;
			}
		}

		// make the outter 1.1s
		for (int i = 0; i < rows; i++) {
			board[i][0] = 1.1;
			board[i][cols - 1] = 1.1;
		}

		for (int i = 0; i < cols; i++) {
			board[0][i] = 1.1;
			board[rows - 1][i] = 1.1;
		}
	}

	// storefront method to make the maze
	public void makeMaze() {
		makeMaze(0, cols - 1, 0, rows - 1);
		makeOpenings();
	}

	// behind the scences actual mazemaking
	private void makeMaze(int left, int right, int top, int bottom) {
		int width = right - left;
		int height = bottom - top;

		// makes sure there is still room to divide, then picks the best
		// direction to divide into
		if (width > 2 && height > 2) {
			if (width > height) {
				divideVertical(left, right, top, bottom);
			} else if (height > width) {
				divideHorizontal(left, right, top, bottom);
			} else if (height == width) {
				Random rand = new Random();
				int pickOne = rand.nextInt(2);
				if (pickOne == 1) {
					divideVertical(left, right, top, bottom);
				} else if (pickOne == 0) {
					divideHorizontal(left, right, top, bottom);
				}
			}
		}
	}

	private void divideVertical(int left, int right, int top, int bottom) {
		Random rand = new Random();

		// find a random point to divide at
		// must be even to draw a 1.1 there
		int divide = left + 2 + rand.nextInt((right - left) / 2 - 1) * 2;
		
		boolean flag = true;

		// draw a line at the halfway point
		int pickOne = rand.nextInt(2);
		for (int i = top + 1; i < bottom; i++) {
			pickOne = rand.nextInt(2);
			if (pickOne == 1) {
				board[i][divide] = 1.1;
			} else if (pickOne == 0) {
				if (flag) {
					if (treesCounter < treesMax) {
						board[i][divide] = 1.2;
						treesCounter++;
						flag = false;
					} else {
						board[i][divide] = 1.1;
					}
				} else {
					board[i][divide] = 1.1;
				}
			}
		}

		// get a random odd integer between top and bottom and clear it
		int clearSpace = top + 1 + rand.nextInt((bottom - top) / 2 - 1) * 2;
		if (board[clearSpace][divide] == 1.2) {
			treesCounter--;
		}

		board[clearSpace][divide] = 0;

		makeMaze(left, divide, top, bottom);
		makeMaze(divide, right, top, bottom);
	}

	private void divideHorizontal(int left, int right, int top, int bottom) {
		Random rand = new Random();

		// find a random point to divide at
		// must be even to draw a 1.1 there
		int divide = top + 2 + rand.nextInt((bottom - top) / 2 - 1) * 2;

		boolean flag = true;

		// draw a line at the halfway point
		int pickOne = rand.nextInt(2);
		for (int i = left + 1; i < right; i++) {
			pickOne = rand.nextInt(2);
			if (pickOne == 1) {
				board[divide][i] = 1.1;
			} else if (pickOne == 0) {
				if (flag) {
					if (treesCounter < treesMax) {
						board[divide][i] = 1.2;
						treesCounter++;
						flag = false;
					} else {
						board[divide][i] = 1.1;
					}
				} else {
					board[divide][i] = 1.1;
				}
			}
		}

		// get a random odd integer between left and right and clear it
		int clearSpace = left + 1 + rand.nextInt((right - left) / 2 - 1) * 2;
		if (board[divide][clearSpace] == 1.2) {
			treesCounter--;
		}

		board[divide][clearSpace] = 0;

		// recur for both parts of the newly split section
		makeMaze(left, right, top, divide);
		makeMaze(left, right, divide, bottom);
	}

	public void makeOpenings() {

		Random rand = new Random(); // random number generators

		// a random location for the entrance and exit
		int exit = rand.nextInt(cols - 1);
		while (exit % 2 == 0) {
			exit = rand.nextInt(cols - 1);
		}

		// clear the location
		int border = rand.nextInt(4);
		if (border == 0) {
			board[0][exit] = 9;
			if (exit > cols / 2) {
				board[rows - 2][1] = 8;
				setPlayerPosition(rows - 2, 1);
			} else {
				board[rows - 2][cols - 2] = 8;
				setPlayerPosition(rows - 2, cols - 2);
			}
		} else if (border == 1) {
			board[rows - 1][exit] = 9;
			if (exit > cols / 2) {
				board[1][1] = 8;
				setPlayerPosition(1, 1);
			} else {
				board[1][cols - 2] = 8;
				setPlayerPosition(1, cols - 2);
			}
		} else if (border == 2) {
			board[exit][0] = 9;
			if (exit > rows / 2) {
				board[1][cols - 2] = 8;
				setPlayerPosition(1, cols - 2);
			} else {
				board[rows - 2][cols - 2] = 8;
				setPlayerPosition(rows - 2, cols - 2);
			}
		} else if (border == 3) {
			board[exit][cols - 1] = 9;
			if (exit > rows / 2) {
				board[1][1] = 8;
				setPlayerPosition(1, 1);
			} else {
				board[rows - 2][1] = 8;
				setPlayerPosition(rows - 2, 1);
			}
		}
	}

	public void setPlayerPosition(int x, int y) {
		position[0] = x;
		position[1] = y;
	}

	public int[] getPlayerPosition(){
		return position;
	}

	public double[][] getMaze() {
		return board;
	}
}
