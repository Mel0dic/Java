import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

public class gui extends JFrame{

	private static JPanel panel = new JPanel(null);
	private static JButton enter = new JButton("Enter");
	private static JTextField textToEncrypt = new JTextField();
	private static viginere cipher = new viginere();

	public gui(int width, int height){
		//JFrame Properties
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		add(panel);
	}

	public static void main(String[] args){
		gui test = new gui(300, 200);
		panel.setBackground(Color.GRAY);
		test.button();
	}

	public static void button(){
		JButton enter = new JButton("Enter");
		enter.setLayout(null);
		enter.setBounds(115, 130, 70, 30);
		panel.add(enter);
		enter.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
        		System.out.println(cipher.encrypt("Test Test Test", "Test"));
    		} 
		});
	}

}
