package com.bgrummitt.pieces;

import com.bgrummitt.game.Player;
import com.bgrummitt.game.Type;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Knight extends Piece{

	private static final byte offsetX = -7;
	private static final byte offsetY = -6;
	private static BufferedImage whiteImg;
	private static BufferedImage blackImg;
	private Type type;

	public Knight(int startX, int startY, int spaceSize, Player player, int arrayPosition, Type[][] mainBoard, Type[][] singlePlayerBoard){
		super(startX, startY, spaceSize, player, arrayPosition);

		type = Type.KNIGHT;

		mainBoard[this.y][this.x] = type;
		singlePlayerBoard[this.y][this.x] = type;
	}

	public static void loadPictures(){
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		try{
			//Get the black image
			blackImg = ImageIO.read(classloader.getResourceAsStream("knightBlack.png"));
			//Get the white image
			whiteImg = ImageIO.read(classloader.getResourceAsStream("knightWhite.png"));
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
		//Set the piece on the board of friendly pieces
		player.onePlayerBoard[y][x] = null;
		player.onePlayerBoard[newY][newX] = type;
		//Set the piece on the whole board
		player.board.board[y][x] = null;
		player.board.board[newY][newX] = type;
		//Set the x and y of piece
		x = (byte) newX;
		y = (byte) newY;
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
		if(Math.abs(x - newX) == 2 && Math.abs(y - newY) == 1){
			return true;
		}else if(Math.abs(x - newX) == 1 && Math.abs(y - newY) == 2){
			return true;
		}
		return false;
	}

	/**
	 * Function to check if piece can get to end spot without
	 * any friendly or opposition pieces in the way
	 *
	 * @param newX  x position piece is moving to
	 * @param newY  y position piece is moving to
	 * @param board
	 * @return true or false based on if path is valid
	 */
	public boolean isValidPath(byte newX, byte newY, Type[][] board) {
		//The horse can jump over friendly or enemy pieces so the path doesn't matter
		return true;
	}
}
