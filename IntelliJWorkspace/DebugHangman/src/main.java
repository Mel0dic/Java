import javax.swing.*;

public class main {

    private bareBonesMainGUI gui;
    private hangmanPaint startPanel;
    private hangmanGame hangman;

    private JFrame mainJF;
    private JButton enterGuessButton;

    private char guess;
    private String guessedAndYetToGuessWithSpaces;
    private int wordLength = 6;
    private String randomWord;

    public static void main(String[] args){
        main mainClass = new main();
        mainClass.makeJFrame();
        mainClass.makeStartPanel();
        mainClass.makeMainPanel();
    }

    public main(){
        hangman = new hangmanGame(6);
        randomWord = hangman.getRandomWord();
    }

    //Set up the JFrame
    public void makeJFrame(){
        mainJF = new JFrame();
        mainJF.setLocationRelativeTo(null);
        mainJF.setTitle("Test");
        mainJF.setSize(500, 350);
        mainJF.setResizable(false);
        mainJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainJF.setVisible(true);
    }

    public void makeStartPanel(){
        //Create Opening Panel with button to start game
        startPanel = new hangmanPaint();
        JButton startButton = new JButton("Start Game");
        startButton.setBounds(50, 125, 100, 20);
        startPanel.add(startButton);

        mainJF.add(startPanel);

        //Add event to button to switch frame on press and call beginGame
        startButton.addActionListener(e -> {
            mainJF.remove(startPanel);
            mainJF.add(gui);
            mainJF.revalidate();
            mainJF.repaint();
        });
    }

    public void makeMainPanel(){
        gui = new bareBonesMainGUI();

        //Add button for accepting guess
        enterGuessButton = new JButton("Enter");
        enterGuessButton.setBounds(130, 40, 72, 20);
        gui.add(enterGuessButton);
        //Update label of unguessed and guessed letters
        gui.setLetterToAndAlreadyGuessed(hangman.labelWord());
        enterGuessButton.addActionListener(e -> {
            guess = gui.getGuess();
            if(hangman.guess(guess) == true){hangman.updateGuessedLetters(guess);}
            if(hangman.winLoseChecker() == 1){
                win();
            }else if(hangman.winLoseChecker() == 2){
                lose();
            }
        });
    }

    public void win(){
        System.out.println("Win");
    }

    public void lose(){
        System.out.println("Lose");
    }

}
