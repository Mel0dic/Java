import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Control implements KeyListener{

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