package com.bgrummitt;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

class SudokuPanel extends JPanel {

    public static final Border defaultBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
    public static final Border solvedBorder = BorderFactory.createLineBorder(Color.GREEN, 1);
    public static final Border solvingBorder = BorderFactory.createLineBorder(Color.RED, 1);

    private JTextField[][] grid;
    private Map<JTextField, Point> mapFieldToCoordinates = new HashMap<>();

    private Board sudoku;
    private JPanel gridPanel;
    private JPanel buttonPanel;
    private JButton solveButton;
    private JButton resetButton;
    private JPanel[][] subSquarePanels;

    public SudokuPanel(Board sudokuBoard){
        grid = new JTextField[9][9];
        sudoku = sudokuBoard;

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                JTextField field = new JTextField();
                mapFieldToCoordinates.put(field, new Point(j, i));
                grid[i][j] = field;
                grid[i][j].setHorizontalAlignment(JLabel.CENTER);
            }
        }

        gridPanel   = new JPanel();
        buttonPanel = new JPanel();

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        Dimension fieldDimension = new Dimension(50, 50);

        for(int i = 0; i < 9; i++) {
            int[] rowNumbs = sudokuBoard.getRow(i);
            for(int j = 0; j < 9; j++) {
                JTextField field = grid[i][j];
                field.setBorder(border);
                field.setPreferredSize(fieldDimension);
                if(rowNumbs[j] != 0){
                    field.setText(Integer.toString(rowNumbs[j]));
                    field.setEditable(false);
                }
            }
        }

        gridPanel.setLayout(new GridLayout(3, 3));

        subSquarePanels = new JPanel[3][3];

        Border subSquareBorder = BorderFactory.createLineBorder(Color.BLACK, 1);

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(3, 3));
                panel.setBorder(subSquareBorder);
                subSquarePanels[i][j] = panel;
                gridPanel.add(panel);
            }
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                int subSquareX = j / 3;
                int subSquareY = i / 3;

                subSquarePanels[subSquareY][subSquareX].add(grid[i][j]);
            }
        }

        gridPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        resetButton = new JButton("Clear");
        solveButton = new JButton("Solve");

        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(resetButton, BorderLayout.WEST);
        buttonPanel.add(solveButton, BorderLayout.EAST);

        setLayout(new BorderLayout());
        add(gridPanel,   BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        resetButton.addActionListener((ActionEvent e) -> {
            solveButton.setEnabled(true);
            clearAll();
        });

        solveButton.addActionListener((ActionEvent e) -> {
            SudokuSolver sudokuSolver = new SudokuSolver(new Board(), this);
            sudokuSolver.start();
            solveButton.setEnabled(false);
        });
    }

    void clearAll(){
        for (JTextField[] row : grid) {
            for (JTextField field : row) {
                field.setText("");
            }
        }
    }

    public JTextField getPanel(int row, int col){
        return grid[row][col];
    }

}