import javax.swing.*;

public class main {

    private bareBonesMainGUI gui;
    private hangmanPaint startPanel;
    private hangmanGame hangman;
    private hangmanPaint endGameJPanel;

    private JFrame mainJF;
    private JButton enterGuessButton;

    private char guess;

    public static void main(String[] args){
        main mainClass = new main();
        mainClass.makeJFrame();
        mainClass.makeStartPanel();
        mainClass.makeMainPanel();
    }

    public main(){
        hangman = new hangmanGame(6);
        hangman.getRandomWord();
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
        //Update label of yet to guess and guessed letters
        gui.setLetterToAndAlreadyGuessed(hangman.labelWord());
        enterGuessButton.addActionListener(e -> {
            guessMade();
        });
    }

    public void guessMade(){
        guess = gui.getGuess();

        if(hangman.guess(guess) == true){
            hangman.updateGuessedLetters(guess);
            gui.setLetterToAndAlreadyGuessed(hangman.labelWord());
        }else{
            gui.updateGuessedLeft(hangman.getGuessesLeft());
            gui.updateCount();
        }

        gui.resetGuessArea();

        if(hangman.winLoseChecker() == 1){
            win();
        }else if(hangman.winLoseChecker() == 2){
            lose();
        }
    }

    public void win(){
        endGameJPanel = endGamePanel();

        mainJF.remove(gui);
        mainJF.add(endGameJPanel);
        mainJF.revalidate();
        mainJF.repaint();
    }

    public void lose(){
        endGameJPanel = endGamePanel();

        mainJF.remove(gui);
        mainJF.add(endGameJPanel);
        mainJF.revalidate();
        mainJF.repaint();
    }

    public hangmanPaint endGamePanel() {
        hangmanPaint finale = new hangmanPaint();
        JButton restart = new JButton("Restart");
        restart.setBounds(50, 125, 100, 20);
        restart.addActionListener(e -> {
            hangman = new hangmanGame(6);

            makeStartPanel();
            makeMainPanel();

            mainJF.remove(endGameJPanel);
            mainJF.add(startPanel);

            mainJF.revalidate();
            mainJF.repaint();
        });
        finale.add(restart);

        return finale;
    }

}
