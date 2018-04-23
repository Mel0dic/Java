package com.bgrummitt.pieces;

import com.bgrummitt.game.Player;
import com.bgrummitt.game.Type;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Queen extends Piece{

	private static final byte offsetX = -5;
	private static final byte offsetY = -5;
	private static BufferedImage whiteImg;
	private static BufferedImage blackImg;
	private Type type;

	public Queen(int startX, int startY, int spaceSize, Player player, int arrayPosition, Type[][] mainBoard, Type[][] singlePlayerBoard){
		super(startX, startY, spaceSize, player, arrayPosition);

		type = Type.QUEEN;

		mainBoard[this.y][this.x] = type;
		singlePlayerBoard[this.y][this.x] = type;
	}

	public static void loadPictures(){
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		try{
			//Get the black image
			blackImg = ImageIO.read(classloader.getResourceAsStream("queenBlack.png"));
			//Get the white image
			whiteImg = ImageIO.read(classloader.getResourceAsStream("queenWhite.png"));
			//If there was an IOException print it out
		}catch(IOException e){ System.out.println(e); }
	}

	/**
	 * Function to move piece
	 *
	 * @param newX new x co-ordinate
	 * @param newY new y co-ordinate
	 */
	public void movePiece(int newX, int newY){
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
	 * @param newX x position piece is moving to
	 * @param newY y position piece is moving to
	 */
	public boolean isValidMove(byte newX, byte newY){
		return (Math.abs(newX - x) == Math.abs(newY - y)) || (x == newX || y == newY);
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
	@Override
	public boolean isValidPath(byte newX, byte newY, Type[][] board){
		if((Math.abs(newX - x) == Math.abs(newY - y))){
			byte xMove;
			byte yMove;
			if(newX - x < 0) xMove = -1;
			else xMove = 1;
			if(newY - y < 0) yMove = -1;
			else yMove = 1;
			byte tempX = (byte) (x + xMove);
			byte tempY = (byte) (y + yMove);
			while(tempX != newX && tempY != newY){
				if(board[tempY][tempX] != null) return false;
				tempX += xMove;
				tempY += yMove;
			}
		}else if((x == newX || y == newY)){
			//Determine direction of movement
			int dir = 0;
			if(x > newX || y > newY){ dir = -1; }
			else if(x < newX || y < newY){ dir = 1; }

			//If the castle is being move along the X axis
			if(y == newY){
				//Set i to the current x + the movement direction
				int i = (x + dir);
				//While i is not equal to the new x position
				while(i != newX){
					//If the position has a piece in it return false
					if(board[y][i] != null){ return false; }
					i += dir;
				}
			}
			//If the castle is being move along the Y axis
			else if(x == newX){
				//Set i to the current y + the movement direction
				int i = (y + dir);
				//While i is not equal to the new y position
				while(i != newY){
					//If the position has a piece in it return false
					if(board[i][x] != null){ return false; }
					i += dir;
				}
			}
		}
		return true;
	}
}
