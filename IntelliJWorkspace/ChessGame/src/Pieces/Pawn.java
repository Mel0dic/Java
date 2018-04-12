package Pieces;

import Game.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Pawn extends Piece{

    private static final byte offsetX = -7;
    private static final byte offsetY = -6;
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
            blackImg = ImageIO.read(new File("..\\GUI\\pawnBlack.png"));
            //Get the white image
            whiteImg = ImageIO.read(new File("ChessPieceImages\\pawnWhite.png"));
            //If there was an IOException print it out
        }catch(IOException e){ System.out.println(e); }
    }

    /**
     * A function for painting the pieces picture
     * @param g the graphics from the JPanel's paint function
     * @param panel is the JPanel that will be painted to
     */
    public void paintPiece(Graphics g, JPanel panel){
        //If the player is black draw the black image
        if(player.colour.equals("black")){
            g.drawImage(blackImg, (x + offsetX), (y + offsetY), panel);
        }
        //Else if the player is white draw the white image
        else if(player.colour.equals("white")){
            g.drawImage(whiteImg, (x + offsetX), (y + offsetY), panel);
        }
    }

}