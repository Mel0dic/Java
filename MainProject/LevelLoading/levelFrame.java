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
		windowWidth = (levelList.get(0).size() * 25);
		windowHeight = (levelList.size() * 25);
		makeJFrame();
	}

	public void makeJFrame(){
		frame = new JFrame("Test BG");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		drawPanel = new DrawPanel();

		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

		frame.pack();

		frame.setSize(windowWidth, windowHeight);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocation(375, 55);
	}

	class DrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			g.fillRect(0, 0, 25, 25);
		}
	}

}