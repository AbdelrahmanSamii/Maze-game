package M.saveAndLoad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Formatter;
import M.Levels.Levels;

public class SaveAndLoad {

	private static Formatter x;

	private static BufferedReader br;
	private static double[][] theMaze;
	private static int lifes, health, score, time, level, bullets, rows, cols, trees, monsters, bombs, gifts, obstacleTrees;
	private static String difficulty;

	private static void openFile(File file) {
		try {
			x = new Formatter(file);
		} catch (Exception e) {
			System.err.println("couldn't open file");
		}
	}

	public static void save(File file, double[][] maze, int lives, int health, int score, int bullets, int time, String difficulty, int level
			, int rows, int cols, int trees, int monsters, int bombs, int gifts, int obstacleTrees) {
		openFile(file);
		// save maze
		x.format("%s\n", rows);
		x.format("%s\n", cols);

		x.format("maze\n");
		for (double[] row : maze) {
			for (double col : row) {
				x.format("%s\n", col);
			}
		}
		
		x.format("%s\n", trees);
		x.format("%s\n", monsters);
		x.format("%s\n", bombs);
		x.format("%s\n", gifts);
		x.format("%s\n", obstacleTrees);
		

		// save data
		x.format("playerData\n");
		x.format("lives\n");
		x.format("%s\n", lives);
		x.format("health\n");
		x.format("%s\n", health);
		x.format("score\n");
		x.format("%s\n", score);
		x.format("bullets\n");
		x.format("%s\n", bullets);
		x.format("time\n");
		x.format("%s\n", time);
		x.format("difficulty\n");
		x.format("%s\n", difficulty);
		x.format("level\n");
		x.format("%s\n", level);
		closeFile();
	}

	public static void load(File file) {
		String line;
		try {
			br = new BufferedReader(new FileReader(file));
			rows = Integer.parseInt(br.readLine());
			cols = Integer.parseInt(br.readLine());
			if ((line = br.readLine()) != null && line.equals("maze")) {
				theMaze = new double[rows][cols];
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						if ((line = br.readLine()) != null) {
							theMaze[i][j] = Double.parseDouble(line);
						}
					}
				}
			}

			if ((line = br.readLine()) != null) {
				trees= Integer.parseInt(line);
			}
			if ((line = br.readLine()) != null) {
				monsters= Integer.parseInt(line);
			}
			if ((line = br.readLine()) != null) {
				bombs= Integer.parseInt(line);
			}
			if ((line = br.readLine()) != null) {
				gifts= Integer.parseInt(line);
			}
			if ((line = br.readLine()) != null) {
				obstacleTrees= Integer.parseInt(line);
			}

			if ((line = br.readLine()) != null && line.equals("playerData")) {
				while ((line = br.readLine()) != null) {
					if (line.equals("lives")) {
						lifes = Integer.parseInt(br.readLine());
					} else if (line.equals("health")) {
						health = Integer.parseInt(br.readLine());
					} else if (line.equals("score")) {
						score = Integer.parseInt(br.readLine());
					} else if (line.equals("bullets")) {
						bullets = Integer.parseInt(br.readLine());
					} else if (line.equals("time")) {
						time = Integer.parseInt(br.readLine());
					} else if (line.equals("difficulty")) {
						difficulty = br.readLine();
					} else if (line.equals("level")) {
						level = Integer.parseInt(br.readLine());
					}

				}
			}
			
			br.close();
			//Levels newLevel = new Levels(level, rows, cols, bullets, trees, monsters, bombs, gifts, obstacleTrees, health, lifes, score, theMaze, difficulty, time);
			//newLevel.run();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void closeFile() {
		x.close();
	}
}
