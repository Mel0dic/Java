import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.Graphics;
import javax.swing.JFrame;

public class player{

	private int playerDirection = 0;
	private int x = 100;
	private int y = 100;

	public player(JFrame frame){
		frame.addKeyListener(new playerMovement());
	}

	public void moverPlayer(){
		x+=playerDirection;
	}

	class playerMovement implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			//If UP Arrow is pressed set direction to -1
			if(e.getKeyCode() == KeyEvent.VK_RIGHT){playerDirection = 1;}
			//If Down Arrow is pressed set direction to 1
			if(e.getKeyCode() == KeyEvent.VK_LEFT){playerDirection = -1;}
			//If Space button is pressed call jump function
			if(e.getKeyCode() == KeyEvent.VK_SPACE){jump();}
		}

		//Set the direction to 0 after the release of the key.
		@Override
		public void keyReleased(KeyEvent e) {
			playerDirection = 0;
		}

		//Need For Compilation without errors
		@Override
		public void keyTyped(KeyEvent e){}
	}

	public void jump(){
		System.out.println("Jump");
	}

	public void drawPlayer(Graphics g, int blockSize){
		g.fillRect(x, y, (blockSize/2), (blockSize/2));
	}

	public int getPlayerDirection(){
		return playerDirection;
	}

}