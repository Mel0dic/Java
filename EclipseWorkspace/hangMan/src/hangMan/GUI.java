package hangMan;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GUI extends JPanel{
	
	private JFrame jf;
	private JFrame startJF;
	private static int count = 0;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton button;
	private String labelString = "";
	private String wordToGuess;
	private hangManMain hangmanGame;
	private List<Character> wrongLetters = new ArrayList<>();
	private char[] wordArr;
	private int wordComplete = 0;
	
	public GUI() {
		//Create Opening JFrame with button to start game
		startJF = new JFrame();
		startJF.setLocationRelativeTo(null);
		startGUI startPanel = new startGUI();
		JButton startButton = new JButton("Start Game");
		startButton.setBounds(50, 125, 100, 20);
		startPanel.add(startButton);
		startJF.setSize(500, 350);
		startJF.setResizable(false);
		startJF.getContentPane().add(startPanel);
		//Add event to button to switch frame on press and call beginGame
		startButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				startJF.setVisible(false);
				jf.setVisible(true);
				beginGame();
				} 
		} );

		startJF.setVisible(true);

		//Create new JFrame as main JFrame
		jf = new JFrame();
		jf.setLocationRelativeTo(null);
		jf.setTitle("Test");
		jf.setSize(500, 350);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);
		//Add the panel that this class extends
		jf.getContentPane().add(this);
		
		//Add text field for entering guess 
		textField = new JTextField();
		textField.setBounds(30, 40, 68, 20);
		add(textField);
		textField.setColumns(10);
		
		//Add button for accepting guess
		button = new JButton("Enter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(108, 40, 72, 20);
		add(button);
		
		//Add label under Graphic for the _ instead of letters
		lblNewLabel = new JLabel("This is where ____ goes");
		lblNewLabel.setBounds(359, 286, 115, 14);
		add(lblNewLabel);
	}
	
	public static void main(String[] args) {
		//Create new gui class
		GUI gui = new GUI();
	}
	
	//beginGame creates the hangManGame class generates the random word
	public void beginGame() {
		hangmanGame = new hangManMain();
		wordToGuess = hangmanGame.getRandomWord();
		System.out.println(wordToGuess);
		wordArr = new char[hangmanGame.getWordLength()];
		for(int i = 0; i < hangmanGame.getWordLength(); i++) {
			wordArr[i] = '_';
		}
		System.out.println(labelString);
		lblNewLabel.setText(labelString);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
					play(textField.getText());
					setLabel();
				} 
		});
	}
	
	public void setLabel() {
		labelString = "";
		for(int i = 0; i < hangmanGame.getWordLength(); i++) {
			labelString += String.format("%s ", wordArr[i]);
		}
		System.out.println(labelString);
		lblNewLabel.setText(labelString);
	}
	
	public void play(String guess) {
		Character guesser = guess.charAt(0);
		if(hangmanGame.guess(wordToGuess, guesser) == true) {
			for(int i = 0; i < hangmanGame.getWordLength(); i++) {
				if(guesser == wordToGuess.charAt(i)) {
					wordArr[i] = guesser;
					wordComplete++;
				}
			}
		}else {
			wrongLetters.add(guesser);
			count++;
			jf.repaint();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setStroke(new BasicStroke(10));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if(count > 0) {
			g2.drawLine(320, 10, 320, 260);
		}
		if(count > 1) {
			g2.drawLine(320, 10, 445, 10);
		}
		if(count > 2) {
			g2.drawLine(300, 260, 470, 260);
		}
		if(count > 3) {
			g2.setStroke(new BasicStroke(7));
			g2.drawLine(320, 200, 400, 260);
		}
		if(count > 4) {
			g2.fillOval(370, 60, 30, 30);
		}
		if(count > 5) {
			g2.drawLine(385, 70, 385, 135);
		}
		if(count > 6) {
			g2.drawLine(385, 135, 390, 145);
		}
		if(count > 7) {
			g2.drawLine(385, 135, 380, 145);
		}
		if(count > 8) {
			g2.drawLine(370, 100, 400, 100);
		}
		if(count > 9) {
			g2.setStroke(new BasicStroke(3));
			g2.drawLine(385, 10, 385, 135);
		}
	}
}

@SuppressWarnings("serial")
class startGUI extends JPanel{
	public startGUI(){
		setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setStroke(new BasicStroke(10));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.drawLine(320, 10, 320, 260);
		g2.drawLine(320, 10, 445, 10);
		g2.drawLine(300, 260, 470, 260);
		g2.setStroke(new BasicStroke(7));
		g2.drawLine(320, 200, 400, 260);
		g2.fillOval(370, 60, 30, 30);
		g2.drawLine(385, 70, 385, 135);
		g2.drawLine(385, 135, 390, 145);
		g2.drawLine(385, 135, 380, 145);
		g2.drawLine(370, 100, 400, 100);
		g2.setStroke(new BasicStroke(3));
		g2.drawLine(385, 10, 385, 135);
	}
}
