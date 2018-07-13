/**
 * You have 100 fair coins and you flip them all at the same time. 
 * Any that come up tails you set aside. The ones that come up heads you flip again. 
 * How many rounds do you expect to play before only one coin remains?
 */

public class OneHundredCoins{

	public static void main(String[] args){
		System.out.println(numberOfRounds(100));
	}

	public static int numberOfRounds(int coinNumber){
		int count = 0;

		for(int i = 0; i < coinNumber; i++){
			if(Math.random() >= 0.5){
				count ++;
			}
		}

		return count <= 1 ? 1 : numberOfRounds(count) + 1;
	}

	public static int numberOfRoundsMath(int coinNumber, int coinsLeft){
		return 0;
	}

}