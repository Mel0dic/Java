import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class levelFrame{

	private JFrame frame;
	private DrawPanel drawPanel;
	private List<List<Character>> levelList;
	private int windowWidth;
	private int windowHeight;
	private int blockSize = 10;

	public static void main(String[] args){
		new levelFrame();
	}

	public levelFrame(){
		loadFileToLevel mainClass = new loadFileToLevel();
		levelList = mainClass.getArrayOfArray();
		windowWidth = (levelList.get(0).size() * blockSize);
		windowHeight = (levelList.size() * blockSize);
		makeJFrame();
	}

	public void makeJFrame(){
		frame = new JFrame("Test BG");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		drawPanel = new DrawPanel();
		drawPanel.setPreferredSize(new Dimension(windowWidth , windowHeight));

		frame.getContentPane().add(drawPanel);

		frame.pack();

		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocation(375, 55);

	}

	class DrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			paintLevel(g);
		}
	}

	public void paintLevel(Graphics g){
		int xPos = 0;
		int yPos = 0;
		for(List<Character> nextArray : levelList){
			for(Character c : nextArray){
				switch(c){
					case '*':	g.setColor(Color.black);
								g.fillRect(xPos, yPos, blockSize, blockSize);
								break;
					case 'X':	g.setColor(Color.red);
								g.fillRect(xPos, yPos, blockSize, blockSize);
								break;
				}
				xPos += blockSize;
			}
			xPos = 0;
			yPos += blockSize;
		}
	}

}