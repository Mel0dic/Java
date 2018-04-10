import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;
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
	private int moveForward;
	private int numberOfMoves = 0;
	private List<List<Integer>> canMoveToCoords;

	public static void setDrawings(){
		//Get the image for the piece and print exception if there is one
		try{
			//Get the black image
			imgBlack = ImageIO.read(new File("ChessPieceImages\\pawnBlack.png"));
			//Get the white image
			imgWhite = ImageIO.read(new File("ChessPieceImages\\pawnWhite.png"));
		}catch(IOException ex){ ex.printStackTrace(); }
	}

	public pawn(int xStartPosition, int yStartPosition, String pieceColor, int moveForward){
		//Super the initial variables to piece
		super(xStartPosition, yStartPosition);
		this.pieceColor = pieceColor;
		this.moveForward = moveForward;
	}

	public void paintPiece(Graphics g, JPanel panel){
		//Paint the image at x, y
		if(pieceColor.equals("white")){
			g.drawImage(imgWhite, (this.xPosition-7), (this.yPosition-6), panel);
		}else if(pieceColor.equals("black")){
			g.drawImage(imgBlack, (this.xPosition-7), (this.yPosition-6), panel);
		}
	}

	public List<List<Integer>> movablePositions(){
		canMoveToCoords = new ArrayList<List<Integer>>();
		canMoveToCoords.add(new ArrayList<Integer>());
		canMoveToCoords.get(0).add(xPosition);
		canMoveToCoords.get(0).add((yPosition + moveForward));
		if(numberOfMoves == 0){
			canMoveToCoords.add(new ArrayList<Integer>());
			canMoveToCoords.get(1).add(xPosition);
			canMoveToCoords.get(1).add(yPosition + (moveForward * 2));
		}
		return canMoveToCoords;
	}

}

class king extends piece{

	private static BufferedImage imgWhite;
	private static BufferedImage imgBlack;
	private String pieceColor;
	private int moveForward;
	private List<List<Integer>> canMoveToCoords;

	public static void setDrawings(){
		//Get the image for the piece and print exception if there is one
		try{
			//Get the black image
			imgBlack = ImageIO.read(new File("ChessPieceImages\\kingBlack.png"));
			//Get the white image
			imgWhite = ImageIO.read(new File("ChessPieceImages\\kingWhite.png"));
		}catch(IOException ex){ ex.printStackTrace(); }
	}

	public king(int xStartPosition, int yStartPosition, String pieceColor, int moveForward){
		super(xStartPosition, yStartPosition);
		this.pieceColor = pieceColor;
		this.moveForward = moveForward;
	}

	public void paintPiece(Graphics g, JPanel panel){
		//Paint the image at x, y
		if(pieceColor.equals("white")){
			g.drawImage(imgWhite, (this.xPosition-7), (this.yPosition-6), panel);
		}else if(pieceColor.equals("black")){
			g.drawImage(imgBlack, (this.xPosition-7), (this.yPosition-6), panel);
		}
	}

	public List<List<Integer>> movablePositions(){
		canMoveToCoords = new ArrayList<List<Integer>>();
		canMoveToCoords.add(new ArrayList<Integer>());
		canMoveToCoords.get(0).add(xPosition);
		canMoveToCoords.get(0).add((yPosition + moveForward));
		return canMoveToCoords;
	}

}

class queen extends piece{

	private static BufferedImage imgWhite;
	private static BufferedImage imgBlack;
	private String pieceColor;
	private int moveForward;
	private List<List<Integer>> canMoveToCoords;

	public static void setDrawings(){
		//Get the image for the piece and print exception if there is one
		try{
			//Get the black image
			imgBlack = ImageIO.read(new File("ChessPieceImages\\queenBlack.png"));
			//Get the white image
			imgWhite = ImageIO.read(new File("ChessPieceImages\\queenWhite.png"));
		}catch(IOException ex){ ex.printStackTrace(); }
	}

	public queen(int xStartPosition, int yStartPosition, String pieceColor, int moveForward){
		super(xStartPosition, yStartPosition);
		this.pieceColor = pieceColor;
		this.moveForward = moveForward;
	}

	public void paintPiece(Graphics g, JPanel panel){
		//Paint the image at x, y
		if(pieceColor.equals("white")){
			g.drawImage(imgWhite, (this.xPosition-7), (this.yPosition-6), panel);
		}else if(pieceColor.equals("black")){
			g.drawImage(imgBlack, (this.xPosition-7), (this.yPosition-6), panel);
		}
	}

	public List<List<Integer>> movablePositions(){
		canMoveToCoords = new ArrayList<List<Integer>>();
		canMoveToCoords.add(new ArrayList<Integer>());
		canMoveToCoords.get(0).add(xPosition);
		canMoveToCoords.get(0).add((yPosition + moveForward));
		return canMoveToCoords;
	}

}

class bishop extends piece{

	private static BufferedImage imgWhite;
	private static BufferedImage imgBlack;
	private String pieceColor;
	private int moveForward;
	private List<List<Integer>> canMoveToCoords;

	public static void setDrawings(){
		//Get the image for the piece and print exception if there is one
		try{
			//Get the black image
			imgBlack = ImageIO.read(new File("ChessPieceImages\\bishopBlack.png"));
			//Get the white image
			imgWhite = ImageIO.read(new File("ChessPieceImages\\bishopWhite.png"));
		}catch(IOException ex){ ex.printStackTrace(); }
	}

	public bishop(int xStartPosition, int yStartPosition, String pieceColor, int moveForward){
		super(xStartPosition, yStartPosition);
		this.pieceColor = pieceColor;
		this.moveForward = moveForward;
	}

	public void paintPiece(Graphics g, JPanel panel){
		//Paint the image at x, y
		if(pieceColor.equals("white")){
			g.drawImage(imgWhite, (this.xPosition-7), (this.yPosition-6), panel);
		}else if(pieceColor.equals("black")){
			g.drawImage(imgBlack, (this.xPosition-7), (this.yPosition-6), panel);
		}
	}

	public List<List<Integer>> movablePositions(){
		canMoveToCoords = new ArrayList<List<Integer>>();
		canMoveToCoords.add(new ArrayList<Integer>());
		canMoveToCoords.get(0).add(xPosition);
		canMoveToCoords.get(0).add((yPosition + moveForward));
		return canMoveToCoords;
	}

}

class knight extends piece{

	private static BufferedImage imgWhite;
	private static BufferedImage imgBlack;
	private String pieceColor;
	private int moveForward;
	private List<List<Integer>> canMoveToCoords;

	public static void setDrawings(){
		//Get the image for the piece and print exception if there is one
		try{
			//Get the black image
			imgBlack = ImageIO.read(new File("ChessPieceImages\\knightBlack.png"));
			//Get the white image
			imgWhite = ImageIO.read(new File("ChessPieceImages\\knightWhite.png"));
		}catch(IOException ex){ ex.printStackTrace(); }
	}

	public knight(int xStartPosition, int yStartPosition, String pieceColor, int moveForward){
		super(xStartPosition, yStartPosition);
		this.pieceColor = pieceColor;
		this.moveForward = moveForward;
	}

	public void paintPiece(Graphics g, JPanel panel){
		//Paint the image at x, y
		if(pieceColor.equals("white")){
			g.drawImage(imgWhite, (this.xPosition-7), (this.yPosition-6), panel);
		}else if(pieceColor.equals("black")){
			g.drawImage(imgBlack, (this.xPosition-7), (this.yPosition-6), panel);
		}
	}

	public List<List<Integer>> movablePositions(){
		canMoveToCoords = new ArrayList<List<Integer>>();
		canMoveToCoords.add(new ArrayList<Integer>());
		canMoveToCoords.get(0).add(xPosition);
		canMoveToCoords.get(0).add((yPosition + moveForward));
		return canMoveToCoords;
	}

}

class castle extends piece{

	private static BufferedImage imgWhite;
	private static BufferedImage imgBlack;
	private String pieceColor;
	private int moveForward;
	private List<List<Integer>> canMoveToCoords;

	public static void setDrawings(){
		//Get the image for the piece and print exception if there is one
		try{
			//Get the black image
			imgBlack = ImageIO.read(new File("ChessPieceImages\\castleBlack.png"));
			//Get the white image
			imgWhite = ImageIO.read(new File("ChessPieceImages\\castleWhite.png"));
		}catch(IOException ex){ ex.printStackTrace(); }
	}

	public castle(int xStartPosition, int yStartPosition, String pieceColor, int moveForward){
		super(xStartPosition, yStartPosition);
		this.pieceColor = pieceColor;
		this.moveForward = moveForward;
	}

	public void paintPiece(Graphics g, JPanel panel){
		//Paint the image at x, y
		if(pieceColor.equals("white")){
			g.drawImage(imgWhite, (this.xPosition-7), (this.yPosition-6), panel);
		}else if(pieceColor.equals("black")){
			g.drawImage(imgBlack, (this.xPosition-7), (this.yPosition-6), panel);
		}
	}

	public List<List<Integer>> movablePositions(){
		canMoveToCoords = new ArrayList<List<Integer>>();
		canMoveToCoords.add(new ArrayList<Integer>());
		canMoveToCoords.get(0).add(xPosition);
		canMoveToCoords.get(0).add((yPosition + moveForward));
		return canMoveToCoords;
	}

}