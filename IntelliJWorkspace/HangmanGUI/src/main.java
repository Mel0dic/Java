import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {

    private GUImain gui;
    private JFrame mainJF;
    private int count = 0;
    private JTextField textField;
    private JLabel lblNewLabel;
    private JButton button;
    private JLabel guessesLeft;
    private String wordToGuess = "PlaceHolder";

    public static void main(String[] args) {
        main mainClass = new main();
        mainClass.makeJFrame();
        mainClass.makeStartPanel();
        mainClass.makeEndPanel();
    }

    public main(){
        gui = new GUImain();
    }

    public void makeJFrame(){
        mainJF.setLocationRelativeTo(null);
        mainJF.setTitle("Test");
        mainJF.setSize(500, 350);
        mainJF.setResizable(false);
        mainJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void makeStartPanel(){
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
            makeMainPanel();
            mainJF.remove(startPanel);
            mainJF.add(gui);
            gui.beginGame();
        });

        mainJF.add(startPanel);
        mainJF.setVisible(true);
    }

    public void makeMainPanel(){
        gui.setLayout(null);
        //Add the panel that this class extends
        mainJF.getContentPane().add(gui);

        //Add text field for entering guess
        textField = new JTextField();
        textField.setBounds(52, 40, 68, 20);
        gui.add(textField);
        textField.setColumns(10);

        //Add button for accepting guess
        button = new JButton("Enter");
        button.addActionListener(e -> {
            //todo add restart game button
        });
        button.setBounds(130, 40, 72, 20);
        gui.add(button);

        //Add label under Graphic for the _ instead of letters
        lblNewLabel = new JLabel("This is where ____ goes");
        lblNewLabel.setBounds(359, 286, 115, 14);
        gui.add(lblNewLabel);

        guessesLeft = new JLabel("You Have 4 Guesses Remaining!");
        guessesLeft.setBounds(40, 71, 218, 27);
        gui.add(guessesLeft);

        JLabel lblEnterYourGuess = new JLabel("Enter Your Guess Here");
        lblEnterYourGuess.setBounds(66, 15, 150, 14);
        gui.add(lblEnterYourGuess);
    }

    public void makeEndPanel(){
        mainJF.remove(gui);
        startGUI endGamePanel = new startGUI();
        JLabel loseLabel = new JLabel(String.format("Unlucky the word was %s", wordToGuess));
        loseLabel.setBounds(50, 200, 300, 20);
        endGamePanel.add(loseLabel);
        JButton restart = new JButton("Restart");
        restart.setBounds(50, 125, 100, 20);
        restart.addActionListener(e -> {
            //todo add restart function
        });
        endGamePanel.add(restart);
        mainJF.add(endGamePanel);
    }

}