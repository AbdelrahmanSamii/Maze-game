package M.Walls;

public class TreeWall extends Wall {

	public TreeWall() {
		setWallBehavior(new CanBeDetroyed());
	}
}
