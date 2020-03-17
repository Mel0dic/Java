package com.bgrummitt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class GUI extends JFrame{

    private GridPanel gridPanel;
    private JButton solveButton;
    private JButton clearButton;

    public static void main(String[] args) {

        GUI frame = new GUI("A* Visualiser");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

//        int[][] positions = frame.getStartEndPositions();
//
//        if(positions[0][0] == -1){
//            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
//        }else{
//            for(int[] row : positions){
//                for(int i : row){
//                    System.out.println(i);
//                }
//            }
//        }
    }

    public GUI(String Name){
        super(Name);

        // Layout Buttons In JPanel
        JPanel buttonLayout = new JPanel();
        buttonLayout.setLayout(new BorderLayout());
        solveButton = new JButton("Solve");
        buttonLayout.add(solveButton, BorderLayout.EAST);
        clearButton = new JButton("Clear");
        buttonLayout.add(clearButton, BorderLayout.WEST);

        // Create new X by Y grid of maze
        gridPanel = new GridPanel(40, 40);

        // Add buttons and maze to JFrame
        setLayout(new BorderLayout());
        add(gridPanel, BorderLayout.NORTH);
        add(buttonLayout, BorderLayout.SOUTH);

        // Set solve button to solve maze display it and then disable solve button until cleared
        solveButton.addActionListener((ActionEvent e) -> {
            int[][] maze = gridPanel.getMaze();
            AStar solver = new AStar(maze);
            int[][] startEnd = getStartEndPositions(maze);
            int[][] solvedMaze = solver.solveMaze(startEnd[0], startEnd[1]);
            gridPanel.setSolvedMaze(solvedMaze);
            solveButton.setEnabled(false);
        });

        // Set clear button to reset the maze to original state and allow solve button
        clearButton.addActionListener((ActionEvent e) -> {
            gridPanel.clearMaze();
            solveButton.setEnabled(true);
        });
    }

    public int[][] getStartEndPositions(int[][] maze){
        int[][] positions = new int[2][2];

        JPanel dialogPanel = new JPanel();
        dialogPanel.setLayout(new GridLayout(4,1));
        JTextField startPosition = new JTextField();
        JTextField endPosition = new JTextField();
        JLabel startLabel = new JLabel("Enter Start Position (x,y):");
        JLabel endLabel = new JLabel("Enter End Position (x,y):");
        startLabel.setToolTipText("0,0");
        endLabel.setToolTipText("49,49");
        System.out.println(startLabel.getToolTipText());
        dialogPanel.add(startLabel);
        dialogPanel.add(startPosition);
        dialogPanel.add(endLabel);
        dialogPanel.add(endPosition);

        int s = JOptionPane.showConfirmDialog(this, dialogPanel, "Please Enter Start And End Positions", JOptionPane.OK_OPTION);

        System.out.println(s);

        if(s == 0){
            String startText = startPosition.getText();
            String endText = endPosition.getText();

            String[] startNumbers = startText.replaceAll("\\s+","").split(",");
            String[] endNumbers = endText.replaceAll("\\s+","").split(",");

            positions[0][0] = Integer.parseInt(startNumbers[0]);
            positions[0][1] = Integer.parseInt(startNumbers[1]);
            positions[1][0] = Integer.parseInt(endNumbers[0]);
            positions[1][1] = Integer.parseInt(endNumbers[1]);
        }else{
            positions[0][0] = -1;
        }

        return positions;
    }
}
