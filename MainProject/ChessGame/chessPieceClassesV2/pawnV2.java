import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JPanel;

public class pawnV2 extends mainPiece{

	public static BufferedImage imgBlack;
	public static BufferedImage imgWhite;

	public static void setImages(){
		try{
			//Get the black image
			imgBlack = ImageIO.read(new File("..\\ChessPieceImages\\pawnBlack.png"));
			//Get the white image
			imgWhite = ImageIO.read(new File("..\\ChessPieceImages\\pawnWhite.png"));
		}catch(IOException ex){ ex.printStackTrace(); }
	}

	public pawnV2(int beginX, int beginY, String color){
		super(beginX, beginY, color);
	}

	public void paintImage(Graphics g, JPanel panel){
		if(color == "black"){
			paint(g, panel, imgBlack, -7, -6);
		}else if(color == "white"){
			paint(g, panel, imgWhite, -7, -6);
		}
	}

}