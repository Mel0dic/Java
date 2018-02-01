import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class gui {

	private JFrame frame;
	private JTextField txtEnterPhraseTo;
	private JTextField txtCipherWord;
	private JLabel lblNewLabel;
	
	//private static viginere cipher = new viginere();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui(300, 200);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public gui(int width, int height) {
		initialize(width, height);
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize(int width, int height) {
		frame = new JFrame();
		frame.setSize(300, 200);
		//frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(null);
		panel.setBackground(Color.GRAY);
		frame.getContentPane().add(panel);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(100, 100, 89, 23);
		panel.add(btnEnter);

		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 134, 264, 27);
		panel.add(lblNewLabel);
		
		txtEnterPhraseTo = new JTextField("Enter phrase to encrypt");
		//txtEnterPhraseTo.setText("Enter phrase to encrypt");
		txtEnterPhraseTo.setBounds(10, 11, 264, 23);
		panel.add(txtEnterPhraseTo);
		txtEnterPhraseTo.setColumns(10);
		
		txtCipherWord = new JTextField("Cipher Word");
		//txtCipherWord.setText("Cipher Word");
		txtCipherWord.setBounds(100, 45, 89, 20);
		panel.add(txtCipherWord);
		txtCipherWord.setColumns(10);
		
		
		btnEnter.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
        		encrypt(txtEnterPhraseTo.getText(), txtCipherWord.getText());
    		} 
		});
	}
	
	public void encrypt(String something, String word) {
		if(something == null || word == null) {
			lblNewLabel.setText("Please Fill Both Fields In");
			System.out.println("Nope");
		}else {
			System.out.println(something);
			lblNewLabel.setText(viginere.encrypt(something, word));
		}
	}
}
