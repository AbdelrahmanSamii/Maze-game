package M.Walls;

public interface IWall {
	public void setLength (int length);
	public void setWidth (int width);
	public int getLength ();
	public int getwidth ();
	public boolean canBeDestroyed();
	public void shotted();
	public void disappeared();
}
