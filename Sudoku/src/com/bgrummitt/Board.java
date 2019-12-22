package com.bgrummitt;

public class Board {

    private int[][] board = {{1, 4, 0, 0, 0, 0, 6, 0, 0},
                             {0, 0, 7, 0, 5, 6, 0, 1, 2},
                             {0, 0, 0, 0, 0, 8, 9, 0, 0},
                             {0, 6, 0, 0, 0, 9, 7, 0, 0},
                             {0, 3, 2, 0, 0, 0, 8, 4, 0},
                             {0, 0, 1, 5, 0, 0, 0, 6, 0},
                             {0, 0, 4, 7, 0, 0, 0, 0, 0},
                             {2, 1, 0, 6, 9, 0, 5, 0, 0},
                             {0, 0, 9, 0, 0, 0, 0, 8, 6}};

    public void printBoard(){

        System.out.println("-------------------------------------");
        for(int[] row : board){

            System.out.print("|");

            for(int column : row){
                System.out.printf(" %d |", column);
            }

            System.out.print("\n");
            System.out.println("-------------------------------------");

        }

    }

    public int getCell(int row, int column){
        return board[row][column];
    }

    public void updateCell(int row, int column, int value){
        board[row][column] = value;
    }

    public int[] getRow(int rowNo){
        return board[rowNo];
    }

    public int[] getColumn(int colNo){
        int[] col = new int[9];

        for(int i = 0; i < 9; i++){
            col[i] = board[i][colNo];
        }

        return col;
    }

    public int[] getBox(int row, int col){
        int[] box = new int[9];

        row = (int) Math.floor((float)row / 3);
        col = (int) Math.floor((float)col / 3);

        int boxArrPos = 0;
        for(int i = row * 3; i < (row + 1) * 3; i++){
            for(int j = col * 3; j < (col + 1) * 3; j++){
                box[boxArrPos] = board[i][j];
                boxArrPos++;
            }
        }

        return box;
    }

}
