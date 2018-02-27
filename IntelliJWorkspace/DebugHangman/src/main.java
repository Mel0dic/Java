import javax.swing.*;

public class main {

    private bareBonesMainGUI gui;
    private hangmanPaint startPanel;

    private JFrame mainJF;
    private JButton enterGuessButton;

    public static void main(String[] args){
        main mainClass = new main();
        mainClass.makeJFrame();
        mainClass.makeStartPanel();
        mainClass.makeMainPanel();
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
            mainJF.repaint();
        });
    }

    public void idek(){
        mainJF.add(gui);
    }

    public void makeMainPanel(){
        gui = new bareBonesMainGUI();

        //Add button for accepting guess
        enterGuessButton = new JButton("Enter");
        enterGuessButton.setBounds(130, 40, 72, 20);
        gui.add(enterGuessButton);
        enterGuessButton.addActionListener(e -> {
            //todo add enter guess
        });
    }

}
