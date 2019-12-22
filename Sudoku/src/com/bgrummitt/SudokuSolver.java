package com.bgrummitt;

public class SudokuSolver {

	Board sudoku;

	public SudokuSolver(Board board){
		sudoku = board;
		System.out.println((checkSection(board.getRow(5))));
	}

	public Board solveBoard(){
		return sudoku;
	}

	public boolean solveCell(int row, int col){

		if(row > 8){
			return true;
		}

		int number = sudoku.getCell(row, col);
		int[] nextPos = findNextPos(row, col);

		do {
			if (number == 9) {
				sudoku.updateCell(row, col, 0);
				return false;
			}

			do {
				number++;
				sudoku.updateCell(row, col, number);
			} while (!checkIfValid(row, col));

		}while(!solveCell(nextPos[0], nextPos[1]));

		return true;
	}

	private boolean checkIfValid(int row, int col){
		return checkSection(sudoku.getRow(row)) && checkSection(sudoku.getColumn(col)) && checkSection(sudoku.getBox(row, col));
	}

	private static boolean[] numCheck;

	private static boolean checkSection(int[] section){
		numCheck = new boolean[]{false, false, false, false, false, false, false, false, false};

		boolean rowPass = true;

		for(int i = 0; i < 9; i++){
			if(section[i] != 0){
				if(numCheck[section[i] - 1]){
					rowPass = false;
					break;
				}else{
					numCheck[section[i] - 1] = true;
				}
			}
		}

		return rowPass;
	}

	private int[] findNextPos(int row, int col){
		int[] position = new int[2];

		return position;
	}

}
