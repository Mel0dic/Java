package Pieces;

import Game.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Pawn extends Piece{

    private static final byte offsetX = -7;
    private static final byte offsetY = -6;
    private static BufferedImage whiteImg;
    private static BufferedImage blackImg;
    private int movesMade;
    private byte moveForward;
    public Type type;

    /**
     * Pawn constructor function
     * @param startX the starting X co-ordinate of the piece
     * @param startY the starting Y co-ordinate of the piece
     * @param player the player who owns the piece
     */
    public Pawn(int startX, int startY, int spaceSize, Player player, int arrayPos){
        super(startX, startY, spaceSize, player, arrayPos);
        if(startY == 1){
            moveForward = 1;
        }else if(startY == 6){
            moveForward = -1;
        }
        type = Type.PAWN;
    }

    /**
     *Function to load the pictures in a static method and var
     */
    public static void loadPictures(){
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try{
            //Get the black image
            blackImg = ImageIO.read(classloader.getResourceAsStream("pawnBlack.png"));
            //Get the white image
            whiteImg = ImageIO.read(classloader.getResourceAsStream("pawnWhite.png"));
            //If there was an IOException print it out
        }catch(IOException e){ System.out.println(e); }
    }

    /**
     * Move piece on all boards
     * @param newX new x position of piece
     * @param newY new y position of piece
     */
    public void movePiece(int newX, int newY){
        movesMade++;
        player.onePlayerBoard[y][x] = null;
        player.onePlayerBoard[newY][newX] = type;
        player.board.board[y][x] = null;
        player.board.board[newY][newX] = type;
        x = (byte) newX;
        y = (byte) newY;
    }

    /**
     * A function for painting the pieces picture
     * @param g the graphics from the JPanel's paint function
     * @param panel is the JPanel that will be painted to
     */
    public void paintPiece(Graphics g, JPanel panel){
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
     * Function that checks if the move is valid
     * @param newX X position being moved to
     * @param newY Y position being moved to
     */
    public boolean isValidMove(byte newX, byte newY){
        //If the move is 2 spaces forward only allow it if it is the first move
        if((y - newY) == (-2 * moveForward) && newX == x && movesMade == 0){
            return true;
        }
        //If the move is 1 space forward and nothing is in that space allow it
        else if((y - newY) == -moveForward && x == newX && player.board.board[newY][newX] == null){
            return true;
        }
        //If the move is diagonal check and a player is in that space return true
        else if((y - newY) == -moveForward && Math.abs(x - newX) == 1 && player.board.board[newY][newX] != null){
            return true;
        }
        return false;
    }

    /**
     * Function to check if piece can get to end spot without
     * any friendly or opposition pieces in the way
     * @param newX x position piece is moving to
     * @param newY y position piece is moving to
     * @param board the full board where every piece is
     * @return true or false based on if path is valid
     */
    public boolean isValidPath(byte newX, byte newY, Type[][] board){
        //Pawn cannot move more than one space after first move so
        //proving validity of path is not necessary
        return true;
    }

}