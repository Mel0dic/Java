package Game;

import GUI.ChessBoardGUI;
import GUI.ChessGame;
import Pieces.*;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

import static Game.Type.PAWN;

public class Board{

    public Type[][] board = new Type[8][8];
    private Player whitePlayer;
    private Player blackPlayer;
    private ChessGame game;
    private byte spaceSize;
    public Player turn;
    public Player opponent;
    private int[] clickedCoordinates;
    private boolean squareToHighlight = false;

    /**
     * Board Constructor class
     * @param spaceSize size of each square in the grid
     */
    public Board(byte spaceSize, ChessGame game){
        Pawn.loadPictures();

        this.game = game;

        whitePlayer = new Player("white", this, spaceSize);
        blackPlayer = new Player("black", this, spaceSize);

        turn = whitePlayer;
        opponent = blackPlayer;

        this.spaceSize = spaceSize;

        printBoard();
    }

    /**
     * Temp function to print board
     * TODO Remove function
     */
    public void printBoard(){
        for(Type[] sec : board){
            for(Type i : sec){
                if(i == PAWN) {
                    System.out.printf("*");
                }else{
                    System.out.printf("-");
                }
            }
            System.out.println("");
        }
    }

    /**
     * Function to take the co-ordinates of the click and highlight if
     * first clicked or move if second click and valid move
     * @param clickedX x co-ordinate of the mouse click
     * @param clickedY y co-ordinate of the mouse click
     */
    public void clickedSquare(int clickedX, int clickedY){
        //If a space has been highlighted already
        if(squareToHighlight){
            int[] tempCo = simplifyCoordinates(clickedX, clickedY);
            //If the same spot was clicked set space to highlight to false and return
            if(tempCo[0] == clickedCoordinates[0] && tempCo[1] == clickedCoordinates[1]) {
                squareToHighlight = false;
                return;
            }
            //If the move is valid so move the piece repaint the frame then switch turns and one of own pieces is in the square
            if(turn.pieceInSquare(clickedCoordinates[0], clickedCoordinates[1]).isValidMove((byte)tempCo[0], (byte)tempCo[1]) && !turn.isPlayerInSquare((byte) tempCo[0], (byte) tempCo[1])){
                //If opponents piece is in the space take it
                if(opponent.pieceInSquare(tempCo[0], tempCo[1]) != null){
                    opponent.pieceBeenTaken(opponent.pieceInSquare(tempCo[0], tempCo[1]));
                }
                //Move the piece
                turn.pieceInSquare(clickedCoordinates[0], clickedCoordinates[1]).movePiece(tempCo[0], tempCo[1]);
                //Un-select the square and repaint the frame then switch turns and return
                squareToHighlight = false;
                game.frame.repaint();
                switchTurns();
                return;
            }
        }
        //Set clicked co-ordinates x and y from 1-8
        clickedCoordinates = simplifyCoordinates(clickedX, clickedY);
        //If there is a player in the square highlight it
        if(turn.isPlayerInSquare((byte)clickedCoordinates[0], (byte)clickedCoordinates[1])){
            squareToHighlight = true;
        }else{
            squareToHighlight = false;
        }
    }

    public void switchTurns(){
        if(turn.colour == "black"){
            turn = whitePlayer;
            opponent = blackPlayer;
        }else if(turn.colour == "white"){
            turn = blackPlayer;
            opponent = whitePlayer;
        }
    }

    /**
     * Function to simplify the co-ordinates into co-ordinates for an 8x8 grid
     * @param clickedX x co-ordinate of click
     * @param clickedY y co-ordinate of click
     * @return array of 2 values, x and y between 0 and 7
     */
    public int[] simplifyCoordinates(int clickedX, int clickedY){
        //Initialise with a new array of size 2
        int[] tempCoords = new int[2];
        //Loop 0-7
        for(int i = 0; i < 8; i++){
            //If the x is greater than or equal to i * spaceSize and less that (i + 1) * spaceSize set 0 in array to i
            if(clickedX >= (i * spaceSize) && clickedX < ((i+1) * spaceSize)){
                tempCoords[0] = i;
            }
            //If the y is greater than or equal to i * spaceSize and less that (i + 1) * spaceSize set 1 in array to i
            if(clickedY >= (i * spaceSize) && clickedY < ((i + 1) * spaceSize)){
                tempCoords[1] = i;
            }
        }
        return tempCoords;
    }

    /**
     * Paint white and black pieces and Highlight spots if any
     * @param g Graphics object that will be painted on
     * @param panel The JPanel being painted on
     */
    public void paint(Graphics g, JPanel panel){
        whitePlayer.paint(g, panel);
        blackPlayer.paint(g, panel);

        if(squareToHighlight){
            g.setColor(Color.RED);
            g.drawRect((clickedCoordinates[0] * spaceSize), (clickedCoordinates[1] * spaceSize), spaceSize, spaceSize);
        }
    }

}