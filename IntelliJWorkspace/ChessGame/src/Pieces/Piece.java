package Pieces;

import Game.*;

import javax.swing.JPanel;
import java.awt.Graphics;

public abstract class Piece{

    public byte x;
    public byte y;
    public Player player;

    /**
     * Constructor function of piece
     * @param startX the starting X position
     * @param startY the starting Y position
     */
    public Piece(int startX, int startY, Player player){
        x = (byte) startX;
        y = (byte) startY;
        this.player = player;
    }

    /**
     * A function for painting the pieces picture
     * @param g the graphics from the JPanel's paint function
     * @param panel is the JPanel that will be painted to
     */
    public abstract void paintPiece(Graphics g, JPanel panel);

}