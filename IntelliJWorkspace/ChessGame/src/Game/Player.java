package Game;

import Pieces.*;

import java.sql.SQLOutput;

public class Player {

    public String colour;
    private Board board;
    private byte forward;
    private byte startX;
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
    public Player(String colour, Board board){
        this.colour = colour;
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
        int spawnYpos = startX + forward;
        for(int i = 0; i < 8; i++){
            board.board[spawnYpos][i] = Type.PAWN;
            pawns[i] = new Pawn(i, spawnYpos, this);
        }
    }
}
