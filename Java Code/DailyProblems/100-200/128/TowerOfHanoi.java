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
		if(numberOfDisks >= 1){
			printMoves(numberOfDisks-1, 1, 3, 2);
			System.out.println(String.format(stringFormat, 1, 3));
			printMoves(numberOfDisks-1, 2, 1, 3);
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