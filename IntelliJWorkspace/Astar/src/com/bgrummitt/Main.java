package com.bgrummitt;

public class Main {

    private static final int[][] maze = {{0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                                         {0, 0, 0, 0, 1, 0, 0, 0, 0, 0}};

    public static void main(String[] args) {

        AStar test = new AStar(maze);

        int[][] mazeSolved = test.solveMaze(new int[]{0, 0}, new int[]{9, 9});

        for(int[] row : mazeSolved){
            for(int node : row){
                System.out.print(node);
            }
            System.out.println("");
        }

    }
}
