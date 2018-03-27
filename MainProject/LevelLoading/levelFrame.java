import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

public class levelFrame{

	private JFrame frame;
	private DrawPanel drawPanel;
	private List<List<Character>> levelList;
	private int windowWidth;
	private int windowHeight;

	public static void main(String[] args){
		new levelFrame();
	}

	public levelFrame(){
		loadFileToLevel mainClass = new loadFileToLevel();
		levelList = mainClass.getArrayOfArray();
		windowWidth = (levelList.get(0).size() * 10);
		windowHeight = (levelList.size() * 10);
		System.out.println(levelList.size());
		System.out.println(levelList.get(0).size());
		System.out.println(windowHeight);
		System.out.println(windowWidth);
		makeJFrame();
	}

	public void makeJFrame(){
		frame = new JFrame("Test BG");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		drawPanel = new DrawPanel();

		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

		frame.pack();

		frame.setSize(windowWidth+10, windowHeight+10);
		frame.setVisible(true);
		frame.setResizable(true);
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
				if(c == '*'){
					g.fillRect(xPos, yPos, 10, 10);
					// System.out.println(String.format("xPos = %d yPos = %d", xPos, yPos));
				}
				xPos += 10;
			}
			System.out.println(xPos);
			xPos = 0;
			yPos += 10;
		}
		System.out.println(yPos);
	}

}