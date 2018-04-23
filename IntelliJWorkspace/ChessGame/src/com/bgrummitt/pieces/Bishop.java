package com.bgrummitt.pieces;

import com.bgrummitt.game.Player;
import com.bgrummitt.game.Type;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bishop extends Piece{

	private static final byte offsetX = -7;
	private static final byte offsetY = -6;
	private static BufferedImage whiteImg;
	private static BufferedImage blackImg;
	private Type type;

	public Bishop(int startX, int startY, int spaceSize, Player player, int arrayPosition){
		super(startX, startY, spaceSize, player, arrayPosition);

		type = Type.CASTLE;
	}

	/**
	 *Function to load the pictures in a static method and var
	 */
	public static void loadPictures(){
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		try{
			//Get the black image
			blackImg = ImageIO.read(classloader.getResourceAsStream("bishopBlack.png"));
			//Get the white image
			whiteImg = ImageIO.read(classloader.getResourceAsStream("bishopWhite.png"));
			//If there was an IOException print it out
		}catch(IOException e){ System.out.println(e); }
	}

	/**
	 * Function to move piece
	 *
	 * @param newX new x co-ordinate
	 * @param newY new y co-ordinate
	 */
	public void movePiece(int newX, int newY) {
		super.movePiece(newX, newY);
		//Set the piece on the board of friendly pieces
		player.onePlayerBoard[y][x] = null;
		player.onePlayerBoard[newY][newX] = type;
		//Set the piece on the whole board
		player.board.board[y][x] = null;
		player.board.board[newY][newX] = type;
	}

	/**
	 * A function for painting the pieces picture
	 *
	 * @param g     the graphics from the JPanel's paint function
	 * @param panel is the JPanel that will be painted to
	 */
	public void paintPiece(Graphics g, JPanel panel) {
		//If the player is black draw the black image
		if(player.colour.equals("black")){
			g.drawImage(blackImg, ((x * spaceSize) + offsetX), ((y * spaceSize) + offsetY), panel);
		}
		//Else if the player is white draw the white image
		else if(player.colour.equals("white")){
			g.drawImage(whiteImg, ((x * spaceSize) + offsetX), ((y * spaceSize) + offsetY), panel);
		}
	}

	/**
	 * Function to check if move is valid
	 *
	 * @param newX
	 * @param newY
	 */
	public boolean isValidMove(byte newX, byte newY) {
		return (Math.abs(newX - x) == Math.abs(newY - y));
	}

	/**
	 * Function to check if piece can get to end spot without
	 * any friendly or opposition pieces in the way
	 *
	 * @param newX  x position piece is moving to
	 * @param newY  y position piece is moving to
	 * @param board the board with positions of all pieces on the board
	 * @return true or false based on if path is valid
	 */
	public boolean isValidPath(byte newX, byte newY, Type[][] board) {
		byte xMove;
		byte yMove;
		//Set the direction of the x movement
		if(newX - x < 0) xMove = -1;
		else xMove = 1;
		//Set the direction of the y movement
		if(newY - y < 0) yMove = -1;
		else yMove = 1;
		//Set the temp co-ordinates
		byte tempX = (byte) (x + xMove);
		byte tempY = (byte) (y + yMove);
		//While the temp co-ordinates are not equal to the new co-ordinates
		while(tempX != newX && tempY != newY){
			//If there is is a player in the space return false
			if(board[tempY][tempX] != null) return false;
			//Update the position
			tempX += xMove;
			tempY += yMove;
		}
		return true;
	}
}
