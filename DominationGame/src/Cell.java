
public class Cell {
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private int state;
	
	public final static int UNUSED = 0;
	public final static int PLAYER1 = 1;
	public final static int PLAYER2 = 2;
	public final static int TREASURE = 3;
	public final static int TREASURE_OPEN = 4;

	/*
	 * Initialize Block
	 */
	{
		state = UNUSED;
	}
	public Cell(int posX, int posY) {
		startX = posX;
		startY = posY;
		endX = posX + 60;
		endY = posY + 60;
	}

	public boolean enter(int centerX, int centerY) {
		if (centerX <= endX && centerX >= startX && centerY <= endY && centerY >= startY)
			return true;
		else
			return false;
	}
	
	public int getState(){
		return state;
	}
	
	public void setState(int statFlag){
		this.state = statFlag;
	}
	
	public int getPosX(){
		return startX;
	}
	
	public int getPosY(){
		return startY;
	}
}
