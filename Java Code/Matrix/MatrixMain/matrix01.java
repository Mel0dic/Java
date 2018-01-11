import java.util.*;
import java.awt.*; 
import javax.swing.*;

public class matrix01{

	JFrame frame;
	JLabel label;
	char something;
	String printString = "";

	public static void main(String[] args){

		matrix01 main = new matrix01();

		main.go();

	}

	private void go() {
		frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		label = new JLabel("Hello");

		frame.getContentPane().add(BorderLayout.CENTER, label);
		frame.getContentPane().setBackground(Color.BLACK);

		label.setForeground(Color.WHITE);
		label.setText("Centered");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);

		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(750, 500);
		frame.setLocation(375, 55);

		changeWords();
	}

	private void changeWords(){
		while(true){
			try{
				Thread.sleep(1000);
			} catch (Exception exc){}
			something = (char)(0x30A0 + (Math.random() * 96));
			printString += something;
			label.setText(printString);
			frame.repaint();
			System.out.println(something);
		}
	}
}	