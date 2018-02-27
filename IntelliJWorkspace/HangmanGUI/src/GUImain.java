
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class GUImain extends JPanel{

    private static int count = 0;
    private String labelString = "";
    private String wordToGuess;
    private hangman hangmanGame;
    private List<Character> wrongLetters = new ArrayList<>();
    private char[] wordArr;
    private int wordComplete = 0;;
    private int guessesRemaining = 4;
    private int win = 0;

    private JLabel lblNewLabel;
    private JFrame jf;
    private JLabel guessesLeft;
    private JTextField textField;

    public void setup(JLabel label, JTextField tf, JLabel wrongJL, JFrame theJF, String inputWord){
        lblNewLabel = label;
        jf = theJF;
        guessesLeft = wrongJL;
        textField = tf;
        hangmanGame = new hangman();
        wordToGuess = inputWord;
    }

    //beginGame creates the hangManGame class generates the random word
    public void beginGame() {
        System.out.println(wordToGuess);
        wordArr = new char[hangmanGame.getWordLength()];
        for(int i = 0; i < hangmanGame.getWordLength(); i++) {
            wordArr[i] = '_';
        }
        System.out.println(labelString);
        lblNewLabel.setText(labelString);
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
        JLabel winLabel = new JLabel("Congratulations You Win");
        winLabel.setBounds(50, 200, 100, 20);
        add(winLabel);
        win = 1;
    }

    public void gameOver() {
        JLabel loseLabel = new JLabel(String.format("Unlucky the word was %s", wordToGuess));
        loseLabel.setBounds(50, 200, 300, 20);
        add(loseLabel);
        win = 2;
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

    public int getWinCode(){
        return win;
    }
}
