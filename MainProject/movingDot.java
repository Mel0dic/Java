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

		xSpeed = rand.nextInt(1) - 1;
		ySpeed = rand.nextInt(1) - 1;

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
		}

	}

	public void moveTheDot(){
		x = 150;
		y = 150;
		while(true){
			panelY = drawPanel.getHeight()/2;
			moveDot();
			changeDirection();
			try{
				Thread.sleep(5);
			}catch(Exception E){System.out.println(E);}
			frame.repaint();
			System.out.println(String.format("X = %d, Y = %d", x, y));
		}
	}

	public void moveDot(){
		x += xSpeed;
		y += ySpeed;
	}

	public void changeDirection(){
		if(y <= 5 || y >= (drawPanel.getHeight()-15) ){ySpeed*=-1;}
		if(x <= 0 || x >= (drawPanel.getWidth()-15) ){xSpeed*=-1;}
	}

}

class Control implements KeyListener{

	int puckDirection = 0;

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==e.VK_UP){
			puckDirection = -1;
		}else if(e.getKeyCode()==e.VK_DOWN){
			puckDirection = 1;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		puckDirection = 0;
	}
	
}