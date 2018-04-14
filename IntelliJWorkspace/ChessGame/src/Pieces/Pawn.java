package Pieces;

import Game.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Pawn extends Piece{

    private static final byte offsetX = -7;
    private static final byte offsetY = -6;
    private static BufferedImage whiteImg;
    private static BufferedImage blackImg;
    private int movesMade;
    public Type type;

    /**
     * Pawn constructor function
     * @param startX the starting X co-ordinate of the piece
     * @param startY the starting Y co-ordinate of the piece
     * @param player the player who owns the piece
     */
    public Pawn(int startX, int startY, int spaceSize, Player player){
        super(startX, startY, spaceSize, player);
        type = Type.PAWN;
    }

    /**
     *Function to load the pictures in a static method and var
     */
    public static void loadPictures(){
        try{
            //Get the black image
            blackImg = ImageIO.read(new File("D:\\Code\\Java\\IntelliJWorkspace\\ChessGame\\ChessResource\\pawnBlack.png"));
            //blackImg = ImageIO.read(new File("C:\\Users\\bengr\\Documents\\GitHub\\Java\\IntelliJWorkspace\\ChessGame\\ChessResource\\pawnBlack.png"));
            //Get the white image
            whiteImg = ImageIO.read(new File("D:\\Code\\Java\\IntelliJWorkspace\\ChessGame\\ChessResource\\pawnWhite.png"));
            //whiteImg = ImageIO.read(new File("C:\\Users\\bengr\\Documents\\GitHub\\Java\\IntelliJWorkspace\\ChessGame\\ChessResource\\pawnWhite.png"));
            //If there was an IOException print it out
        }catch(IOException e){ System.out.println(e); }
    }

    /**
     *
     * @param newX
     * @param newY
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
        if(movesMade == 0){
            if(Math.abs(y - newY) < 3 && newX == x){
                return true;
            }
        }else{
            if(Math.abs(y - newY) == 1 && x == newX){
                return true;
            }else if(Math.abs(y - newY) == 1 && Math.abs(x - newX) == 1){
                System.out.println("Diagonal");
                System.out.println(player.board.board[newY][newX]);
                if(player.board.board[newY][newX] != null){
                    System.out.println("True");
                    return true;
                }
            }
        }
        return false;
    }

}