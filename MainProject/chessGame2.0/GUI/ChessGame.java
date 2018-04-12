package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Dimension;

public class ChessGame{

	public JFrame frame;
	public chessBoardGUI panel;
	public byte spaceSize;

	/**
	 * Main Function
	 */
	public static void main(String[] args){
		new ChessGame((byte)25);
	}

	/**
	 * ChessGame constructor function
	 * @param spaceSize the size of each square on the chessBoard
	 */
	public ChessGame(byte spaceSize){
		this.spaceSize = spaceSize;
		//
		panel = new chessBoardGUI(spaceSize);
		//
		makeJFrame(panel);
	}

	/**
	 * Function make the JFrame
	 * @param GUIpanel JPanel class
	 */
	public void makeJFrame(JPanel GUIpanel){
		//set frame to new JFrame object setting title in process
		frame = new JFrame("Test BG");
		//set program to exit on close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//set the prefered size to be height and width of level loaded
		GUIpanel.setPreferredSize(new Dimension((8 * spaceSize) , (8 * spaceSize)));

		//add draw panel to jframe
		frame.getContentPane().add(GUIpanel);

		//pack everything so JFrame fits jpanel
		frame.pack();

		//set visible
		frame.setVisible(true);
		//set resizable to false
		frame.setResizable(false);
		//set location of JFrame
		frame.setLocation(375, 55);
		//call repaint on frame
		frame.repaint();

		GUIpanel.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
			}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
		});
	}

}