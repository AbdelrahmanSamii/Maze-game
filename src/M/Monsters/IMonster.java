package M.Monsters;

public interface IMonster {
	public void setLength(int length);

	public int getLength();

	public void setWidth(int width);

	public int getWidth();
	
	public void hitRunner();

	public void move();
	
	public void shotted();
	
	public void disappeared();
}
