import java.util.*;
import java.awt.*; 
import javax.swing.*;

public class matrix01{

	private static final int FONT_SIZE = 11;
	private static final int NUMBER_OF_REPEATS = 5;
	private static JPanel panel = new JPanel(null);
	private static Random random = new Random();
	private static JLabel label[] = new JLabel[NUMBER_OF_REPEATS];

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

		JLabel label = new JLabel(""+((char)(0x30A0)));
		label.setForeground(Color.GREEN);
		panel.add(label);

		label.setFont(label.getFont().deriveFont((float)FONT_SIZE));
		label.setBounds(5*FONT_SIZE, 20*(FONT_SIZE / 2), FONT_SIZE, FONT_SIZE);

		frame.setVisible(true);

		Symbol symbolic = new Symbol();
		symbolic.setJLabel(label);

		while(true){
			try{
				Thread.sleep(500);
			}catch(Exception exe){}
			symbolic.setRandomSymbol();
		}
	}
}