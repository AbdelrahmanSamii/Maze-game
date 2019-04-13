package V;

import C.Controller;
import M.Difficulties.Difficulty;
import M.Difficulties.DifficultyFactory;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    private String difficulty = "Easy";
    private static double[][] maze;
    private static Difficulty mazeDifficulity;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = (Parent) loader.load();
        Controller mazeController = loader.getController();
        primaryStage.setTitle("Maze Runner");
        mazeDifficulity = new DifficultyFactory().checkDifficulty(difficulty);
        mazeDifficulity.run();
        this.maze = mazeDifficulity.getLevel().getMaze();
        mazeController.setGeneratedMaze(this.getMaze());
        mazeController.initializeGridLayout();
        primaryStage.setScene(new Scene(root, 1000, 680));
        primaryStage.show();
        primaryStage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        try {
                            mazeController.move("UP");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case DOWN:
                        try {
                            mazeController.move("DOWN");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case LEFT:
                        try {
                            mazeController.move("LEFT");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case RIGHT:
                        try {
                            mazeController.move("RIGHT");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case X:
                        mazeController.shoot("Down");
                        break;
                    case W:
                        mazeController.shoot("Up");
                        break;
                    case D:
                        mazeController.shoot("Right");
                        break;
                    case A:
                        mazeController.shoot("Left");
                        break;

                }


            }
        });


    }


    public static void main(String[] args) {
        launch(args);
    }

    public static double[][] getMaze() {
        return maze;
    }

    public void levelUp() {
        this.mazeDifficulity.win();
        this.maze = this.mazeDifficulity.getLevel().getMaze();


    }
}

