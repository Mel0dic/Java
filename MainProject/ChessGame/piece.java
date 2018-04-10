import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

public class piece{

	public int xPosition;
	public int yPosition;

	public piece(int xStartPosition, int yStartPosition){
		xPosition = xStartPosition;
		yPosition = yStartPosition;
	}

	final public void movePiece(int x, int y){
		xPosition = x;
		yPosition = yPosition;
	}

	public int getX(){
		return xPosition;
	}

	public int getY(){
		return yPosition;
	}

}

class pawn extends piece{

	private static BufferedImage imgWhite;
	private static BufferedImage imgBlack;
	private String pieceColor;

	public static void setDrawings(){
		//Get the image for the piece and print exception if there is one
		try{
			//Get the black image
			imgBlack = ImageIO.read(new File("ChessPieceImages\\pawnBlack.png"));
			//Get the white image
			imgWhite = ImageIO.read(new File("ChessPieceImages\\pawnWhite.png"));
		}catch(IOException ex){ ex.printStackTrace(); }
	}

	public pawn(int xStartPosition, int yStartPosition, String pieceColor){
		//Super the initial variables to piece
		super(xStartPosition, yStartPosition);
		this.pieceColor = pieceColor;
	}

	public void paintPiece(Graphics g, JPanel panel){
		//Paint the image at x, y
		if(pieceColor.equals("white")){
			g.drawImage(imgWhite, (this.xPosition-7), (this.yPosition-6), panel);
		}else if(pieceColor.equals("black")){
			g.drawImage(imgBlack, (this.xPosition-7), (this.yPosition-6), panel);
		}
	}

}

class king extends piece{

	private static BufferedImage imgWhite;
	private static BufferedImage imgBlack;
	private String pieceColor;

	public static void setDrawings(){
		//Get the image for the piece and print exception if there is one
		try{
			//Get the black image
			imgBlack = ImageIO.read(new File("ChessPieceImages\\kingBlack.png"));
			//Get the white image
			imgWhite = ImageIO.read(new File("ChessPieceImages\\kingWhite.png"));
		}catch(IOException ex){ ex.printStackTrace(); }
	}

	public king(int xStartPosition, int yStartPosition, String pieceColor){
		super(xStartPosition, yStartPosition);
		this.pieceColor = pieceColor;
	}

	public void paintPiece(Graphics g, JPanel panel){
		//Paint the image at x, y
		if(pieceColor.equals("white")){
			g.drawImage(imgWhite, (this.xPosition-7), (this.yPosition-6), panel);
		}else if(pieceColor.equals("black")){
			g.drawImage(imgBlack, (this.xPosition-7), (this.yPosition-6), panel);
		}
	}

}

class queen extends piece{

	private static BufferedImage imgWhite;
	private static BufferedImage imgBlack;
	private String pieceColor;

	public static void setDrawings(){
		//Get the image for the piece and print exception if there is one
		try{
			//Get the black image
			imgBlack = ImageIO.read(new File("ChessPieceImages\\queenBlack.png"));
			//Get the white image
			imgWhite = ImageIO.read(new File("ChessPieceImages\\queenWhite.png"));
		}catch(IOException ex){ ex.printStackTrace(); }
	}

	public queen(int xStartPosition, int yStartPosition, String pieceColor){
		super(xStartPosition, yStartPosition);
		this.pieceColor = pieceColor;
	}

	public void paintPiece(Graphics g, JPanel panel){
		//Paint the image at x, y
		if(pieceColor.equals("white")){
			g.drawImage(imgWhite, (this.xPosition-7), (this.yPosition-6), panel);
		}else if(pieceColor.equals("black")){
			g.drawImage(imgBlack, (this.xPosition-7), (this.yPosition-6), panel);
		}
	}

}

class bishop extends piece{

	private static BufferedImage imgWhite;
	private static BufferedImage imgBlack;
	private String pieceColor;

	public static void setDrawings(){
		//Get the image for the piece and print exception if there is one
		try{
			//Get the black image
			imgBlack = ImageIO.read(new File("ChessPieceImages\\bishopBlack.png"));
			//Get the white image
			imgWhite = ImageIO.read(new File("ChessPieceImages\\bishopWhite.png"));
		}catch(IOException ex){ ex.printStackTrace(); }
	}

	public bishop(int xStartPosition, int yStartPosition, String pieceColor){
		super(xStartPosition, yStartPosition);
		this.pieceColor = pieceColor;
	}

	public void paintPiece(Graphics g, JPanel panel){
		//Paint the image at x, y
		if(pieceColor.equals("white")){
			g.drawImage(imgWhite, (this.xPosition-7), (this.yPosition-6), panel);
		}else if(pieceColor.equals("black")){
			g.drawImage(imgBlack, (this.xPosition-7), (this.yPosition-6), panel);
		}
	}

}

class knight extends piece{

	private static BufferedImage imgWhite;
	private static BufferedImage imgBlack;
	private String pieceColor;

	public static void setDrawings(){
		//Get the image for the piece and print exception if there is one
		try{
			//Get the black image
			imgBlack = ImageIO.read(new File("ChessPieceImages\\knightBlack.png"));
			//Get the white image
			imgWhite = ImageIO.read(new File("ChessPieceImages\\knightWhite.png"));
		}catch(IOException ex){ ex.printStackTrace(); }
	}

	public knight(int xStartPosition, int yStartPosition, String pieceColor){
		super(xStartPosition, yStartPosition);
		this.pieceColor = pieceColor;
	}

	public void paintPiece(Graphics g, JPanel panel){
		//Paint the image at x, y
		if(pieceColor.equals("white")){
			g.drawImage(imgWhite, (this.xPosition-7), (this.yPosition-6), panel);
		}else if(pieceColor.equals("black")){
			g.drawImage(imgBlack, (this.xPosition-7), (this.yPosition-6), panel);
		}
	}

}

class castle extends piece{

	private static BufferedImage imgWhite;
	private static BufferedImage imgBlack;
	private String pieceColor;

	public static void setDrawings(){
		//Get the image for the piece and print exception if there is one
		try{
			//Get the black image
			imgBlack = ImageIO.read(new File("ChessPieceImages\\castleBlack.png"));
			//Get the white image
			imgWhite = ImageIO.read(new File("ChessPieceImages\\castleWhite.png"));
		}catch(IOException ex){ ex.printStackTrace(); }
	}

	public castle(int xStartPosition, int yStartPosition, String pieceColor){
		super(xStartPosition, yStartPosition);
		this.pieceColor = pieceColor;
	}

	public void paintPiece(Graphics g, JPanel panel){
		//Paint the image at x, y
		if(pieceColor.equals("white")){
			g.drawImage(imgWhite, (this.xPosition-7), (this.yPosition-6), panel);
		}else if(pieceColor.equals("black")){
			g.drawImage(imgBlack, (this.xPosition-7), (this.yPosition-6), panel);
		}
	}

}