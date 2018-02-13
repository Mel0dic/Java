package hangMan;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUIGraphics extends JPanel{
	
	public static void main(String[] args) {
		GUIGraphics gui = new GUIGraphics();
		
		JFrame jf = new JFrame();
		
		jf.setTitle("Test");
		jf.setSize(600, 400);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jf.add(gui);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawRect(0, 10, 40, 30);
		g.fillRect(50, 100, 30, 40);
	}
	
}
