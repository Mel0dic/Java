import javax.swing.*;
import java.awt.*;

public class bareBonesMainGUI extends JPanel{

    private int count = 0;
    private JTextField textField;
    private JLabel letterToAndAlreadyGuessed;
    private JLabel guessesLeft;
    private JLabel lblEnterYourGuess;

    public bareBonesMainGUI(){
        //Set the layout to null
        setLayout(null);

        //Add text field for entering guess
        textField = new JTextField();
        textField.setBounds(52, 40, 68, 20);
        add(textField);
        textField.setColumns(10);

        //Add label under Graphic for the _ instead of letters
        letterToAndAlreadyGuessed = new JLabel("This is where ____ goes");
        letterToAndAlreadyGuessed.setBounds(359, 286, 115, 14);
        add(letterToAndAlreadyGuessed);

        //New JLabel
        guessesLeft = new JLabel("You Have 4 Guesses Remaining!");
        guessesLeft.setBounds(40, 71, 218, 27);
        add(guessesLeft);

        //New JLabel
        lblEnterYourGuess = new JLabel("Enter Your Guess Here");
        lblEnterYourGuess.setBounds(66, 15, 150, 14);
        add(lblEnterYourGuess);
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

    public char getGuess(){
        return textField.getText().charAt(0);
    }

    public void setLetterToAndAlreadyGuessed(String setLabel){
        letterToAndAlreadyGuessed.setText(setLabel);
    }

    private void updateCount(){
        count++;
    }

}
