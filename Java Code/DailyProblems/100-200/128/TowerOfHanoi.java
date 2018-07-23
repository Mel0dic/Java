import java.util.List;
import java.util.ArrayList;

public class TowerOfHanoi{

	public static String stringFormat = "Move %d to %d";
	private List<Integer> rodOne;
	private List<Integer> rodTwo;
	private List<Integer> rodThree;

	public static void main(String[] args){
		new TowerOfHanoi(4);
	}

	public TowerOfHanoi(int numberOfDisks){
		rodOne = new ArrayList<Integer>();
		rodTwo = new ArrayList<Integer>();
		rodThree = new ArrayList<Integer>();
		for(int i = numberOfDisks; i > 0; i--){
			rodOne.add(i);
		}
		printMoves(numberOfDisks);
	}

	public void printMoves(int numberOfDisks){
		int a = 1;
		int b = 2;
		int c = 3;
		if(numberOfDisks >= 1){
			printMoves(numberOfDisks-1, a, b, c);
			System.out.println(String.format(stringFormat, a, c));
			printMoves(numberOfDisks-1, b, a, c);
		}
	}

	public void printMoves(int numberOfDisks, int a, int b, int c){
		if(numberOfDisks >= 1){
			printMoves(numberOfDisks-1, a, c, b);
			System.out.println(String.format(stringFormat, a, c));
			printMoves(numberOfDisks-1, b, a, c);
		}
	}

}