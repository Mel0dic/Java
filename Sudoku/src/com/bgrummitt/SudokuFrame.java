package com.bgrummitt;

import javax.swing.*;

public class SudokuFrame {

    private final JFrame frame = new JFrame("Sudoku solver");

    public SudokuFrame(){
        frame.getContentPane().add(new SudokuPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}