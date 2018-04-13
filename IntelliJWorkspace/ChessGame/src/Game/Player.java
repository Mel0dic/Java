package Game;

import Pieces.*;

import javax.swing.JPanel;
import java.awt.Graphics;

public class Player {

    public String colour;
    private int spaceSize;
    private Board board;
    private byte forward;
    private byte startX;
    public Type[][] onePlayerBoard = new Type[8][8];
    private Pawn[] pawns = new Pawn[8];
//    private castle[] castles = new castle[2];
//    private bishop[] bishops = new bishop[2];
//    private knight[] knights = new knight[2];
//    private king theKing;
//    private queen theQueen;

    /**
     * Player constructor function
     * @param colour color or side of player
     * @param board board class to access the board
     */
    public Player(String colour, Board board, int spaceSize){
        this.colour = colour;
        this.spaceSize = spaceSize;
        if(colour.equals("black")){
            forward = 1;
            startX = 0;
        }else if(colour.equals("white")){
            forward = -1;
            startX = 7;
        }
        this.board = board;
        initialisePieces();
    }

    /**
     * Function to initialise the pieces on the board
     */
    public void initialisePieces(){
        byte spawnYPos = (byte)(startX + forward);
        for(int i = 0; i < 8; i++){
            board.board[i][spawnYPos] = Type.PAWN;
            onePlayerBoard[i][spawnYPos] = Type.PAWN;
            pawns[i] = new Pawn(i, spawnYPos, spaceSize, this);
        }
    }

    /**
     * Function to check if piece is in square
     * @param x position of square to check
     * @param y position of square to check
     * @return true or false depending on if piece in space
     */
    public boolean isPlayerInSquare(byte x, byte y){
        if(onePlayerBoard[x][y] != null){
            return true;
        }
        return false;
    }

    /**
     * Function to paint each piece on the board
     * @param g Graphics object that will be painted on
     * @param panel The JPanel being painted on
     */
    public void paint(Graphics g, JPanel panel){
        for(Pawn i : pawns){
            i.paintPiece(g, panel);
        }
    }

}
