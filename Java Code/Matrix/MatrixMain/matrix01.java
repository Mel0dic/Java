import java.util.*;
import java.awt.*; 
import javax.swing.*;

public class matrix01{

	JFrame frame;
	JLabel label;
	char something;
	String printString = "";
	float fontSize = 20.00f;
	int screenWidth = 750;
	int screenHeight = 500;

	public static void main(String[] args){

		matrix01 main = new matrix01();

		main.go();

	}

	private void go() {
		//Set frame equal to a new JFrame window call test
		frame = new JFrame("Test");
		//Set the program to exit on close??????????????
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Set a new label with Hello as label
		label = new JLabel();
		label.setLayout(new GridLayout((screenWidth/((int)fontSize)), (screenHeight/((int)fontSize))));

		//Add label to the center of the screen
		frame.getContentPane().add(label);
		//Set background color to black
		frame.getContentPane().setBackground(Color.BLACK);

		//Set text to be white
		label.setForeground(Color.WHITE);
		//Have the text be at the co-ordinates
		label.setAlignmentX(0);
		label.setAlignmentX(0);
		//Set the font to current font with size of fontSize
		label.setFont(label.getFont().deriveFont(fontSize));

		//Make the window appear
		frame.setVisible(true);
		//Make it so the window cannot be resized
		frame.setResizable(false);
		//Set the size of the window
		frame.setSize(screenWidth, screenHeight);
		//Set the windows location
		frame.setLocation(375, 55);

		//Call change words function
		changeWords();
	}

	//Create private function changeWords
	private void changeWords(){
		//Create an infinite loop
		while(true){
			//Sleep the program for a second
			try{
				Thread.sleep(1000);
			} catch (Exception exc){}
			//Set a new random Katakana charachter to something
			something = (char)(0x30A0 + (Math.random() * 95));
			//Add something char to printString string
			printString += something;
			//Set the label to the string
			label.setText(printString);
			//Make new edit appear on window
			frame.repaint();

			//Print the char to console
			System.out.println(something);
		}
	}
}