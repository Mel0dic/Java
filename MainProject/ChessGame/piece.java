import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

public class piece{

	public Color pieceColor;
	public int xPosition;
	public int yPosition;

	public piece(int xStartPosition, int yStartPosition, Color pieceColor){
		xPosition = xStartPosition;
		yPosition = yStartPosition;
		this.pieceColor = pieceColor;
	}

	final public void movePiece(int x, int y){
		xPosition = x;
		yPosition = yPosition;
	}

}

class pawn extends piece{

	private BufferedImage imgBlack;

	public pawn(int xStartPosition, int yStartPosition, Color pieceColor){
		//Super the initial variables to piece
		super(xStartPosition, yStartPosition, pieceColor);
		//Get the image for the piece and print exception if there is one
		try{
			imgBlack = ImageIO.read(new File("ChessPieceImages\\pawnBlack.png"));
		}catch(IOException ex){ ex.printStackTrace(); }
	}

	public void paintPiece(Graphics g, JPanel panel){
		//Paint the image at x, y
		g.drawImage(imgBlack, this.xPosition, this.yPosition, panel);
	}

}

class king extends piece{

	public king(int xStartPosition, int yStartPosition, Color pieceColor){
		super(xStartPosition, yStartPosition, pieceColor);
	}

	public void paintPiece(Graphics g){
		g.setColor(this.pieceColor);
	}

}

class queen extends piece{

	public queen(int xStartPosition, int yStartPosition, Color pieceColor){
		super(xStartPosition, yStartPosition, pieceColor);
	}

	public void paintPiece(Graphics g){
		g.setColor(this.pieceColor);
	}

}

class bishop extends piece{

	public bishop(int xStartPosition, int yStartPosition, Color pieceColor){
		super(xStartPosition, yStartPosition, pieceColor);
	}

	public void paintPiece(Graphics g){
		g.setColor(this.pieceColor);
	}

}

class knight extends piece{

	public knight(int xStartPosition, int yStartPosition, Color pieceColor){
		super(xStartPosition, yStartPosition, pieceColor);
	}

	public void paintPiece(Graphics g){
		g.setColor(this.pieceColor);
	}

}

class castle extends piece{

	public castle(int xStartPosition, int yStartPosition, Color pieceColor){
		super(xStartPosition, yStartPosition, pieceColor);
	}

	public void paintPiece(Graphics g){
		g.setColor(this.pieceColor);
	}

}