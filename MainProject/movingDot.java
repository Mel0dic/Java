import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;

public class movingDot{

	private JFrame frame;
	private DrawPanel drawPanel;
	private int x;
	private int y;
	private int panelY;
	private int dir = 1;

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

		moveTheDot();
	}

	class DrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			g.setColor(Color.red);
			g.fillRect(0, 0, this.getWidth(), 5);
			g.fillRect((this.getWidth()-5), 0, 5, this.getHeight());
			g.fillRect(0, (this.getHeight()-5), this.getWidth(), 5);
			g.fillRect(x, y, 10, 10);
			g.fillRect(5, panelY, 10, 30);
		}

		public int gH(){
			return this.getHeight();
		}
	}

	public void moveTheDot(){
		x = (drawPanel.getHeight()/2);
		y = (drawPanel.getWidth()/2);
		while(true){
			panelY = drawPanel.getHeight()/2;
			moveDot();
			changeDirection();
			try{
				Thread.sleep(50);
			}catch(Exception E){System.out.println(E);}
			frame.repaint();
		}
	}

	public void moveDot(){
		if(dir > 270 || (dir < 90 && dir > 0)){x++;}
		if(dir > 90 && dir < 270){x--;}
		if(dir > 0 && dir < 180){y--;}
		if(dir > 180 && dir < 360){y++;}
	}

	public void changeDirection(){
		if((drawPanel.getWidth() - 10) == y){dir-=180;}
		if((drawPanel.getHeight() - 10) == x){dir-=180;}
	}

}