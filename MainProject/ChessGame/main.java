import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.PointerInfo;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.Color;

public class main{

	private JFrame frame;
	private DrawPanel drawPanel;
	private boolean isRunning = true;
	private int spaceSize = 50;

	public static void main(String[] args){
		new main();
	}

	public main(){
		//Make the jframe
		makeJFrame();
		//Call start game function
		startGame();
	}

	public void startGame(){
		//Create infinite loop
		while(isRunning){
			System.out.println(Color.black);
			try{
				Thread.sleep(5);
			}catch(Exception e){
				System.out.println(e);
			}
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
	}

	class DrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			//Super the paintComponent method
			super.paintComponent(g);
			//Draw the squares
			drawBoard(g);
		}
	}

	public void drawBoard(Graphics g){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(j % 2 == 0 && i % 2 == 0){
					g.setColor(Color.black);
					g.fillRect((j * spaceSize), (i * spaceSize), spaceSize, spaceSize);
				}else if(j % 2 != 0 && i % 2 != 0){
					g.setColor(Color.black);
					g.fillRect((j * spaceSize), (i * spaceSize), spaceSize, spaceSize);
				}
			}
		}
	}

}