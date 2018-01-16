import java.util.*;
import java.awt.*; 
import javax.swing.*;

public class matrix01{

	private static final int FONT_SIZE = 20;
	private static JPanel panel = new JPanel(null);
	private static Random random = new Random();
	private static JLabel label[] = new JLabel[30];

	public static void main(String[] args){

		matrix01 main = new matrix01();

		main.go();

	}

	private void go() {
		JFrame frame = new JFrame();
		frame.setSize(600, 400);
		frame.setResizable(false);
		frame.setMinimumSize(new Dimension(300, 200));
		frame.setLocationRelativeTo(null);
		frame.setTitle("MRain");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(panel);
		panel.setBackground(Color.BLACK);

		frame.setVisible(true);

		//Symbol symbols[] = new Symbol[((int) panel.getWidth()/FONT_SIZE)]; Would switch between 29 and 30 for seemingly no reason 30 is preffered - getWidth returned 600 / 590
		Symbol symbols[] = new Symbol[30];

		Symbol symbolic = new Symbol();
		JLabel label = symbolic.labelSetUp(FONT_SIZE, panel, 15);



		while(true){
			try{
				Thread.sleep(500);
			}catch(Exception exe){}
			symbolic.setRandomSymbol();
			label.setBounds((15 * FONT_SIZE), (2 * (FONT_SIZE / 2)), FONT_SIZE, FONT_SIZE);
			frame.revalidate();
			frame.repaint();
		}
	}
}