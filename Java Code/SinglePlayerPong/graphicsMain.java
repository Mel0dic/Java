import javax.swing.*;

public class graphicsMain{

	public static void main(String[] args){

	}

	public graphicsMain(){
		JFrame theJF = new JFrame();
		JPanel pongMainPanel = new JPanel();

		theJF.add(pongMainPanel);
		theJF.setVisible(true);
		theJF.setSize(500, 500);
		theJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}