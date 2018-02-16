import javax.swing.*;

public class OandXGUI {

    JFrame mainJF;
    JPanel mainPanel;

    public OandXGUI(){
        mainJF = new JFrame();
        mainPanel = new JPanel(null);

        JLabel mainLabel = new JLabel("Hello");

        mainPanel.add(mainLabel);

        mainJF.setSize(500, 350);
        mainJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainJF.setVisible(true);
    }

    public void main(String[] args){
        OandXGUI gui = new OandXGUI();
    }

}
