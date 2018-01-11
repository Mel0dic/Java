import java.util.*;
import java.awt.*; 
import javax.swing.*;

public class testFile extends JFrame{
	public static void main(String[] args){

		JFrame frame = new JFrame("Frame Demo");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel emptyLabel = new JLabel("");

		frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

		frame.pack();

		frame.setVisible(true);

	}
}