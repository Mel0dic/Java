import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.List;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class main{

	private JFrame frame;
	private DrawPanel drawPanel;
	private chessBoard board;
	private boolean isRunning = true;
	private int spaceSize = 50;
	private pieces blackTeam;
	private pieces whiteTeam;
	private int turn = 0;

	public static void main(String[] args){
		new main();
	}

	public main(){
		blackTeam = new pieces("black", spaceSize);
		whiteTeam = new pieces("white", spaceSize);
		pawn.setDrawings();
		castle.setDrawings();
		bishop.setDrawings();
		queen.setDrawings();
		king.setDrawings();
		knight.setDrawings();
		//Make and paint the board
		board = new chessBoard(spaceSize);
		//Make the jframe
		makeJFrame();
		//Call start game function
		startGame();
	}

	public void startGame(){
		//Create infinite loop
		while(isRunning){
			try{
				Thread.sleep(5);
			}catch(Exception e){
				System.out.println(e);
			}
			frame.repaint();
		}
	}

	public void makeJFrame(){
		//set frame to new JFrame object setting title in process
		frame = new JFrame("Test BG");
		//set program to exit on close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//set drawpanel to new drawPanel object
		drawPanel = new DrawPanel();
		//set the prefered size to be height and width of level loaded
		drawPanel.setPreferredSize(new Dimension((8 * spaceSize) , (8 * spaceSize)));

		//add draw panel to jframe
		frame.getContentPane().add(drawPanel);

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

		drawPanel.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				board.getBox(x, y);
				checkPosition();
			}
			public void mouseClicked(MouseEvent e){}
			public void mouseEntered(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
		});
	}

	public void checkPosition(){
		List<List<Integer>> canMoveTo;
		List<List<Integer>> tempCanMoveTo;
		if(turn == 0){
			canMoveTo = whiteTeam.getPieceInSquare(board.gethightlightedBoxXPosition(), board.gethightlightedBoxYPosition());
			if(canMoveTo != null){
				board.setPieceInSpace(true);
				tempCanMoveTo = canMoveTo;
				for(int i = 0; i < canMoveTo.size(); i++){
					if(whiteTeam.isPieceInSquare(canMoveTo.get(i).get(0), canMoveTo.get(i).get(1))){
						tempCanMoveTo.remove(i);
					}
				}
				board.setCanMoveTo(tempCanMoveTo);
			}else{
				board.setPieceInSpace(false);
			}
		}else if(turn == 1){
			canMoveTo = blackTeam.getPieceInSquare(board.gethightlightedBoxXPosition(), board.gethightlightedBoxYPosition());
			if(canMoveTo != null){
				board.setPieceInSpace(true);
				board.setCanMoveTo(canMoveTo);
			}else{
				board.setPieceInSpace(false);
			}
		}
	}

	class DrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			//Super the paintComponent method
			super.paintComponent(g);
			//Cast the graphics object into a 2D graphics object
			Graphics2D g2 = (Graphics2D) g;
			//Draw the squares
			board.drawBoard(g2);
			//Draw pieces
			blackTeam.paintTeam(g, this);
			whiteTeam.paintTeam(g, this);
		}
	}

}