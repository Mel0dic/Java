package Pieces;

import Game.*;

import javax.swing.JPanel;
import java.awt.Graphics;

public abstract class Piece{

    public byte x;
    public byte y;
    public Player player;
    public int spaceSize;

    /**
     * Constructor function of piece
     * @param startX the starting X position
     * @param startY the starting Y position
     */
    public Piece(int startX, int startY, int spaceSize, Player player){
        x = (byte) startX;
        y = (byte) startY;
        this.player = player;
        this.spaceSize = spaceSize;
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

}