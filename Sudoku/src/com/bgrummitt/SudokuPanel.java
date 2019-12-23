package com.bgrummitt;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

class SudokuPanel extends JPanel {

    private JTextField[][] grid;
    private Map<JTextField, Point> mapFieldToCoordinates = new HashMap<>();

    private JPanel gridPanel;
    private JPanel buttonPanel;
    private JButton solveButton;
    private JButton clearButton;
    private JPanel[][] subSquarePanels;

    public SudokuPanel(){
        this.grid = new JTextField[9][9];

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

        for(int y = 0; y < 9; ++y) {
            for(int x = 0; x < 9; ++x) {
                JTextField field = grid[y][x];
                field.setBorder(border);
                field.setPreferredSize(fieldDimension);
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
        clearButton = new JButton("Clear");
        solveButton = new JButton("Solve");

        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(clearButton, BorderLayout.WEST);
        buttonPanel.add(solveButton, BorderLayout.EAST);

        setLayout(new BorderLayout());
        add(gridPanel,   BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        clearButton.addActionListener((ActionEvent e) -> {
            clearAll();
        });

        solveButton.addActionListener((ActionEvent e) -> {
            // TODO ADD SOLVE FUNCTION WITH VISUALISATION
        });
    }

    void clearAll(){
        for (JTextField[] row : grid) {
            for (JTextField field : row) {
                field.setText("");
            }
        }
    }

}