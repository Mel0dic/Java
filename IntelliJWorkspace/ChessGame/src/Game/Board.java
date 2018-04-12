package Game;

import Pieces.*;

public class Board{

    public Type[][] board = new Type[8][8];
    private Player whitePlayer;
    private Player blackPlayer;

    /**
     * Board Constructor class
     * @param
     * @param
     */
    public Board(){
        whitePlayer = new Player("white", this);
        blackPlayer = new Player("black", this);

        printBoard();
    }

    /**
     * Temp function to print board
     * TODO Remove function
     */
    public void printBoard(){
        for(Type[] sec : board){
            for(Type i : sec){
                System.out.println(i);
            }
            System.out.println("\n");
        }
    }

}