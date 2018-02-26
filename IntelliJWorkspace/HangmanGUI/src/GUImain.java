
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
public class GUImain extends JPanel{

    private JFrame jf;
    private JFrame mainJF;
    private static int count = 0;
    private JTextField textField;
    private JLabel lblNewLabel;
    private JButton button;
    private String labelString = "";
    private String wordToGuess;
    private hangman hangmanGame;
    private List<Character> wrongLetters = new ArrayList<>();
    private char[] wordArr;
    private int wordComplete = 0;
    private JLabel guessesLeft;
    private int guessesRemaining = 4;

    public GUImain() {
        //Create Opening JFrame with button to start game
        mainJF = new JFrame();
        mainJF.setLocationRelativeTo(null);
        startGUI startPanel = new startGUI();
        JButton startButton = new JButton("Start Game");
        startButton.setBounds(50, 125, 100, 20);
        startPanel.add(startButton);
        mainJF.setSize(500, 350);
        mainJF.setResizable(false);
        mainJF.getContentPane().add(startPanel);
        //Add event to button to switch frame on press and call beginGame
        startButton.addActionListener(e -> {
            mainJF.remove(startPanel);
            mainJF.add(this);
            beginGame();
        });

        mainJF.setVisible(true);

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
        textField.setBounds(52, 40, 68, 20);
        add(textField);
        textField.setColumns(10);

        //Add button for accepting guess
        button = new JButton("Enter");
        button.addActionListener(e -> {
            //todo something
        });
        button.setBounds(130, 40, 72, 20);
        add(button);

        //Add label under Graphic for the _ instead of letters
        lblNewLabel = new JLabel("This is where ____ goes");
        lblNewLabel.setBounds(359, 286, 115, 14);
        add(lblNewLabel);

        guessesLeft = new JLabel("You Have 4 Guesses Remaining!");
        guessesLeft.setBounds(40, 71, 218, 27);
        add(guessesLeft);

        JLabel lblEnterYourGuess = new JLabel("Enter Your Guess Here");
        lblEnterYourGuess.setBounds(66, 15, 150, 14);
        add(lblEnterYourGuess);
    }

    //beginGame creates the hangManGame class generates the random word
    public void beginGame() {
        hangmanGame = new hangman();
        wordToGuess = hangmanGame.getRandomWord();
        System.out.println(wordToGuess);
        wordArr = new char[hangmanGame.getWordLength()];
        for(int i = 0; i < hangmanGame.getWordLength(); i++) {
            wordArr[i] = '_';
        }
        System.out.println(labelString);
        lblNewLabel.setText(labelString);

        button.addActionListener(e ->  {
            play(textField.getText());
            setLabel(); });
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
            if(wordComplete == hangmanGame.getWordLength()) {
                win();
            }
        }else {
            wrongLetters.add(guesser);
            count++;
            guessesRemaining--;
            guessesLeft.setText(String.format("You have %d guesses remaining!", guessesRemaining));
            jf.repaint();

            if(guessesRemaining == 0) {
                System.out.println("Game Over");
                gameOver();
            }
        }
        textField.setText("");
    }

    public void win() {
        startGUI endGamePanel = endGame();
        JLabel winLabel = new JLabel("Congratulations You Win");
        winLabel.setBounds(50, 200, 100, 20);
        endGamePanel.add(winLabel);
    }

    public void gameOver() {
        startGUI endGamePanel = endGame();
        JLabel loseLabel = new JLabel(String.format("Unlucky the word was %s", wordToGuess));
        loseLabel.setBounds(50, 200, 300, 20);
        endGamePanel.add(loseLabel);
    }

    public startGUI endGame() {
        JFrame endGameJF = new JFrame();
        startGUI gui = new startGUI();
        endGameJF.setSize(500, 350);
        endGameJF.setResizable(false);
        endGameJF.getContentPane().add(gui);
        endGameJF.setLocationRelativeTo(null);
        JButton restart = new JButton("Restart");
        restart.setBounds(50, 125, 100, 20);
        restart.addActionListener(e -> {
            //todo add restart function
        });
        gui.add(restart);
        jf.setVisible(false);
        endGameJF.setVisible(true);

        return gui;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setStroke(new BasicStroke(10));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if(count > 0) {
            g2.drawLine(300, 260, 470, 260);
            g2.setStroke(new BasicStroke(7));
            g2.drawLine(320, 200, 400, 260);
            g2.setStroke(new BasicStroke(10));
        }
        if(count > 1) {
            g2.drawLine(320, 10, 320, 260);
            g2.drawLine(320, 10, 445, 10);
        }
        if(count > 2) {
            g2.fillOval(370, 60, 30, 30);
            g2.drawLine(385, 70, 385, 135);
            g2.drawLine(385, 135, 390, 145);
            g2.drawLine(385, 135, 380, 145);
            g2.drawLine(370, 100, 400, 100);
        }
        if(count > 3) {
            g2.setStroke(new BasicStroke(3));
            g2.drawLine(385, 10, 385, 135);
        }
    }
}
