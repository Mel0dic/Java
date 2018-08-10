import java.util.Arrays;

public class SumIJ{

	public static void main(String[] args){
		int[] l = {1, 2, 3, 4, 5};
		System.out.println(sum(l, 1, 3));
	}

	public static int sum(int[] l, int i, int j){
		int[] tempIntArray = Arrays.copyOfRange(l, i, j);
		int sum = 0;
		for(int number : tempIntArray){
			sum += number;
		}
		return sum;
	}

}