import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JPanel;

public class mainPiece{

	private int xPosition;
	private int yPosition;
	private String color;

	public mainPiece(int xPosition, int yPosition){
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	public final void movePiece(int x, int y, String color){
		xPosition = x;
		yPosition = y;
		this.color = color;
	}

	public void paint(Graphics g, JPanel panel, BufferedImage image){
		g.drawImage(image, xPosition, yPosition, panel);
	}

	public void paint(Graphics g, JPanel panel, BufferedImage image, int xOffset, int yOffset){
		g.drawImage(image, (xPosition + xOffset), (yPosition + yOffset), panel);
	}

	public String getColor(){
		return color;
	}

	public int getX(){
		return xPosition;
	}

	public int getY(){
		return yPosition;
	}

}