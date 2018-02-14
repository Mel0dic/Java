import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Testing extends JFrame{

	private JPanel p;

	public static void main(String[] args) {
		Testing t = new Testing();
		t.paintPanel();
	}
	
	public Testing() {
		p = new JPanel();
		p.setBackground(Color.WHITE);
		
		add(p);
		
		setTitle("Test");
		setSize(600, 400);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paintPanel() {
		Graphics g = p.getGraphics();
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(10));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.drawLine(420, 50, 420, 300);
	}
}
