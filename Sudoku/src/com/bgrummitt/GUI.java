package com.bgrummitt;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class GUI extends JFrame {

    private JLabel[][] jLabels = new JLabel[9][9];

    public static void main(String[] args) {

        GUI frame = new GUI("Sudoku");
        // Placeholder size
        frame.setSize(600, 600 + 23);
        //Position frame in centre
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public GUI(String title){

        super(title);

        add(new SudokuCanvas(new Board()));

    }

}
