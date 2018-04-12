package Piece;

import Game.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Pawn extends piece{

	private static BufferedImage whiteImg;
	private static BufferedImage blackImg;
	public Type type;

	/**
	 * Pawn constructor function
	 * @param startX the starting X co-ordinate of the piece
	 * @param startY the starting Y co-ordinate of the piece
	 * @param player the player who owns the piece
	 */
	public Pawn(int startX, int startY, Player player){
		super(startX, startY, player);
		type = Type.PAWN;
	}

	/**
	 *Function to load the pictures in a static method and var
	 */
	public static void loadPictures(){
		try{
			//Get the black image
			imgBlack = ImageIO.read(new File("..\\GUI\\pawnBlack.png"));
			//Get the white image
			imgWhite = ImageIO.read(new File("ChessPieceImages\\pawnWhite.png"));
		//If there was an IOException print it out
		}catch(IOException e){ System.out.println(e); }
	}

	/**
	 * A function for painting the pieces picture
	 * @param g the graphics from the JPanel's paint function
	 * @param panel is the JPanel that will be painted to
	 */
	public abstract void paintPiece(Graphics g, JPanel panel){
		//If the player is black draw the black image
		if(player.color.equals("black")){
			g.drawImage(blackImg, (xPosition + offsetX), (yPosition + offsetY), panel);
		}
		//Else if the player is white draw the white image
		else if(player.color.equals("white")){
			g.drawImage(whiteImg, (xPosition + offsetX), (yPosition + offsetY), panel);
		}
	}

}