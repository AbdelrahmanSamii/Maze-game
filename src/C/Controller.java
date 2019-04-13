package C;

import M.Bombs.HealthBomb;
import M.Bombs.IBomb;
import M.Bombs.LifeBomb;
import M.Gifts.BulletGift;
import M.Gifts.HealthGift;
import M.Gifts.IGift;
import M.Gifts.LifeGift;
import M.MazeRunner.MazeRunner;
import M.Monsters.IMonster;
import M.Monsters.KillerMonster;
import M.Monsters.NormalMonster;
import M.Walls.IWall;
import M.Walls.TreeWall;
import V.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;


public class Controller implements Initializable{
    private Image runner = new Image(getClass().getResource("Images/SteadyDown.png").toString(), 20 , 20 , false , false);
    private ImageView run =  new ImageView(runner) ;

    private HashMap<String , ImageView> imageHashMap = new HashMap<String , ImageView>();



    private Main main = new Main() ;
    @FXML
    private Pane pane ;
    @FXML
    public static GridPane grid;

    public MazeRunner mazeRunner = MazeRunner.getInstance();
    public double[][] generatedMaze  ;
    public static int Xposition ;
    public static int Yposition ;
    private int oldX;
    private int oldY;
    private int shootedX;
    private int shootedY;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public void initializeGridLayout() throws Exception {
        Image stoneWall = new Image(getClass().getResource("Images/stoneWall.jpg").toString(), 20 , 20 , false , false);
        Image woodWall = new Image(getClass().getResource("Images/woodWall.jpg").toString(), 20 , 20 , false , false);
        Image empty = new Image(getClass().getResource("Images/empty.png").toString(), 20 , 20 , false , false);
        Image monster = new Image(getClass().getResource("Images/monster.gif").toString(), 20 , 20 , false , false);
        Image emmo = new Image(getClass().getResource("Images/emmo.png").toString(), 20 , 20 , false , false);
        Image bomb = new Image(getClass().getResource("Images/bomb.png").toString(), 20 , 20 , false , true);

        pane.getChildren().remove(grid);
        grid = new GridPane() ;
        for (int i = 0 ; i < generatedMaze.length ; i ++)
        {
            for (int j = 0 ; j < generatedMaze[0].length ; j ++)
            {
                if (generatedMaze[i][j] == 1.1)
                {
                    grid.add(new ImageView(stoneWall) , i , j);
                }else if (generatedMaze[i][j] == 1.2)
                {
                    ImageView temp = new ImageView(woodWall);
                    this.imageHashMap.put("" + i + "" + j , temp);
                    grid.add(temp , i , j);
                }else if (generatedMaze[i][j] == 2.1)
                {
                    ImageView temp = new ImageView(monster);
                    this.imageHashMap.put("" + i + "" + j , temp);
                    grid.add(temp , i , j);
                }else if (generatedMaze[i][j] == 2.2)
                {
                    ImageView temp = new ImageView(monster);
                    this.imageHashMap.put("" + i + "" + j , temp);
                    grid.add(temp , i , j);
                }
                else if (generatedMaze[i][j] == 3.2)
                {
                    ImageView temp = new ImageView(bomb);
                    this.imageHashMap.put("" + i + "" + j , temp);
                    grid.add(temp , i , j);
                }
                else if (generatedMaze[i][j] == 8.0)
                {
                    grid.add(run , i , j);
                    this.Xposition = i ;
                    this.Yposition = j ;
                }
                else if (generatedMaze[i][j] == 3.1)
                {
                    ImageView temp = new ImageView(bomb);
                    this.imageHashMap.put("" + i + "" + j , temp);
                    grid.add(temp , i , j);
                }
                else if (generatedMaze[i][j] == 4.1)
                {
                    ImageView temp = new ImageView(emmo);
                    this.imageHashMap.put("" + i +""+ j , temp);
                    grid.add(temp , i , j);
                }else if (generatedMaze[i][j] == 4.2)
                {
                    ImageView temp = new ImageView(emmo);
                    this.imageHashMap.put("" + i +""+ j , temp);
                    grid.add(temp , i , j);
                }else if (generatedMaze[i][j] == 4.3)
                {
                    ImageView temp = new ImageView(emmo);
                    this.imageHashMap.put("" + i +""+ j , temp);
                    grid.add(temp , i , j);
                }else
                {
                    grid.add( new ImageView(empty) , i , j);
                }
            }
        }
        grid.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        pane.getChildren().add(grid);
    }

    public void setGeneratedMaze(double[][] generatedMaze) {
        this.generatedMaze = generatedMaze;
    }

    public void move(String direction) throws Exception {
        if (validMove(generatedMaze , direction)){
            GridPane temp = (GridPane) this.pane.getChildren().get(0);
            pane.getChildren().remove(grid);
            temp.getChildren().remove(run) ;
            temp.add(run , Xposition , Yposition);
            pane.getChildren().add(temp);

            if (generatedMaze[Xposition][Yposition] == 4.1
                    ||generatedMaze[Xposition][Yposition] == 4.2
                    ||generatedMaze[Xposition][Yposition] == 4.3){
                getGift(Xposition , Yposition);
            }else if (generatedMaze[Xposition][Yposition] == 3.1
                    ||generatedMaze[Xposition][Yposition] == 3.2){
                getBombDamage(Xposition , Yposition);
            }else if (generatedMaze[Xposition][Yposition] == 2.1
                    ||generatedMaze[Xposition][Yposition] == 2.2){
                getMonsterDamage(Xposition ,Yposition);
            }else if (generatedMaze[Xposition][Yposition] == 9.0){

                this.main.levelUp();
                this.generatedMaze = this.main.getMaze();
                initializeGridLayout();

            }
            changePosition();
        }

    }
    public void shoot(String direction){
        if (direction.equals("Down")){
            if (mazeRunner.shot()){
                shootDirection("Down");
            }
        }else if (direction.equals("Up")){
           if (mazeRunner.shot()){
               shootDirection("Up");
           }
        }else if (direction.equals("Left")){
            if (mazeRunner.shot()){
                shootDirection("Left");
            }
        }else if (direction.equals("Right")){
            if (mazeRunner.shot()){
                shootDirection("Right");
            }
        }
    }
    public boolean validMove(double[][] maze , String direction){
        if (direction.equals("UP")){
            if (maze[Xposition][Yposition - 1] == 1.1 || maze[Xposition][Yposition - 1] == 1.2){
                return false ;
            }else {
                oldX = Xposition;
                oldY = Yposition;
                Yposition -- ;
            }
        }else if (direction.equals("DOWN")){
            if (maze[Xposition][Yposition + 1] == 1.1 || maze[Xposition][Yposition + 1] == 1.2){
                return false ;
            }
            else {
                oldX = Xposition;
                oldY = Yposition;
                Yposition ++ ;
            }
        }else if (direction.equals("LEFT")){
            if (maze[Xposition - 1][Yposition] == 1.1 || maze[Xposition - 1][Yposition] == 1.2){
                return false ;
            }else {
                oldX = Xposition;
                oldY = Yposition;
                Xposition -- ;
            }
        }else if (direction.equals("RIGHT")){
            if (maze[Xposition + 1][Yposition] == 1.1 || maze[Xposition + 1][Yposition] == 1.2){
                return false ;
            }else {
                oldX = Xposition;
                oldY = Yposition;
                Xposition ++ ;

            }
        }
        return true ;
    }

    public void getGift(int x , int y){
        if (generatedMaze[x][y] == 4.1){
            IGift gift = new BulletGift();
            gift.givePrize();
            GridPane temp = (GridPane) this.pane.getChildren().get(0);
            pane.getChildren().remove(grid);
            temp.getChildren().remove(imageHashMap.get("" + x + "" + y)) ;
            pane.getChildren().add(temp);
            System.out.println("runner bullets" + mazeRunner.getbulletsRemains());
        }else if (generatedMaze[x][y] == 4.2){
            IGift gift = new HealthGift();
            gift.givePrize();
            GridPane temp = (GridPane) this.pane.getChildren().get(0);
            pane.getChildren().remove(grid);
            temp.getChildren().remove(imageHashMap.get("" + x + "" + y)) ;
            pane.getChildren().add(temp);
            System.out.println(" runner health" + mazeRunner.getHealthRemains());
        }else if (generatedMaze[x][y] == 4.3){
            IGift gift = new LifeGift();
            gift.givePrize();
            GridPane temp = (GridPane) this.pane.getChildren().get(0);
            pane.getChildren().remove(grid);
            temp.getChildren().remove(imageHashMap.get("" + x + "" + y)) ;
            pane.getChildren().add(temp);
            System.out.println(" runner lives" + mazeRunner.getLifesRemains());
        }
    }
    public void getBombDamage(int x , int y ){
        if (generatedMaze[x][y] == 3.1){
            IBomb bomb = new LifeBomb();
            bomb.exploded();
            GridPane temp = (GridPane) this.pane.getChildren().get(0);
            pane.getChildren().remove(grid);
            temp.getChildren().remove(imageHashMap.get("" + x + "" + y)) ;
            pane.getChildren().add(temp);
            System.out.println(" runner health" + mazeRunner.getHealthRemains());
            System.out.println(" runner lives" + mazeRunner.getLifesRemains());
        }else if (generatedMaze[x][y] == 3.2){
            IBomb bomb = new HealthBomb();
            bomb.exploded();
            GridPane temp = (GridPane) this.pane.getChildren().get(0);
            pane.getChildren().remove(grid);
            temp.getChildren().remove(imageHashMap.get("" + x + "" + y)) ;
            pane.getChildren().add(temp);
            System.out.println(" runner health" + mazeRunner.getHealthRemains());
        }
    }
    public void getMonsterDamage(int x , int y){
        if (generatedMaze[x][y] == 2.1){
            IMonster monster = new KillerMonster();
            monster.hitRunner();
            GridPane temp = (GridPane) this.pane.getChildren().get(0);
            pane.getChildren().remove(grid);
            temp.getChildren().remove(imageHashMap.get("" + x + "" + y)) ;
            pane.getChildren().add(temp);
            System.out.println(" runner health" + mazeRunner.getHealthRemains());
            System.out.println(" runner lives" + mazeRunner.getLifesRemains());
        }else if (generatedMaze[x][y] == 2.2){
            IMonster monster = new NormalMonster();
            monster.hitRunner();
            GridPane temp = (GridPane) this.pane.getChildren().get(0);
            pane.getChildren().remove(grid);
            temp.getChildren().remove(imageHashMap.get("" + x + "" + y)) ;
            pane.getChildren().add(temp);
            System.out.println(" runner health" + mazeRunner.getHealthRemains());
            System.out.println(" runner lives" + mazeRunner.getLifesRemains());

        }
    }

    public void shootDirection(String direction) {
        int i = Yposition ;
        int j = Xposition ;
        while (( i > - 1 && i < generatedMaze.length) && ( j > - 1 && j < generatedMaze.length) ) {
            if (generatedMaze[j][i] != 0.0 && generatedMaze[j][i] != 8.0 ) {
                if (generatedMaze[j][i] == 3.1) {
                    IBomb bomb = new LifeBomb();
                    bomb.shotted();
                    GridPane temp = (GridPane) this.pane.getChildren().get(0);
                    pane.getChildren().remove(grid);
                    temp.getChildren().remove(imageHashMap.get("" + j + "" + i));
                    pane.getChildren().add(temp);
                    generatedMaze[j][i] = 0.0;
                    shootedX = j;
                    shootedY = i ;

                    System.out.println(" runner health" + mazeRunner.getHealthRemains());
                    System.out.println(" runner lives" + mazeRunner.getLifesRemains());
                    System.out.println(" runner score" + mazeRunner.getScore());
                    System.out.println(" runner bullets" + mazeRunner.getbulletsRemains());
                    break;
                } else if (generatedMaze[j][i] == 3.2) {
                    IBomb bomb = new HealthBomb();
                    bomb.shotted();
                    GridPane temp = (GridPane) this.pane.getChildren().get(0);
                    pane.getChildren().remove(grid);
                    temp.getChildren().remove(imageHashMap.get("" + j + "" + i));
                    pane.getChildren().add(temp);
                    generatedMaze[j][i] = 0.0;
                    System.out.println(" runner health" + mazeRunner.getHealthRemains());
                    System.out.println(" runner lives" + mazeRunner.getLifesRemains());
                    System.out.println(" runner score" + mazeRunner.getScore());
                    System.out.println(" runner bullets" + mazeRunner.getbulletsRemains());
                } else if (generatedMaze[j][i] == 2.1) {
                    IMonster monster = new KillerMonster();
                    monster.shotted();
                    GridPane temp = (GridPane) this.pane.getChildren().get(0);
                    pane.getChildren().remove(grid);
                    temp.getChildren().remove(imageHashMap.get("" + j + "" + i));
                    pane.getChildren().add(temp);
                    generatedMaze[j][i] = 0.0;
                    shootedX = j;
                    shootedY = i ;

                    System.out.println(" runner health" + mazeRunner.getHealthRemains());
                    System.out.println(" runner lives" + mazeRunner.getLifesRemains());
                    System.out.println(" runner score" + mazeRunner.getScore());
                    System.out.println(" runner bullets" + mazeRunner.getbulletsRemains());
                    break;
                } else if (generatedMaze[j][i] == 2.2) {
                    IMonster monster = new NormalMonster();
                    monster.shotted();
                    GridPane temp = (GridPane) this.pane.getChildren().get(0);
                    pane.getChildren().remove(grid);
                    temp.getChildren().remove(imageHashMap.get("" + j + "" + i));
                    pane.getChildren().add(temp);
                    generatedMaze[j][i] = 0.0;
                    shootedX = j;
                    shootedY = i ;

                    System.out.println(" runner health" + mazeRunner.getHealthRemains());
                    System.out.println(" runner lives" + mazeRunner.getLifesRemains());
                    System.out.println(" runner score" + mazeRunner.getScore());
                    System.out.println(" runner bullets" + mazeRunner.getbulletsRemains());
                    break;
                } else if (generatedMaze[j][i] == 4.1) {
                    GridPane temp = (GridPane) this.pane.getChildren().get(0);
                    pane.getChildren().remove(grid);
                    temp.getChildren().remove(imageHashMap.get("" + j + "" + i));
                    pane.getChildren().add(temp);
                    generatedMaze[j][i] = 0.0;
                    shootedX = j;
                    shootedY = i ;

                    System.out.println(" runner health" + mazeRunner.getHealthRemains());
                    System.out.println(" runner lives" + mazeRunner.getLifesRemains());
                    System.out.println(" runner score" + mazeRunner.getScore());
                    System.out.println(" runner bullets" + mazeRunner.getbulletsRemains());
                    break;
                } else if (generatedMaze[j][i] == 4.2) {
                    GridPane temp = (GridPane) this.pane.getChildren().get(0);
                    pane.getChildren().remove(grid);
                    temp.getChildren().remove(imageHashMap.get("" + j + "" + i));
                    pane.getChildren().add(temp);
                    generatedMaze[j][i] = 0.0;
                    shootedX = j;
                    shootedY = i ;

                    System.out.println(" runner health" + mazeRunner.getHealthRemains());
                    System.out.println(" runner lives" + mazeRunner.getLifesRemains());
                    System.out.println(" runner score" + mazeRunner.getScore());
                    System.out.println(" runner bullets" + mazeRunner.getbulletsRemains());
                    break;
                } else if (generatedMaze[j][i] == 4.3) {
                    GridPane temp = (GridPane) this.pane.getChildren().get(0);
                    pane.getChildren().remove(grid);
                    temp.getChildren().remove(imageHashMap.get("" + j + "" + i));
                    pane.getChildren().add(temp);
                    generatedMaze[j][i] = 0.0;
                    shootedX = j;
                    shootedY = i ;

                    System.out.println(" runner health" + mazeRunner.getHealthRemains());
                    System.out.println(" runner lives" + mazeRunner.getLifesRemains());
                    System.out.println(" runner score" + mazeRunner.getScore());
                    System.out.println(" runner bullets" + mazeRunner.getbulletsRemains());
                    break;
                }else if (generatedMaze[j][i] == 1.2) {
                    IWall wall = new TreeWall();
                    wall.shotted();
                    GridPane temp = (GridPane) this.pane.getChildren().get(0);
                    pane.getChildren().remove(grid);
                    temp.getChildren().remove(imageHashMap.get("" + j + "" + i));
                    pane.getChildren().add(temp);
                    generatedMaze[j][i] = 0.0;
                    shootedX = j;
                    shootedY = i ;
                    System.out.println(" runner health" + mazeRunner.getHealthRemains());
                    System.out.println(" runner lives" + mazeRunner.getLifesRemains());
                    System.out.println(" runner score" + mazeRunner.getScore());
                    System.out.println(" runner bullets" + mazeRunner.getbulletsRemains());
                    break;
                }else{
                    shootedX = j;
                    shootedY = i ;
                    System.out.println(" runner bullets" + mazeRunner.getbulletsRemains());
                    break;
                }
            }
            if (direction.equals("Up")){
                i--;
            }else if (direction.equals("Down")){
                i++;
            }else if (direction.equals("Left")){
                j--;
            }else if (direction.equals("Right")){
                j++;
            }
        }
    }
                public void changePosition(){
        this.generatedMaze[Xposition][Yposition] = this.generatedMaze[oldX][oldY];
        this.generatedMaze[oldX][oldY] = 0.0 ;
    }
}
