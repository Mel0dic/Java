/**
 * You are given a 2-d matrix where each cell represents number of coins in that cell. Assuming we start at matrix[0][0], and can only move right or down, find the maximum number of coins you can collect by the bottom right corner.
 *
 * For example, in this matrix
 *
 * 0 3 1 1
 * 2 0 0 4
 * 1 5 3 1
 * The most we can collect is 0 + 2 + 1 + 5 + 3 + 1 = 12 coins.
 */

public class matrixMoves{

	public static void main(String[] args){
		int[][] arr = {{0, 3, 1, 1}, {2, 0, 0, 4}, {1, 5, 3, 1}};
		System.out.println(mostCoins(arr, 0, 0));
	}

	public static int mostCoins(int[][] grid, int xPos, int yPos){
		//If we have reached the bottom right corener return the coin number in that cell
		if(xPos == (grid[0].length - 1) && yPos == (grid.length - 1) ){
			return grid[grid.length-1][grid[0].length-1];
		}

		//Set the move scores to score in current cell
		int xMoveScore = grid[yPos][xPos];
		int yMoveScore = grid[yPos][xPos];

		//if we have reached the end of x or y just move down or right respectively else get both moves and add to x or y move score
		if(xPos == (grid[0].length - 1)){
			yMoveScore += mostCoins(grid, xPos, yPos+1);
		}else if(yPos == (grid.length - 1)){
			xMoveScore += mostCoins(grid, xPos+1, yPos);
		}else{
			xMoveScore += mostCoins(grid, xPos+1, yPos);
			yMoveScore += mostCoins(grid, xPos, yPos+1);
		}

		//Return the highest plus the score in that cell
		return (xMoveScore > yMoveScore) ? (xMoveScore) : (yMoveScore);
	}

}