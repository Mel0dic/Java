package com.bgrummitt.gui;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class ChessBoardGUI extends JPanel{

    private byte spaceSize;
    private ChessGame game;

    /**
     * chessBoardGUI constructor
     * @param spaceSize size of each square on the chess board
     **/
    public ChessBoardGUI(byte spaceSize, ChessGame game){
        this.spaceSize = spaceSize;
        this.game = game;
    }


    /**
     * Overide the graphics function and paint the chess board
     * @param g pass the panels graphics
     **/
    @Override
    public void paintComponent(Graphics g){
        //Super the paintComponent method
        super.paintComponent(g);
        //Print the board
        paintBoard((Graphics2D) g);
        //
        game.paint(g);
    }

    /**
     * Function the paints the squares on the board
     * @param g2 pass the 2D graphics
     */
    public void paintBoard(Graphics2D g2){
        //For row in board
        for(int i = 0; i < 8; i++){
            //For column in row
            for(int j = 0; j < 8; j++){
                //If j is an even number and i is an even number
                if(j % 2 == 0 && i % 2 == 0){
                    //Set color to black and fill a square at that position
                    g2.setColor(Color.ORANGE);
                    g2.fillRect((j * spaceSize), (i * spaceSize), spaceSize, spaceSize);
                }
                //Else if j is not even (odd) and i is odd
                else if(j % 2 != 0 && i % 2 != 0){
                    g2.setColor(Color.ORANGE);
                    g2.fillRect((j * spaceSize), (i * spaceSize), spaceSize, spaceSize);
                }
            }
        }
    }

}