import java.util.List;
import java.util.ArrayList;

public class TowerOfHanoi{

	public static String stringFormat = "Move %i to %i";
	private List<Integer> rodOne;
	private List<Integer> rodTwo;
	private List<Integer> rodThree;

	public static void main(String[] args){
		new TowerOfHanoi(3).printMoves();
	}

	public TowerOfHanoi(int numberOfDisks){
		rodOne = new ArrayList<Integer>();
		rodTwo = new ArrayList<Integer>();
		rodThree = new ArrayList<Integer>();
		for(int i = numberOfDisks; i > 0; i--){
			rodOne.add(i);
		}
	}

	public void printMoves(){
		for(int i : rodOne){
			System.out.println(i);
		}
		System.out.println(rodThree.size());
	}

}