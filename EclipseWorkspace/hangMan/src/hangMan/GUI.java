package hangMan;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GUI extends JPanel{
	
	JFrame jf;
	private static int count = 0;
	
	public GUI() {
		jf = new JFrame();
		jf.setTitle("Test");
		jf.setSize(600, 400);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jf.getContentPane().add(this);
	}
	
	public static void main(String[] args) {
		GUI gui = new GUI();
		//count++;
		//gui.repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setStroke(new BasicStroke(10));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.drawLine(420, 50, 420, 300);
		g2.drawLine(420, 50, 545, 50);
		g2.drawLine(400, 300, 570, 300);
		g2.setStroke(new BasicStroke(7));
		g2.drawLine(420, 240, 500, 300);
		g2.fillOval(470, 100, 30, 30);
		g2.drawLine(485, 110, 485, 175);
		g2.drawLine(485, 175, 490, 185);
		g2.drawLine(485, 175, 480, 185);
		g2.drawLine(470, 140, 500, 140);
		g2.setStroke(new BasicStroke(3));
		g2.drawLine(485, 50, 485, 175);
	}
	
}
