package com.bgrummitt;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class GUI extends JFrame {

    private JLabel[][] jLabels = new JLabel[9][9];

    public static void main(String[] args) {

        GUI frame = new GUI();
        frame.setTitle("Sudoku");
        // Placeholder size
        frame.setSize(600, 600);
        //Position frame in centre
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public GUI(){



    }

}
