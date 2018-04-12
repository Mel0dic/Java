package Pieces;
import Game.*;

public class Piece{

	private byte x;
	private byte y;

	/**
	 * Constructor function of piece
	 * @param startX the starting X position
	 * @param startY the starting Y position
	 */
	public Piece(int startX, int startY){
		x = startX;
		y = startY;
	}

	/**
	 * Function that loads the pictures for each piece.
	 */
	public static abstract void loadPictures();

	/**
	 * A function for painting the pieces picture
	 * @param g the graphics from the JPanel's paint function
	 * @param panel is the JPanel that will be painted to
	 */
	public abstract void paintPiece(Graphics g, JPanel panel);

}