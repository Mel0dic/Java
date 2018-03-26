import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.Random;
import java.lang.Math;
import java.lang.System;
import java.awt.Font;

public class movingDot{

	private Random rand = new Random();
	private JFrame frame;
	private DrawPanel drawPanel;
	private int x;
	private int xSpeed=1;
	private int y;
	private int ySpeed=	1;
	private int panelY;
	private int puckDirection = 0;
	private int points = 0;
	private double old_time = 1;

	public static void main(String[] args){
		new movingDot();
	}

	public movingDot(){
		frame = new JFrame("Test BG");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		drawPanel = new DrawPanel();

		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(300, 300);
		frame.setLocation(375, 55);	

		xSpeed = 1;
		ySpeed = (int) Math.pow(-1, rand.nextInt(3)+1);

		moveTheDot();
	}

	class DrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			g.setColor(Color.red);
			g.fillRect(0, 0, this.getWidth(), 5);
			g.fillRect((this.getWidth()-5), 0, 5, this.getHeight());
			g.fillRect(0, (this.getHeight()-5), this.getWidth(), 5);
			g.setColor(Color.black);
			g.fillOval(x, y, 10, 10);
			g.fillRect(5, panelY, 10, 30);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			// g.setColor(Color.yellow);
			g.drawString(Integer.toString(points), 265, 23);
		}
	}

	public void moveTheDot(){
		frame.addKeyListener(new MoveThePadel());
		x = 150;
		y = 150;
		panelY = drawPanel.getHeight()/2;
		while(true){
			moveDot();
			movePadel();
			changeDirection();
			// System.out.println(String.format("FPS = %2.0f", get_fps(first_Time)));
			try{
				Thread.sleep(10);
			}catch(Exception E){System.out.println(E);}
			frame.repaint();
			// System.out.println(String.format("X = %d, Y = %d", x, y));
		}
	}

	public void moveDot(){
		x += xSpeed;
		y += ySpeed;
	}

	public void movePadel(){
		if(panelY > 5 && (panelY) < (drawPanel.getHeight()-35)){panelY += puckDirection;}
		else if(panelY == 5 && puckDirection == 1){panelY += puckDirection;}
		else if(panelY >= (drawPanel.getHeight()-35) && puckDirection == -1){panelY += puckDirection;}
	}

	public void changeDirection(){
		//If puck reaches the top / bottom change the direction of the puck
		if(y <= 5 || y >= (drawPanel.getHeight()-15) ){ySpeed*=-1;}
		//If puck reaches either side change direction
		if(x >= (drawPanel.getWidth()-15) ){xSpeed*=-1;}
		//If puck hits padel
		if(x == 15 && y >= panelY && y <= (panelY + 30)){xSpeed*=-1;}

		//If ball passes past homepoint
		if(x < 0){x = 150; y = 150; xSpeed = 1; points++;}
	}

	class MoveThePadel implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			//If UP Arrow is pressed set direction to -1
			if(e.getKeyCode() == KeyEvent.VK_UP){puckDirection = -1;}
			//If Down Arrow is pressed set direction to 1
			if(e.getKeyCode() == KeyEvent.VK_DOWN){puckDirection = 1;}
		}

		//Set the direction to 0 after the release of the key.
		@Override
		public void keyReleased(KeyEvent e) {
			puckDirection = 0;
		}

		//Need For Compilation without errors
		@Override
		public void keyTyped(KeyEvent e){}
	}

}