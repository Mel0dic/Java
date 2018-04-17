package Pieces;

import Game.*;

import javax.swing.JPanel;
import java.awt.Graphics;

public abstract class Piece{

    public byte x;
    public byte y;
    public Player player;
    public int spaceSize;
    public boolean onBoard = true;
    public byte arrayPosition;

    /**
     * Constructor function of piece
     * @param startX starting x position
     * @param startY starting y position
     * @param spaceSize size of each square on the board
     * @param player player who owns the piece
     * @param arrayPosition position in array of pieces
     */
    public Piece(int startX, int startY, int spaceSize, Player player, int arrayPosition){
        x = (byte) startX;
        y = (byte) startY;
        this.player = player;
        this.spaceSize = spaceSize;
        this.arrayPosition = (byte) arrayPosition;
    }

    /**
     * Function to move piece
     * @param x new x co-ordinate
     * @param y new y co-ordinate
     */
    public abstract void movePiece(int x, int y);

    /**
     * A function for painting the pieces picture
     * @param g the graphics from the JPanel's paint function
     * @param panel is the JPanel that will be painted to
     */
    public abstract void paintPiece(Graphics g, JPanel panel);

    /**
     * Function to check if move is valid
     */
    public abstract boolean isValidMove(byte newX, byte newY);

    /**
     * Remove piece from the game
     */
    public void takePiece(){
        onBoard = false;
        player.onePlayerBoard[y][x] = null;
    }

    /**
     * Update the position of array
     * @param newPos new position
     */
    public void updateArrayPosition(int newPos){
        arrayPosition = (byte) newPos;
    }

    /**
     * Function to check if piece can get to end spot without
     * any friendly or opposition pieces in the way
     * @param newX x position piece is moving to
     * @param newY y position piece is moving to
     * @param board
     * @return true or false based on if path is valid
     */
    public abstract boolean isValidPath(byte newX, byte newY, Type[][] board);

}