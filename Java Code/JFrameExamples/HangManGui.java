import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;

public class HangManGui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangManGui window = new HangManGui();
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
	public void HangManGUI() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(null);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JTextField guessArea = new JTextField();
		panel.add(guessArea);
		
		JLabel outPutArea = new JLabel("");
		outPutArea.setBounds(274, 11, 150, 239);
		panel.add(outPutArea);
		
		
	}
}
