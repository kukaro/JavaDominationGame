import java.awt.Image;

import javax.swing.ImageIcon;

public class Packman {
	private int posX;
	private int posY;
	private int centerX;
	private int centerY;
	private ImageIcon ii;

	Packman(int x, int y,ImageIcon ii) {
		setPosX(x);
		setPosY(y);
		this.ii = ii;
	}
	
	public Image getImage(){
		return ii.getImage();
	}
	
	public int getPosX(){
		return posX;
	}
	public int getPosY(){
		return posY;
	}
	public void setPosX(int x){
		this.posX = x;
		centerX = posX + 30;
	}
	public void setPosY(int y){
		this.posY = y;
		centerY = posY + 30;
	}
	
	public int getCenterX(){
		return centerX;
	}
	public int getCenterY(){
		return centerY;
	}
}
