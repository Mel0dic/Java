import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class padel{

	private int padelDirection = 0;
	private JPanel drawPanel;
	private int padelYPosition;
	private int jpanelHeight;

	public padel(JFrame frame, JPanel panel){
		frame.addKeyListener(new MoveThePadel());
		drawPanel = panel;
		padelYPosition = (drawPanel.getHeight() / 2);
		jpanelHeight = drawPanel.getHeight();
	}

	public void update(){
		movePadel();
	}

	public void movePadel(){
		if(padelYPosition > 5 && (padelYPosition) < (jpanelHeight-35)){padelYPosition += padelDirection;}
		else if(padelYPosition == 5 && padelDirection == 1){padelYPosition += padelDirection;}
		else if(padelYPosition >= (jpanelHeight-35) && padelDirection == -1){padelYPosition += padelDirection;}
	}

	class MoveThePadel implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			//If UP Arrow is pressed set direction to -1
			if(e.getKeyCode() == KeyEvent.VK_UP){padelDirection = -1;}
			//If Down Arrow is pressed set direction to 1
			if(e.getKeyCode() == KeyEvent.VK_DOWN){padelDirection = 1;}
		}

		//Set the direction to 0 after the release of the key.
		@Override
		public void keyReleased(KeyEvent e) {
			padelDirection = 0;
		}

		//Need For Compilation without errors
		@Override
		public void keyTyped(KeyEvent e){}
	}

	public int getPadelY(){
		return padelYPosition;
	}

}