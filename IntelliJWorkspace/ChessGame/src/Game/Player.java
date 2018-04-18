package Game;

import Pieces.*;

import javax.swing.JPanel;
import java.awt.Graphics;

public class Player {

    public String colour;
    public Board board;
    private int spaceSize;
    private byte forward;
    private byte startX;
    public Type[][] onePlayerBoard = new Type[8][8];
    private Piece[] pieces = new Piece[10];
//    private Castle[] castles = new Castle[2];
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
        int numberInArr = 0;
        for(int i = 0; i < 8; i++){
            board.board[spawnYPos][i] = Type.PAWN;
            onePlayerBoard[spawnYPos][i] = Type.PAWN;
            pieces[numberInArr] = new Pawn(i, spawnYPos, spaceSize, this, numberInArr);
            numberInArr++;
        }
        for(int i = 0; i < 2; i++){
            board.board[spawnYPos + (-forward)][(i * 7)] = Type.CASTLE;
            onePlayerBoard[spawnYPos + (-forward)][(i * 7)] = Type.CASTLE;
            pieces[numberInArr] = new Castle((i * 7), (spawnYPos + (-forward)), spaceSize, this, numberInArr);
            numberInArr++;
        }
    }

    /**
     * Function to check if piece is in square
     * @param x position of square to check
     * @param y position of square to check
     * @return true or false depending on if piece in space
     */
    public boolean isPlayerInSquare(byte x, byte y){
        if(onePlayerBoard[y][x] != null){
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
        for(Piece i : pieces){
            i.paintPiece(g, panel);
        }
    }

    /**
     * Get piece in square
     * @param x position of square to find
     * @param y position of square to find
     * @return piece found in position else null
     */
    public Piece pieceInSquare(int x, int y){
        for(Piece i : pieces){
            if(x == i.x && y == i.y){
                return i;
            }
        }
        return null;
    }

    /**
     * Function to take piece and remove piece from array
     * @param piece piece to remove
     */
    public void pieceBeenTaken(Piece piece){
        int arrSize = pieces.length;
        Piece[] tempArr = new Piece[arrSize-1];
        int count = 0;
        for(Piece i : pieces){
            if(i != piece) {
                tempArr[count] = i;
                i.updateArrayPosition(count);
                count++;
            }else{
                i.takePiece();
            }
        }
        pieces = tempArr;
    }

}
