package M.Walls;

public class StoneWall extends Wall {

	public StoneWall() {
		setWallBehavior(new CantBeDetroyed());
	}
}
