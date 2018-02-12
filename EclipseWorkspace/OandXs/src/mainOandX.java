import java.util.Random;
import java.util.Scanner;

public class mainOandX {

	private static String[][] board = new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
	private static Boolean isComplete = false;
	private static Scanner reader = new Scanner(System.in);
	private static String playChar = "X";
	private static String compChar = "O";
	private static Random rand = new Random();
	private static int play = 0;
	private static Boolean positionFound;
	
	public static void main(String[] args) {
		System.out.println("Player is X, computer is O. The board is numbers as followed:");
		printBoard(0);
		
		play();
	}
	
	public static void play() {
		while(!isComplete || play != 9) {
			System.out.println("What position would you like to play?");
			try {
				int s = 0;
				while(true) {
					s = reader.nextInt();
					if(board[s/3][s%3] == " ") {board[s/3][s%3] = playChar; break;}
					else{}
				}
				if(testWin(s, playChar) == true) {System.out.println("Congrats You Win");}
				computerPlay();
				play+=2;
				printBoard(1);
			}catch(Exception e){
				System.out.println("please input an int between 0 and 8");
			}
		}
	}
	
	public static boolean testWin(int position, String player) {
		int row = position / 3;
		int column = position % 3;
		if(board[row][0] == player && board[row][1] == player && board[row][2] == player) {isComplete = true; return true;}
		if(board[0][column] == player && board[1][column] == player && board[2][column] == player) {isComplete = true; return true;}
		if((board[0][0] == player && board[1][1] == player && board[2][2] == player) || (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {isComplete = true; return true;}
		return false;
	}
	
	public static void computerPlay() {
		int position = 0;
		positionFound = false;
		while(!positionFound) {
			position = rand.nextInt(9);
			int row = position / 3;
			int column = position % 3;
			if(board[row][column] == " ") {board[row][column] = compChar;positionFound = true;}
		}
		if(testWin(position, compChar) == true) {System.out.println("Unlucky the computer won this one.");}
	}
	
	public static void printBoard(int fullBoard) {
		for(int i = 0; i < 9; i += 3) {
			System.out.println("+---+---+---+");
			for(int f = 0; f < 3; f++) {
				if(fullBoard == 0) {
					System.out.printf("| %s ", Integer.toString(i + f));
				}else {
					System.out.printf("| %s ", board[i/3][f]);
				}
			}
			System.out.printf("|\n");
		}
		System.out.println("+---+---+---+");
	}
	
}
