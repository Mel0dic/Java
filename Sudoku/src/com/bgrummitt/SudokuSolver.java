package com.bgrummitt;

public class SudokuSolver {

	Board sudoku;

	public SudokuSolver(Board board){
		sudoku = board;
	}

	public Board solveBoard(){
		int[] pos = {0, 0};

		if(sudoku.getCell(0, 0) != 0){
			pos = findNextPos(0, 0);
		}

		solveCell(pos[0], pos[1]);

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
				if(number == 10){
					sudoku.updateCell(row, col, 0);
					return false;
				}
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
		int[] position = {row, col};

		try {

			do {
				if (position[1] == 8) {
					position[0]++;
					position[1] = 0;
				} else {
					position[1]++;
				}
			} while (sudoku.getCell(position[0], position[1]) != 0);

		}catch (ArrayIndexOutOfBoundsException err){
			position[0] = 9;
			position[1] = 0;
		}

		return position;
	}

}
