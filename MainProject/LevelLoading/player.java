import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.Graphics;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JFrame;

public class player{

	private int playerXDirection = 0;
	private int playerYDirection = 0;
	private int x = 100;
	private int y = 100;
	private int speed = 1;
	private int playerSize;
	private int countJump = 0;
	private int leftWall;
	private int rightWall;
	private int blockSize;
	private boolean jump = false;

	public player(JFrame frame, int blockSize, int leftWall, int rightWall){
		frame.addKeyListener(new playerMovement());
		playerSize = (int) blockSize/2;
		this.blockSize = blockSize;
		this.leftWall = leftWall;
		this.rightWall = rightWall + playerSize;
	}

	public void moverPlayer(){
		if(x > leftWall && x < rightWall){
			x+=playerXDirection;
		}else if(x == rightWall && playerXDirection == -1){
			x+=playerXDirection;
		}else if(x == leftWall && playerXDirection == 1){
			x+=playerXDirection;
		}
		y+=playerYDirection;
	}

	class playerMovement implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			//If UP Arrow is pressed set direction to -1
			if(e.getKeyCode() == KeyEvent.VK_RIGHT){playerXDirection = speed;}
			//If Down Arrow is pressed set direction to 1
			if(e.getKeyCode() == KeyEvent.VK_LEFT){playerXDirection = -speed;}
			//If Space button is pressed call jump function
			if(e.getKeyCode() == KeyEvent.VK_SPACE){
				jump = true;
			}
		}

		//Set the direction to 0 after the release of the key.
		@Override
		public void keyReleased(KeyEvent e) {
			playerXDirection = 0;
			jump = false;
		}

		//Need For Compilation without errors
		@Override
		public void keyTyped(KeyEvent e){}
	}

	public void playerOnPlatform(List<List<Integer>> platformCoords, int floor){
		if(jump && ((countJump > 0 && countJump < 50) || playerYDirection == 0)){
			playerYDirection = -1;
			countJump++;
			return;
		}else{
			countJump = 0;
		}
		for(List<Integer> secondDimension : platformCoords){
			if(((x+playerSize) >= secondDimension.get(0) && x <= secondDimension.get(1) && (y + playerSize) == secondDimension.get(2)) || (y + playerSize) >= floor){
				playerYDirection = 0;
				return;
			}
		}
		playerYDirection = 1;
	}

	public void drawPlayer(Graphics g){
		playerSize = (int)(blockSize/2);
		g.setColor(Color.orange);
		g.fillRect(x, y, playerSize, playerSize);
	}

	public int getPlayerXDirection(){
		return playerXDirection;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

}