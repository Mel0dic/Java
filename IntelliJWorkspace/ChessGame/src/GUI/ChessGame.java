package GUI;

import Game.Board;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class ChessGame{

    public JFrame frame;
    public ChessBoardGUI panel;
    public byte spaceSize;
    private Board board;

    /**
     * Main Function
     */
    public static void main(String[] args){
        new ChessGame((byte)50);
    }

    /**
     * ChessGame constructor function
     * @param spaceSize the size of each square on the chessBoard
     */
    public ChessGame(byte spaceSize){
        this.spaceSize = spaceSize;
        //Make new ChessBoardGUI
        panel = new ChessBoardGUI(spaceSize, this);
        //Initialise board with a new board object
        board = new Board(spaceSize);
        //Make the JPanel
        makeJFrame(panel);
    }

    /**
     * Function make the JFrame
     * @param panelGUI JPanel class
     */
    public void makeJFrame(final JPanel panelGUI){
        //set frame to new JFrame object setting title in process
        frame = new JFrame("Test BG");
        //set program to exit on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set the preferred size to be height and width of level loaded
        panelGUI.setPreferredSize(new Dimension((8 * spaceSize) , (8 * spaceSize)));

        //add draw panel to JFrame
        frame.getContentPane().add(panelGUI);

        //pack everything so JFrame fits JPanel
        frame.pack();

        //set visible
        frame.setVisible(true);
        //set resizable to false
        frame.setResizable(false);
        //set location of JFrame
        frame.setLocation(375, 55);
        //call repaint on frame
        frame.repaint();

        panelGUI.addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                board.clickedSquare(x ,y);
                frame.repaint();
            }
            public void mouseClicked(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
        });
    }

    /**
     * Paint the pieces
     * @param g
     */
    public void paint(Graphics g){
        board.paint(g, panel);
    }

}