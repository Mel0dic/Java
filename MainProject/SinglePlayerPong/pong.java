import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import java.lang.Math;
import java.lang.System;
import java.awt.Font;

public class pong{

	private JFrame frame;
	private DrawPanel drawPanel;
	private int panelWidth;
	private int panelHeight;
	private pongBall ball;
	private padel playerPadel;

	public static void main(String[] args){
		new pong();
	}

	public pong(){
		createJFrame();
		panelWidth = drawPanel.getWidth();
		panelHeight = drawPanel.getHeight();
		go();
	}

	public void go(){
		ball = new pongBall(drawPanel);
		playerPadel = new padel(frame, drawPanel);
		while(true){
			ball.update();
			playerPadel.update();
			checkCollision();
			try{
				Thread.sleep(10);
			}catch(Exception E){System.out.println(E);}
			frame.repaint();
		}
	}

	public void checkCollision(){
		if(ball.touches(playerPadel)){
			ball.switchDirection();
		}
	}

	public void createJFrame(){
		frame = new JFrame("Test BG");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		drawPanel = new DrawPanel();
		drawPanel.setPreferredSize(new Dimension(300 , 300));

		frame.getContentPane().add(drawPanel);

		frame.pack();

		// frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocation(375, 55);
	}

	class DrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			drawBorder(g);
			drawBall(g);
			drawPadel(g);
			drawScore(g);
		}
	}

	public void drawBall(Graphics g){
		g.setColor(Color.black);
		g.fillOval(ball.getXpos(), ball.getYpos(), 10, 10);
	}

	public void drawPadel(Graphics g){
		g.setColor(Color.black);
		g.fillRect(5, playerPadel.getPadelY(), 10, 30);
	}

	public void drawBorder(Graphics g){
		g.setColor(Color.red);
		g.fillRect(0, 0, panelWidth, 5);
		g.fillRect((panelWidth-5), 0, 5, panelHeight);
		g.fillRect(0, (panelHeight-5), panelWidth, 5);
	}

	public void drawScore(Graphics g){
		g.setColor(Color.black);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		// g.setColor(Color.yellow);
		g.drawString(Integer.toString(ball.getPoints()), 265, 23);
	}

}